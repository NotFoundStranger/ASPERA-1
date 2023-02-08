/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.aspera.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "career")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Career.findAll", query = "SELECT c FROM Career c"),
    @NamedQuery(name = "Career.findById", query = "SELECT c FROM Career c WHERE c.id = :id"),
    @NamedQuery(name = "Career.findByName", query = "SELECT c FROM Career c WHERE c.name = :name")})
public class Career implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "id",nullable=false)
    private Integer id;
    @Basic(optional = false)
   
    @Column(name = "name",nullable=false,length = 80)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCareer")
    private Collection<Course> courseCollection;

    public Career() {
    }

    public Career(Integer id) {
        this.id = id;
    }

    public Career(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Career)) {
            return false;
        }
        Career other = (Career) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.aspera.model.Career[ id=" + id + " ]";
    }
    
}
