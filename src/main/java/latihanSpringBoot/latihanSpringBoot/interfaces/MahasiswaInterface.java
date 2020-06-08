/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.interfaces;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMhs;

/**
 *
 * @author HARRY-PC
 */
public interface MahasiswaInterface {
    
    List<Object[]> listMHS();
    List<Object[]> getMHSBYID(int id);
    List<Object[]> getMHSbyName(String name);
    void saveMHS(TbMhs tbmhs);
    void DeleteMHS(String id);
    int countMHS();
}
