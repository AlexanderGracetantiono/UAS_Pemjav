/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.repository;

import java.util.Date;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbJabatan;
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
public interface JabatanRepo extends CrudRepository<TbJabatan, Integer> {

    @Query(value = "SELECT * FROM `tb_jabatan`  WHERE `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistjabatan();
    @Query(value = "SELECT * FROM `tb_jabatan` WHERE `id` =? AND `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistjabatanid(int id);
    
    @Query(value = "SELECT * FROM `tb_jabatan` WHERE  `is_deleted` = 'false' AND `nama_jabatan` LIKE %?% ", nativeQuery = true)
    public List<Object[]> getlistjabatanbyname(String name);
    
    @Modifying(flushAutomatically = true)
    @Query(value = "UPDATE `tb_jabatan` SET `is_deleted` = 1 WHERE `id` =? ", nativeQuery = true)
    @Transactional
    public void DeleteJabatan(int id);
}
