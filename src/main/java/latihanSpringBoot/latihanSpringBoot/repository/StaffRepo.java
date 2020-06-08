/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.repository;

import java.util.Date;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbStaff;
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
public interface StaffRepo extends CrudRepository<TbStaff, Integer> {

    @Query(value = "SELECT * FROM `tb_staff`  WHERE `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistStaff();
    
    @Query(value = "SELECT * FROM `tb_staff` WHERE `id` =? AND `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistStaffid(String id);
    
    @Query(value = "SELECT * FROM `tb_staff` WHERE `is_deleted` = 'false' AND `nama` LIKE %?% ", nativeQuery = true)
    public List<Object[]> getlistStaffname(String name);
    
    @Query(value = "SELECT COUNT(*) FROM `tb_staff`  ", nativeQuery = true)
    public int countStaff();
    
    @Modifying(flushAutomatically = true)
    @Query(value = "UPDATE `tb_staff` SET `is_deleted` = 1 WHERE `id` =? ", nativeQuery = true)
    @Transactional
    public void DeleteStaff(String id);
}
