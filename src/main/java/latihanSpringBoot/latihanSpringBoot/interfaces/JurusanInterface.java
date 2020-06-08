/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.interfaces;

import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbJurusan;

/**
 *
 * @author HARRY-PC
 */
public interface JurusanInterface {

    void SaveJurusan(TbJurusan jurusan);

    void DeleteJurusan(int id);

    List<Object[]> getlistjurusan();

    List<Object[]> getlistjurusanbyid(int id);

    List<Object[]> getlistJurusanbyname(String name);
}
