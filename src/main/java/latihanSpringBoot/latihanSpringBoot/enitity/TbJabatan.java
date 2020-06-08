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
@Table(name = "tb_jabatan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbJabatan.findAll", query = "SELECT t FROM TbJabatan t")
    , @NamedQuery(name = "TbJabatan.findById", query = "SELECT t FROM TbJabatan t WHERE t.id = :id")
    , @NamedQuery(name = "TbJabatan.findByNamaJabatan", query = "SELECT t FROM TbJabatan t WHERE t.namaJabatan = :namaJabatan")
    , @NamedQuery(name = "TbJabatan.findByIsDeleted", query = "SELECT t FROM TbJabatan t WHERE t.isDeleted = :isDeleted")})
public class TbJabatan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_jabatan")
    private String namaJabatan;
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public TbJabatan() {
    }

    public TbJabatan(Integer id, String namaJabatan, Boolean isDeleted) {
        this.id = id;
        this.namaJabatan = namaJabatan;
        this.isDeleted = isDeleted;
    }

    public TbJabatan(String namaJabatan, Boolean isDeleted) {
        this.namaJabatan = namaJabatan;
        this.isDeleted = isDeleted;
    }

    public TbJabatan(Integer id) {
        this.id = id;
    }

    public TbJabatan(Integer id, String namaJabatan) {
        this.id = id;
        this.namaJabatan = namaJabatan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
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
        if (!(object instanceof TbJabatan)) {
            return false;
        }
        TbJabatan other = (TbJabatan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "latihanSpringBoot.latihanSpringBoot.enitity.TbJabatan[ id=" + id + " ]";
    }
    
}
