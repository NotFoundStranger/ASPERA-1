/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.aspera.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
    @NamedQuery(name = "Permission.findById", query = "SELECT p FROM Permission p WHERE p.id = :id"),
    @NamedQuery(name = "Permission.findByDate", query = "SELECT p FROM Permission p WHERE p.date = :date"),
    @NamedQuery(name = "Permission.findByHourBegin", query = "SELECT p FROM Permission p WHERE p.hourBegin = :hourBegin"),
    @NamedQuery(name = "Permission.findByHourEnd", query = "SELECT p FROM Permission p WHERE p.hourEnd = :hourEnd"),
    @NamedQuery(name = "Permission.findByReason", query = "SELECT p FROM Permission p WHERE p.reason = :reason"),
    @NamedQuery(name = "Permission.findByStatusInstructor", query = "SELECT p FROM Permission p WHERE p.statusInstructor = :statusInstructor"),
    @NamedQuery(name = "Permission.findByStatusGuard", query = "SELECT p FROM Permission p WHERE p.statusGuard = :statusGuard")})
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
   
    @Column(name = "date",nullable=false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
   
    @Column(name = "hour_begin",nullable=false)
    @Temporal(TemporalType.TIME)
    private Date hourBegin;
    @Basic(optional = false)
    
    @Column(name = "hour_end",nullable=false)
    @Temporal(TemporalType.TIME)
    private Date hourEnd;
    @Basic(optional = false)
    
    @Column(name = "reason",nullable=false,length = 255)
    private String reason;
    @Basic(optional = false)
    
    @Column(name = "status_instructor",nullable=false, length = 15)
    private String statusInstructor;
    
    @Column(name = "status_guard",length = 15)
    private String statusGuard;
    @JoinColumn(name = "id_apprentice", referencedColumnName = "document")
    @ManyToOne(optional = false)
    private Apprentice idApprentice;
    @JoinColumn(name = "id_guard", referencedColumnName = "id")
    @ManyToOne
    private Guard idGuard;
    @JoinColumn(name = "id_instructor", referencedColumnName = "document")
    @ManyToOne
    private Instructor idInstructor;

    public Permission() {
    }

    public Permission(Integer id) {
        this.id = id;
    }

    public Permission(Integer id, Date date, Date hourBegin, Date hourEnd, String reason, String statusInstructor) {
        this.id = id;
        this.date = date;
        this.hourBegin = hourBegin;
        this.hourEnd = hourEnd;
        this.reason = reason;
        this.statusInstructor = statusInstructor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHourBegin() {
        return hourBegin;
    }

    public void setHourBegin(Date hourBegin) {
        this.hourBegin = hourBegin;
    }

    public Date getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(Date hourEnd) {
        this.hourEnd = hourEnd;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatusInstructor() {
        return statusInstructor;
    }

    public void setStatusInstructor(String statusInstructor) {
        this.statusInstructor = statusInstructor;
    }

    public String getStatusGuard() {
        return statusGuard;
    }

    public void setStatusGuard(String statusGuard) {
        this.statusGuard = statusGuard;
    }

    public Apprentice getIdApprentice() {
        return idApprentice;
    }

    public void setIdApprentice(Apprentice idApprentice) {
        this.idApprentice = idApprentice;
    }

    public Guard getIdGuard() {
        return idGuard;
    }

    public void setIdGuard(Guard idGuard) {
        this.idGuard = idGuard;
    }

    public Instructor getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Instructor idInstructor) {
        this.idInstructor = idInstructor;
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
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.aspera.model.Permission[ id=" + id + " ]";
    }
    
}
