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
@Table(name = "tb_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbLogin.findAll", query = "SELECT t FROM TbLogin t")
    , @NamedQuery(name = "TbLogin.findById", query = "SELECT t FROM TbLogin t WHERE t.id = :id")
    , @NamedQuery(name = "TbLogin.findByName", query = "SELECT t FROM TbLogin t WHERE t.name = :name")
    , @NamedQuery(name = "TbLogin.findByUsername", query = "SELECT t FROM TbLogin t WHERE t.username = :username")
    , @NamedQuery(name = "TbLogin.findByUserId", query = "SELECT t FROM TbLogin t WHERE t.userId = :userId")
    , @NamedQuery(name = "TbLogin.findByPassword", query = "SELECT t FROM TbLogin t WHERE t.password = :password")})
public class TbLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;

    public TbLogin() {
    }

    public TbLogin(Integer id) {
        this.id = id;
    }

    public TbLogin(Integer id, String name, String username, int userId, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.userId = userId;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbLogin)) {
            return false;
        }
        TbLogin other = (TbLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "latihanSpringBoot.latihanSpringBoot.enitity.TbLogin[ id=" + id + " ]";
    }
    
}
