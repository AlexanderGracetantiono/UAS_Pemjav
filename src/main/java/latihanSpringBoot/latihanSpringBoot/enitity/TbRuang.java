/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.enitity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexa
 */
@Entity
@Table(name = "tb_ruang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRuang.findAll", query = "SELECT t FROM TbRuang t")
    , @NamedQuery(name = "TbRuang.findById", query = "SELECT t FROM TbRuang t WHERE t.id = :id")
    , @NamedQuery(name = "TbRuang.findByRuangId", query = "SELECT t FROM TbRuang t WHERE t.ruangId = :ruangId")
    , @NamedQuery(name = "TbRuang.findByStaff", query = "SELECT t FROM TbRuang t WHERE t.staff = :staff")
    , @NamedQuery(name = "TbRuang.findByIsDeleted", query = "SELECT t FROM TbRuang t WHERE t.isDeleted = :isDeleted")})
public class TbRuang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ruang_id")
    private String ruangId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "staff")
    private String staff;
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public TbRuang() {
    }

    public TbRuang(Integer id) {
        this.id = id;
    }

    public TbRuang(Integer id, String ruangId, String staff) {
        this.id = id;
        this.ruangId = ruangId;
        this.staff = staff;
    }

    public TbRuang(Integer id, String ruangId, String staff, Boolean isDeleted) {
        this.id = id;
        this.ruangId = ruangId;
        this.staff = staff;
        this.isDeleted = isDeleted;
    }

    public TbRuang(String ruangId, String staff, Boolean isDeleted) {
        this.ruangId = ruangId;
        this.staff = staff;
        this.isDeleted = isDeleted;
    }

    public TbRuang(String ruangId, String staff) {
        this.ruangId = ruangId;
        this.staff = staff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuangId() {
        return ruangId;
    }

    public void setRuangId(String ruangId) {
        this.ruangId = ruangId;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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
        if (!(object instanceof TbRuang)) {
            return false;
        }
        TbRuang other = (TbRuang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "latihanSpringBoot.latihanSpringBoot.enitity.TbRuang[ id=" + id + " ]";
    }
    
}
