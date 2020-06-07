/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.interfaces;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbLogin;

/**
 *
 * @author HARRY-PC
 */
public interface LoginInterface {
    
    List<Object[]> checkUserLogin(String username , String password);
}
