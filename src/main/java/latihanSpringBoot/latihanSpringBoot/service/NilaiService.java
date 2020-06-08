/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.service;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMhs;
import latihanSpringBoot.latihanSpringBoot.enitity.TbNilai;
import latihanSpringBoot.latihanSpringBoot.interfaces.MahasiswaInterface;
import latihanSpringBoot.latihanSpringBoot.interfaces.NilaiInterface;
import latihanSpringBoot.latihanSpringBoot.repository.MahasiswaRepo;
import latihanSpringBoot.latihanSpringBoot.repository.NilaiMhsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class NilaiService implements NilaiInterface {

    @Autowired
    private NilaiMhsRepo nilaiRepo;

    @Override
    public void saveNilaiAkhir(TbNilai tbNilai) {
       nilaiRepo.save(tbNilai);
    }

    @Override
    public void saveUTS(int nilai, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> getListNilai() {
       return nilaiRepo.ListNilai();
    }

    @Override
    public void DeleteNilai(int id) {
        nilaiRepo.DeleteNilai(id);
    }
}
