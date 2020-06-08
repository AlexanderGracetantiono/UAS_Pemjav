/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.service;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMhs;
import latihanSpringBoot.latihanSpringBoot.interfaces.MahasiswaInterface;
import latihanSpringBoot.latihanSpringBoot.repository.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class MahasiswaService implements MahasiswaInterface {

    @Autowired
    private MahasiswaRepo mhsRepo;

    @Override
    public List<Object[]> listMHS() {
        return mhsRepo.listMHS();
    }

    @Override
    public void saveMHS(TbMhs tbmhs) {
        mhsRepo.save(tbmhs);
    }

    @Override
    public int countMHS() {
      return mhsRepo.countMHS();
    }

    @Override
    public List<Object[]> getMHSBYID(int id) {
        return mhsRepo.getMHSBYID(id);
    }

    @Override
    public List<Object[]> getMHSbyName(String name) {
       return mhsRepo.getMHSbyName(name);
    }

    @Override
    public void DeleteMHS(String id) {
         mhsRepo.DeleteMHS(id);
    }
}
