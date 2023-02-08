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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "apprentice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apprentice.findAll", query = "SELECT a FROM Apprentice a"),
    @NamedQuery(name = "Apprentice.findByDocument", query = "SELECT a FROM Apprentice a WHERE a.document = :document"),
    @NamedQuery(name = "Apprentice.findByFirstName", query = "SELECT a FROM Apprentice a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Apprentice.findByLastName", query = "SELECT a FROM Apprentice a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Apprentice.findByEmail", query = "SELECT a FROM Apprentice a WHERE a.email = :email"),
    @NamedQuery(name = "Apprentice.findByPassword", query = "SELECT a FROM Apprentice a WHERE a.password = :password")})
public class Apprentice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "document", nullable=false)
    private Long document;
    @Basic(optional = false)
    
   
    @Column(name = "first_name",nullable=false, length =50)
    private String firstName;
    @Basic(optional = false)
    
   
    @Column(name = "last_name",nullable=false, length = 50)
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "email",length = 50)
    private String email;
    @Basic(optional = false)
    
    @Column(name = "password",nullable=false, length = 100)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApprentice")
    private Collection<Permission> permissionCollection;
    @JoinColumn(name = "id_course", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course idCourse;

    public Apprentice() {
    }

    public Apprentice(Long document) {
        this.document = document;
    }

    public Apprentice(Long document, String firstName, String lastName, String password) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
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
        if (!(object instanceof Apprentice)) {
            return false;
        }
        Apprentice other = (Apprentice) object;
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.aspera.model.Apprentice[ document=" + document + " ]";
    }
    
}
