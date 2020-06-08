/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.repository;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMhs;
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
public interface MahasiswaRepo extends CrudRepository<TbMhs, Integer> {

    @Query(value = "SELECT * FROM `tb_mhs` WHERE `is_deleted`= 0 ", nativeQuery = true)
    public List<Object[]> listMHS();

    @Query(value = "SELECT COUNT(*) FROM `tb_mhs`  ", nativeQuery = true)
    public int countMHS();

    @Query(value = "SELECT * FROM `tb_mhs` WHERE `id`=? ", nativeQuery = true)
    public List<Object[]> getMHSBYID(int id);
    
    @Query(value = "SELECT * FROM `tb_mhs` WHERE `nama` LIKE %?% AND `is_deleted`=0", nativeQuery = true)
    public List<Object[]> getMHSbyName(String name);
    
    @Modifying(flushAutomatically = true)
    @Query(value = "UPDATE `tb_mhs` SET `is_deleted` = 1 WHERE `id` =? ", nativeQuery = true)
    @Transactional
    public void DeleteMHS(String id);
}
