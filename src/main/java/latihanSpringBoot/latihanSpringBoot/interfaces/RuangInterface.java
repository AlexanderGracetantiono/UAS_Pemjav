/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.interfaces;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbRuang;

/**
 *
 * @author HARRY-PC
 */
public interface RuangInterface {
    void SaveRuang (TbRuang Ruang);
    void DeleteRuang (String id);
    int CountRuang ();
    List<Object[]> getlistRuang();
    List<Object[]> getlistRuangbyid(String id);
    List<Object[]> getlistRuangbyname(String name);
}
