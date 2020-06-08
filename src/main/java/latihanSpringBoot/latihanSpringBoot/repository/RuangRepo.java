/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.repository;

import java.util.Date;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbRuang;
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
public interface RuangRepo extends CrudRepository<TbRuang, Integer> {

    @Query(value = "SELECT * FROM `tb_ruang`  WHERE `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistRuang();
    
    @Query(value = "SELECT * FROM `tb_ruang` WHERE `id` =? AND `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistRuangid(String id);
    
    @Query(value = "SELECT COUNT(*) FROM `tb_ruang`  ", nativeQuery = true)
    public int countRuang();
    
    @Query(value = "SELECT * FROM `tb_ruang` WHERE `is_deleted` = 'false' AND `ruang_id` LIKE %?% ", nativeQuery = true)
    public List<Object[]> getlistRuangName(String name);
    
    @Modifying(flushAutomatically = true)
    @Query(value = "UPDATE `tb_ruang` SET `is_deleted` = 1 WHERE `id` =? ", nativeQuery = true)
    @Transactional
    public void DeleteRuang(String id);
}
