/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.repository;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbNilai;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HARRY-PC
 */
@Repository
public interface NilaiMhsRepo extends CrudRepository<TbNilai, Integer> {

    @Query(value = "SELECT * FROM `tb_nilai` WHERE `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> ListNilai();

    @Modifying(flushAutomatically = true)
    @Query(value = "UPDATE `tb_nilai` SET `is_deleted` = 1 WHERE `id` =? ", nativeQuery = true)
    @Transactional
    public void DeleteNilai(int id);
}
