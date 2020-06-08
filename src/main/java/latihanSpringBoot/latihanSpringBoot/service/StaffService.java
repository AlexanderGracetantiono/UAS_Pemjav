/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.service;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbStaff;
import latihanSpringBoot.latihanSpringBoot.enitity.TbLogin;
import latihanSpringBoot.latihanSpringBoot.interfaces.StaffInterface;
import latihanSpringBoot.latihanSpringBoot.interfaces.LoginInterface;
import latihanSpringBoot.latihanSpringBoot.repository.StaffRepo;
import latihanSpringBoot.latihanSpringBoot.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class StaffService implements StaffInterface {

    @Autowired
    private StaffRepo jbRepo;

    @Override
    public void SaveStaff(TbStaff Staff) {
        jbRepo.save(Staff);
    }

    @Override
    public List<Object[]> getlistStaff() {
        return jbRepo.getlistStaff();
    }

    @Override
    public List<Object[]> getlistStaffbyid(String id) {
        return jbRepo.getlistStaffid(id);
    }

    @Override
    public void DeleteStaff(String id) {
        jbRepo.DeleteStaff(id);
    }

    @Override
    public int CountStaff() {
        return jbRepo.countStaff();
    }

    @Override
    public List<Object[]> getlistStaffbyname(String name) {
      return jbRepo.getlistStaffname(name);
    }

}
