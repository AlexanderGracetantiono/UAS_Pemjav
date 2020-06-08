/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.interfaces;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMhs;
import latihanSpringBoot.latihanSpringBoot.enitity.TbNilai;

/**
 *
 * @author HARRY-PC
 */
public interface NilaiInterface {
    
    void saveNilaiAkhir(TbNilai tbNilai);
    void saveUTS(int nilai,String id);
    List<Object[]> getListNilai();
    void DeleteNilai(int id);
}
