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
@Table(name = "tb_nilai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbNilai.findAll", query = "SELECT t FROM TbNilai t")
    , @NamedQuery(name = "TbNilai.findById", query = "SELECT t FROM TbNilai t WHERE t.id = :id")
    , @NamedQuery(name = "TbNilai.findByMatkul", query = "SELECT t FROM TbNilai t WHERE t.matkul = :matkul")
    , @NamedQuery(name = "TbNilai.findByNik", query = "SELECT t FROM TbNilai t WHERE t.nik = :nik")
    , @NamedQuery(name = "TbNilai.findByNama", query = "SELECT t FROM TbNilai t WHERE t.nama = :nama")
    , @NamedQuery(name = "TbNilai.findByUas", query = "SELECT t FROM TbNilai t WHERE t.uas = :uas")
    , @NamedQuery(name = "TbNilai.findByUts", query = "SELECT t FROM TbNilai t WHERE t.uts = :uts")
    , @NamedQuery(name = "TbNilai.findByHarian", query = "SELECT t FROM TbNilai t WHERE t.harian = :harian")
    , @NamedQuery(name = "TbNilai.findByRerata", query = "SELECT t FROM TbNilai t WHERE t.rerata = :rerata")
    , @NamedQuery(name = "TbNilai.findByGrade", query = "SELECT t FROM TbNilai t WHERE t.grade = :grade")
    , @NamedQuery(name = "TbNilai.findByIsDeleted", query = "SELECT t FROM TbNilai t WHERE t.isDeleted = :isDeleted")})
public class TbNilai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "matkul")
    private String matkul;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nik")
    private String nik;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uas")
    private int uas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uts")
    private int uts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "harian")
    private int harian;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rerata")
    private int rerata;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "grade")
    private String grade;
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public TbNilai() {
    }

    public TbNilai(Integer id) {
        this.id = id;
    }

    public TbNilai(Integer id, String matkul, String nik, String nama, int uas, int uts, int harian, int rerata, String grade) {
        this.id = id;
        this.matkul = matkul;
        this.nik = nik;
        this.nama = nama;
        this.uas = uas;
        this.uts = uts;
        this.harian = harian;
        this.rerata = rerata;
        this.grade = grade;
    }
  public TbNilai(String matkul, String nik, String nama, int uas, int uts, int harian, int rerata, String grade, Boolean isDeleted) {
        this.matkul = matkul;
        this.nik = nik;
        this.nama = nama;
        this.uas = uas;
        this.uts = uts;
        this.harian = harian;
        this.rerata = rerata;
        this.grade = grade;
        this.isDeleted = isDeleted;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUas() {
        return uas;
    }

    public void setUas(int uas) {
        this.uas = uas;
    }

    public int getUts() {
        return uts;
    }

    public void setUts(int uts) {
        this.uts = uts;
    }

    public int getHarian() {
        return harian;
    }

    public void setHarian(int harian) {
        this.harian = harian;
    }

    public int getRerata() {
        return rerata;
    }

    public void setRerata(int rerata) {
        this.rerata = rerata;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
        if (!(object instanceof TbNilai)) {
            return false;
        }
        TbNilai other = (TbNilai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "latihanSpringBoot.latihanSpringBoot.enitity.TbNilai[ id=" + id + " ]";
    }
    
}
