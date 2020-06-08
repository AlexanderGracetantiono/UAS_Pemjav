/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import latihanSpringBoot.latihanSpringBoot.enitity.TbJabatan;
import latihanSpringBoot.latihanSpringBoot.enitity.TbStaff;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMhs;
import latihanSpringBoot.latihanSpringBoot.enitity.TbNilai;
import latihanSpringBoot.latihanSpringBoot.service.JabatanService;
import latihanSpringBoot.latihanSpringBoot.service.StaffService;
import latihanSpringBoot.latihanSpringBoot.service.LoginService;
import latihanSpringBoot.latihanSpringBoot.service.MahasiswaService;
import latihanSpringBoot.latihanSpringBoot.service.NilaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alexa
 */
@Controller
public class StaffController {

    @Autowired
    private StaffService jb;
    @Autowired
    private JabatanService jabatanservice;

    @GetMapping("/staff/form")
    public String StaffForm(Model model) {
        model.addAttribute("DataJB", null);
        return "staff/staffform";
    }

    @GetMapping("/staff/form/e/{id}")
    public String EditStaff(@PathVariable(value = "id") String id_JB, Model model) {
        for (Object[] object : jb.getlistStaffbyid(id_JB)) {
            model.addAttribute("DataJB", object);
        }

        return "staff/staffform";
    }

    @GetMapping("/staff/form/d/{id}")
    public String DeleteStaff(@PathVariable(value = "id") String id_JB, Model model) {
        jb.DeleteStaff(id_JB);
       return "redirect:/staff/list";
    }
   

    @PostMapping("/staff/form/s")
    public String SaveStaffForm(
            @RequestParam("nama") String staffNama,
            @RequestParam("jabatan") String jabatan,
            @RequestParam("tahun") String tahun,
            @RequestParam("jabatanid") String jabatanid,
            @RequestParam("id") String idsss
    ) {
        String NIK = "";
        NIK += jabatanid;
        NIK += tahun;
        int staff_id = jb.CountStaff() + 1;
        NIK += staff_id;
        System.out.println("NIK " + idsss.length());
        if (idsss.length() > 2) {
            System.out.println("OKE");
            TbStaff staff = new TbStaff(idsss, staffNama, jabatan, tahun);
            jb.SaveStaff(staff);
        } else {
            System.out.println("NO");
            TbStaff staff = new TbStaff(NIK, staffNama, jabatan, tahun);
            jb.SaveStaff(staff);
        }
        return "redirect:/staff/list";
    }

    @GetMapping("/staff/list")
    public String ListStaff(Model model) {
        List<Object[]> listJB = new ArrayList<>();
        for (Object[] object : jb.getlistStaff()) {
            listJB.add(object);
        }
        model.addAttribute("DataJB", listJB);
        return "staff/stafflist";
    }

    @RequestMapping(value = "/staff/getlistjb")
    @ResponseBody
    public List<Map<String, String>> autocompletejb(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : jabatanservice.getlistjabatanbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }
    @RequestMapping(value = "/staff/form/e/getlistjb")
    @ResponseBody
    public List<Map<String, String>> autocompletejb2(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : jabatanservice.getlistjabatanbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }

}
