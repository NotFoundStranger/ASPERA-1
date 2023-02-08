/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.aspera.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "coordinator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordinator.findAll", query = "SELECT c FROM Coordinator c"),
    @NamedQuery(name = "Coordinator.findByDocument", query = "SELECT c FROM Coordinator c WHERE c.document = :document"),
    @NamedQuery(name = "Coordinator.findByName", query = "SELECT c FROM Coordinator c WHERE c.name = :name"),
    @NamedQuery(name = "Coordinator.findByType", query = "SELECT c FROM Coordinator c WHERE c.type = :type"),
    @NamedQuery(name = "Coordinator.findByPassword", query = "SELECT c FROM Coordinator c WHERE c.password = :password")})
public class Coordinator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "document",nullable=false)
    private Long document;
    @Basic(optional = false)
    
    @Column(name = "name" ,nullable=false,length = 80)
    private String name;
    @Basic(optional = false)
   
    @Column(name = "type", nullable=false,length = 80)
    private String type;
    @Basic(optional = false)
   
    @Column(name = "password",nullable=false,length = 100)
    private String password;

    public Coordinator() {
    }

    public Coordinator(Long document) {
        this.document = document;
    }

    public Coordinator(Long document, String name, String type, String password) {
        this.document = document;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Coordinator)) {
            return false;
        }
        Coordinator other = (Coordinator) object;
        if ((this.document == null && other.document != null) || (this.document != null && !this.document.equals(other.document))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.aspera.model.Coordinator[ document=" + document + " ]";
    }
    
}
