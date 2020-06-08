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
@Table(name = "tb_jurusan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbJurusan.findAll", query = "SELECT t FROM TbJurusan t")
    , @NamedQuery(name = "TbJurusan.findById", query = "SELECT t FROM TbJurusan t WHERE t.id = :id")
    , @NamedQuery(name = "TbJurusan.findByNamaJurusan", query = "SELECT t FROM TbJurusan t WHERE t.namaJurusan = :namaJurusan")
    , @NamedQuery(name = "TbJurusan.findByNamaProdi", query = "SELECT t FROM TbJurusan t WHERE t.namaProdi = :namaProdi")
    , @NamedQuery(name = "TbJurusan.findByIsDeleted", query = "SELECT t FROM TbJurusan t WHERE t.isDeleted = :isDeleted")})
public class TbJurusan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_jurusan")
    private String namaJurusan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_prodi")
    private String namaProdi;
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public TbJurusan() {
    }

    public TbJurusan(Integer id) {
        this.id = id;
    }

    public TbJurusan(String namaJurusan, String namaProdi, Boolean isDeleted) {
        this.namaJurusan = namaJurusan;
        this.namaProdi = namaProdi;
        this.isDeleted = isDeleted;
    }

    public TbJurusan(Integer id, String namaJurusan, String namaProdi, Boolean isDeleted) {
        this.id = id;
        this.namaJurusan = namaJurusan;
        this.namaProdi = namaProdi;
        this.isDeleted = isDeleted;
    }

    public TbJurusan(Integer id, String namaJurusan, String namaProdi) {
        this.id = id;
        this.namaJurusan = namaJurusan;
        this.namaProdi = namaProdi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public void setNamaProdi(String namaProdi) {
        this.namaProdi = namaProdi;
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
        if (!(object instanceof TbJurusan)) {
            return false;
        }
        TbJurusan other = (TbJurusan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "latihanSpringBoot.latihanSpringBoot.enitity.TbJurusan[ id=" + id + " ]";
    }
    
}
