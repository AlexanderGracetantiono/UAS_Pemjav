/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.service;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbJabatan;
import latihanSpringBoot.latihanSpringBoot.enitity.TbLogin;
import latihanSpringBoot.latihanSpringBoot.interfaces.JabatanInterface;
import latihanSpringBoot.latihanSpringBoot.interfaces.LoginInterface;
import latihanSpringBoot.latihanSpringBoot.repository.JabatanRepo;
import latihanSpringBoot.latihanSpringBoot.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class JabatanService implements JabatanInterface {

    @Autowired
    private JabatanRepo jbRepo;

    @Override
    public void SaveJabatan(TbJabatan jabatan) {
        jbRepo.save(jabatan);
    }

    @Override
    public List<Object[]> getlistjabatan() {
        return jbRepo.getlistjabatan();
    }

    @Override
    public List<Object[]> getlistjabatanbyid(int id) {
        return jbRepo.getlistjabatanid(id);
    }

    @Override
    public void DeleteJabatan(int id) {
        jbRepo.DeleteJabatan(id);
    }

    @Override
    public List<Object[]> getlistjabatanbyname(String name) {
           return jbRepo.getlistjabatanbyname(name);
    }

}
