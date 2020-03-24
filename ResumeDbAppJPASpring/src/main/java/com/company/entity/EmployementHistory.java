/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author xeyal
 */
@Entity
@Table(name = "employement_history")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "EmployementHistory.findAll", query = "SELECT e FROM EmployementHistory e"),
//    @NamedQuery(name = "EmployementHistory.findById", query = "SELECT e FROM EmployementHistory e WHERE e.id = :id"),
//    @NamedQuery(name = "EmployementHistory.findByHeader", query = "SELECT e FROM EmployementHistory e WHERE e.header = :header"),
//    @NamedQuery(name = "EmployementHistory.findByBeginDate", query = "SELECT e FROM EmployementHistory e WHERE e.beginDate = :beginDate"),
//    @NamedQuery(name = "EmployementHistory.findByEndDate", query = "SELECT e FROM EmployementHistory e WHERE e.endDate = :endDate"),
//    @NamedQuery(name = "EmployementHistory.findByJobDescription", query = "SELECT e FROM EmployementHistory e WHERE e.jobDescription = :jobDescription")})
public class EmployementHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "header")
    private String header;
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "job_description")
    private String jobDescription;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;//UserId user olaraq deyisdi

    public EmployementHistory() {
    }

    public EmployementHistory(Integer id) {
        this.id = id;
    }

    public EmployementHistory(Integer id, String header, java.sql.Date beginDate, java.sql.Date endDate, String jobDescription, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof EmployementHistory)) {
            return false;
        }
        EmployementHistory other = (EmployementHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.EmployementHistory[ id=" + id + " ]";
    }

}
