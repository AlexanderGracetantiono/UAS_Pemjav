/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.interfaces;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMatkul;

/**
 *
 * @author HARRY-PC
 */
public interface MatkulInterface {
    void SaveMatkul (TbMatkul Matkul);
    void DeleteMatkul (String id);
    int CountMatkul ();
    List<Object[]> getlistMatkul();
    List<Object[]> getlistMatkulbyid(String id);
    List<Object[]> getlistMatkulbyname(String name);
}
