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
@Table(name = "tb_mhs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMhs.findAll", query = "SELECT t FROM TbMhs t")
    , @NamedQuery(name = "TbMhs.findById", query = "SELECT t FROM TbMhs t WHERE t.id = :id")
    , @NamedQuery(name = "TbMhs.findByNama", query = "SELECT t FROM TbMhs t WHERE t.nama = :nama")
    , @NamedQuery(name = "TbMhs.findByNik", query = "SELECT t FROM TbMhs t WHERE t.nik = :nik")
    , @NamedQuery(name = "TbMhs.findByJurusan", query = "SELECT t FROM TbMhs t WHERE t.jurusan = :jurusan")
    , @NamedQuery(name = "TbMhs.findByTahunAkademik", query = "SELECT t FROM TbMhs t WHERE t.tahunAkademik = :tahunAkademik")})
public class TbMhs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nik")
    private String nik;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "jurusan")
    private String jurusan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "tahun_akademik")
    private String tahunAkademik;

    public TbMhs() {
    }

    public TbMhs(Integer id) {
        this.id = id;
    }

    public TbMhs(String nama, String nik, String jurusan, String tahunAkademik) {
        this.nama = nama;
        this.nik = nik;
        this.jurusan = jurusan;
        this.tahunAkademik = tahunAkademik;
    }

    public TbMhs(Integer id, String nama, String nik, String jurusan, String tahunAkademik) {
        this.id = id;
        this.nama = nama;
        this.nik = nik;
        this.jurusan = jurusan;
        this.tahunAkademik = tahunAkademik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getTahunAkademik() {
        return tahunAkademik;
    }

    public void setTahunAkademik(String tahunAkademik) {
        this.tahunAkademik = tahunAkademik;
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
        if (!(object instanceof TbMhs)) {
            return false;
        }
        TbMhs other = (TbMhs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "latihanSpringBoot.latihanSpringBoot.enitity.TbMhs[ id=" + id + " ]";
    }
    
}
