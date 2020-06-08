/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.repository;

import java.util.Date;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMatkul;
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
public interface MatkulRepo extends CrudRepository<TbMatkul, Integer> {

    @Query(value = "SELECT * FROM `tb_matkul`  WHERE `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistMatkul();
    
    @Query(value = "SELECT * FROM `tb_matkul` WHERE `id` =? AND `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistMatkulid(String id);
    
    @Query(value = "SELECT * FROM `tb_matkul` WHERE `is_deleted` = 'false' AND `nama_matkul` LIKE %?% ", nativeQuery = true)
    public List<Object[]> getlistMatkulname(String name);
    
    @Query(value = "SELECT COUNT(*) FROM `tb_matkul`  ", nativeQuery = true)
    public int countMatkul();
    
    @Modifying(flushAutomatically = true)
    @Query(value = "UPDATE `tb_matkul` SET `is_deleted` = 1 WHERE `id` =? ", nativeQuery = true)
    @Transactional
    public void DeleteMatkul(String id);
}
