/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.interfaces;
import java.util.List;
import latihanSpringBoot.latihanSpringBoot.enitity.TbStaff;

/**
 *
 * @author HARRY-PC
 */
public interface StaffInterface {
    void SaveStaff (TbStaff Staff);
    void DeleteStaff (String id);
    int CountStaff ();
    List<Object[]> getlistStaff();
    List<Object[]> getlistStaffbyid(String id);
    List<Object[]> getlistStaffbyname(String name);
}
