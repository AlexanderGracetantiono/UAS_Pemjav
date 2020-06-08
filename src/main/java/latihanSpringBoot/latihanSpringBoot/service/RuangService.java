/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.service;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbRuang;
import latihanSpringBoot.latihanSpringBoot.enitity.TbLogin;
import latihanSpringBoot.latihanSpringBoot.interfaces.RuangInterface;
import latihanSpringBoot.latihanSpringBoot.interfaces.LoginInterface;
import latihanSpringBoot.latihanSpringBoot.repository.RuangRepo;
import latihanSpringBoot.latihanSpringBoot.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class RuangService implements RuangInterface {

    @Autowired
    private RuangRepo jbRepo;

    @Override
    public void SaveRuang(TbRuang Ruang) {
        jbRepo.save(Ruang);
    }

    @Override
    public List<Object[]> getlistRuang() {
        return jbRepo.getlistRuang();
    }

    @Override
    public List<Object[]> getlistRuangbyid(String id) {
        return jbRepo.getlistRuangid(id);
    }

    @Override
    public void DeleteRuang(String id) {
        jbRepo.DeleteRuang(id);
    }

    @Override
    public int CountRuang() {
        return jbRepo.countRuang();
    }

    @Override
    public List<Object[]> getlistRuangbyname(String name) {
        return jbRepo.getlistRuangName(name);
    }

}
