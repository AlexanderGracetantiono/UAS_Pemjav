/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.repository;

import java.util.Date;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbJurusan;
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
public interface JurusanRepo extends CrudRepository<TbJurusan, Integer> {

    @Query(value = "SELECT * FROM `tb_jurusan`  WHERE `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistjurusan();

    @Query(value = "SELECT * FROM `tb_jurusan` WHERE `id` =? AND `is_deleted` = 'false' ", nativeQuery = true)
    public List<Object[]> getlistjurusanid(int id);

    @Query(value = "SELECT * FROM `tb_jurusan` WHERE `is_deleted` = 'false' AND `nama_jurusan` LIKE %?% ", nativeQuery = true)
    public List<Object[]> getlistJurusanname(String name);

    @Modifying(flushAutomatically = true)
    @Query(value = "UPDATE `tb_jurusan` SET `is_deleted` = 1 WHERE `id` =? ", nativeQuery = true)
    @Transactional
    public void DeleteJurusan(int id);
}
