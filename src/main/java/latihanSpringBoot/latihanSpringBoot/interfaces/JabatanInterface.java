/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.interfaces;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbJabatan;
import latihanSpringBoot.latihanSpringBoot.enitity.TbLogin;

/**
 *
 * @author HARRY-PC
 */
public interface JabatanInterface {
    void SaveJabatan (TbJabatan jabatan);
    void DeleteJabatan (int id);
    List<Object[]> getlistjabatan();
    List<Object[]> getlistjabatanbyname(String name);
    List<Object[]> getlistjabatanbyid(int id);
}
