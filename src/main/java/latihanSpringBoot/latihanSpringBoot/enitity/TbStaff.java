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
@Table(name = "tb_staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbStaff.findAll", query = "SELECT t FROM TbStaff t")
    , @NamedQuery(name = "TbStaff.findById", query = "SELECT t FROM TbStaff t WHERE t.id = :id")
    , @NamedQuery(name = "TbStaff.findByNama", query = "SELECT t FROM TbStaff t WHERE t.nama = :nama")
    , @NamedQuery(name = "TbStaff.findByJabatan", query = "SELECT t FROM TbStaff t WHERE t.jabatan = :jabatan")
    , @NamedQuery(name = "TbStaff.findByTahunMasuk", query = "SELECT t FROM TbStaff t WHERE t.tahunMasuk = :tahunMasuk")})
public class TbStaff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "jabatan")
    private String jabatan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "tahun_masuk")
    private String tahunMasuk;

    public TbStaff() {
    }

    public TbStaff(String id) {
        this.id = id;
    }

    public TbStaff(String id, String nama, String jabatan, String tahunMasuk) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.tahunMasuk = tahunMasuk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(String tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
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
        if (!(object instanceof TbStaff)) {
            return false;
        }
        TbStaff other = (TbStaff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "latihanSpringBoot.latihanSpringBoot.enitity.TbStaff[ id=" + id + " ]";
    }
    
}
