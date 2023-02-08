/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.aspera.persistence;

import co.edu.sena.aspera.model.Apprentice;
import co.edu.sena.aspera.utils.Constants;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aprendiz
 */
@Stateless
public class ApprenticeFacade extends AbstractFacade<Apprentice>{

    @PersistenceContext(unitName = Constants.PERSISTENCE_UNI)
    private EntityManager em;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public ApprenticeFacade(){
        super(Apprentice.class);
    }
}
