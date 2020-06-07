/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.repository;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HARRY-PC
 */
@Repository
public interface LoginRepo extends CrudRepository<TbLogin, Integer> {

    @Query(value = "SELECT * FROM `tb_login` WHERE `username` =? AND `password` =?", nativeQuery = true)
    public List<Object[]> empLogin(String username, String password);
}
