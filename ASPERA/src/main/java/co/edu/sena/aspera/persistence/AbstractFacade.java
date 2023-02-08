/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.aspera.persistence;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Aprendiz
 */
public  abstract class AbstractFacade<T> {
   private Class<T>entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
      protected abstract EntityManager getEntityManager();
     
      
      
      public void create(T entity){
          getEntityManager().persist(entity);
      }
      public void edit (T entity){
          getEntityManager().merge(entity);
      }
      public void remove(T entity){
          getEntityManager().remove( getEntityManager().merge(entity));
      }
      public T find(Object id){
          return getEntityManager().find(entityClass, id);
      }
      public List<T> findAll(){
          getEntityManager().getEntityManagerFactory().getCache().evictAll();
          CriteriaQuery criteriaQuery=getEntityManager().getCriteriaBuilder().createQuery();
          criteriaQuery.select(criteriaQuery.from(entityClass));
          return getEntityManager().createQuery(criteriaQuery).getResultList();
      }
       public List<T> findRange(int[]range){
          getEntityManager().getEntityManagerFactory().getCache().evictAll();
          CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
          criteriaQuery.select(criteriaQuery.from(entityClass));
           Query query = getEntityManager().createQuery(criteriaQuery);
           query.setMaxResults(range[1] - range [0] + 1 );
           query.setFirstResult(range[0]);
          return query.getResultList();
      }
       public int count(){
          CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
           Root<T> root = criteriaQuery.from(entityClass);
           criteriaQuery.select(getEntityManager().getCriteriaBuilder().count(root));
            Query query = getEntityManager().createQuery(criteriaQuery);
            return((Long) query.getSingleResult()).intValue();
       }
}
