/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.service;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbJurusan;
import latihanSpringBoot.latihanSpringBoot.interfaces.JurusanInterface;
import latihanSpringBoot.latihanSpringBoot.repository.JurusanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class JurusanService implements JurusanInterface {

    @Autowired
    private JurusanRepo jrRepo;

    @Override
    public void SaveJurusan(TbJurusan jurusan) {
        jrRepo.save(jurusan);
    }

    @Override
    public void DeleteJurusan(int id) {
        jrRepo.DeleteJurusan(id);
    }

    @Override
    public List<Object[]> getlistjurusan() {
        return jrRepo.getlistjurusan();
    }

    @Override
    public List<Object[]> getlistjurusanbyid(int id) {
       return jrRepo.getlistjurusanid(id);
    }

    @Override
    public List<Object[]> getlistJurusanbyname(String name) {
         return jrRepo.getlistJurusanname(name);
    }


}
