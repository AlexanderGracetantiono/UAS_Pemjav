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
@Table(name = "tb_matkul")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMatkul.findAll", query = "SELECT t FROM TbMatkul t")
    , @NamedQuery(name = "TbMatkul.findById", query = "SELECT t FROM TbMatkul t WHERE t.id = :id")
    , @NamedQuery(name = "TbMatkul.findByNamaMatkul", query = "SELECT t FROM TbMatkul t WHERE t.namaMatkul = :namaMatkul")
    , @NamedQuery(name = "TbMatkul.findByDosen", query = "SELECT t FROM TbMatkul t WHERE t.dosen = :dosen")
    , @NamedQuery(name = "TbMatkul.findByRuang", query = "SELECT t FROM TbMatkul t WHERE t.ruang = :ruang")
    , @NamedQuery(name = "TbMatkul.findByJurusan", query = "SELECT t FROM TbMatkul t WHERE t.jurusan = :jurusan")
    , @NamedQuery(name = "TbMatkul.findByIsDeleted", query = "SELECT t FROM TbMatkul t WHERE t.isDeleted = :isDeleted")})
public class TbMatkul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_matkul")
    private String namaMatkul;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dosen")
    private String dosen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ruang")
    private String ruang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "jurusan")
    private String jurusan;
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public TbMatkul() {
    }

    public TbMatkul(Integer id) {
        this.id = id;
    }

    public TbMatkul(Integer id, String namaMatkul, String dosen, String ruang, String jurusan, Boolean isDeleted) {
        this.id = id;
        this.namaMatkul = namaMatkul;
        this.dosen = dosen;
        this.ruang = ruang;
        this.jurusan = jurusan;
        this.isDeleted = isDeleted;
    }

    public TbMatkul(String namaMatkul, String dosen, String ruang, String jurusan, Boolean isDeleted) {
        this.namaMatkul = namaMatkul;
        this.dosen = dosen;
        this.ruang = ruang;
        this.jurusan = jurusan;
        this.isDeleted = isDeleted;
    }

    public TbMatkul(Integer id, String namaMatkul, String dosen, String ruang, String jurusan) {
        this.id = id;
        this.namaMatkul = namaMatkul;
        this.dosen = dosen;
        this.ruang = ruang;
        this.jurusan = jurusan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
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
        if (!(object instanceof TbMatkul)) {
            return false;
        }
        TbMatkul other = (TbMatkul) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "latihanSpringBoot.latihanSpringBoot.enitity.TbMatkul[ id=" + id + " ]";
    }
    
}
