/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.service;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbLogin;
import latihanSpringBoot.latihanSpringBoot.interfaces.LoginInterface;
import latihanSpringBoot.latihanSpringBoot.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HARRY-PC
 */
@Service
public class LoginService implements LoginInterface {

    @Autowired
    private LoginRepo loginRepo;

    @Override
    public List<Object[]> checkUserLogin(String username, String password) {
        return loginRepo.empLogin(username, password);
    }
}
