/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.service;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMatkul;
import latihanSpringBoot.latihanSpringBoot.enitity.TbLogin;
import latihanSpringBoot.latihanSpringBoot.interfaces.MatkulInterface;
import latihanSpringBoot.latihanSpringBoot.interfaces.LoginInterface;
import latihanSpringBoot.latihanSpringBoot.repository.MatkulRepo;
import latihanSpringBoot.latihanSpringBoot.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class MatkulService implements MatkulInterface {

    @Autowired
    private MatkulRepo jbRepo;

    @Override
    public void SaveMatkul(TbMatkul Matkul) {
        jbRepo.save(Matkul);
    }

    @Override
    public List<Object[]> getlistMatkul() {
        return jbRepo.getlistMatkul();
    }

    @Override
    public List<Object[]> getlistMatkulbyid(String id) {
        return jbRepo.getlistMatkulid(id);
    }

    @Override
    public void DeleteMatkul(String id) {
        jbRepo.DeleteMatkul(id);
    }

    @Override
    public int CountMatkul() {
        return jbRepo.countMatkul();
    }

    @Override
    public List<Object[]> getlistMatkulbyname(String name) {
      return jbRepo.getlistMatkulname(name);
    }

}
