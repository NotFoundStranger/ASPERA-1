/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.aspera.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByDocument", query = "SELECT i FROM Instructor i WHERE i.document = :document"),
    @NamedQuery(name = "Instructor.findByName", query = "SELECT i FROM Instructor i WHERE i.name = :name"),
    @NamedQuery(name = "Instructor.findByCategory", query = "SELECT i FROM Instructor i WHERE i.category = :category"),
    @NamedQuery(name = "Instructor.findByPassword", query = "SELECT i FROM Instructor i WHERE i.password = :password")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "document",nullable=false)
    private Long document;
    @Basic(optional = false)
   
    @Column(name = "name",nullable=false,length = 100)
    private String name;
    @Basic(optional = false)
    
    @Column(name = "category",nullable=false,length = 20)
    private String category;
    @Basic(optional = false)
    
    @Column(name = "password" ,nullable=false,length = 100)
    private String password;
    @OneToMany(mappedBy = "idInstructor")
    private Collection<Permission> permissionCollection;

    public Instructor() {
    }

    public Instructor(Long document) {
        this.document = document;
    }

    public Instructor(Long document, String name, String category, String password) {
        this.document = document;
        this.name = name;
        this.category = category;
        this.password = password;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Permission> getPermissionCollection() {
        return permissionCollection;
    }

    public void setPermissionCollection(Collection<Permission> permissionCollection) {
        this.permissionCollection = permissionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (document != null ? document.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.aspera.model.Instructor[ document=" + document + " ]";
    }
    
}
