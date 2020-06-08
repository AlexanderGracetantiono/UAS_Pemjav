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
import latihanSpringBoot.latihanSpringBoot.enitity.TbMhs;
import latihanSpringBoot.latihanSpringBoot.service.JurusanService;
import latihanSpringBoot.latihanSpringBoot.service.MahasiswaService;
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
public class MHSController {

   @Autowired
    private MahasiswaService mhsservice;
    @Autowired
    private JurusanService JS;

    @GetMapping("/mhs/form")
    public String FormMHS(Model model) {
        model.addAttribute("DataMHS", null);
        return "mhs/form";
    }

    @GetMapping("/mhs/form/e/{id}")
    public String editMHS(@PathVariable(value = "id") int ID_MHS, Model model) {
        for (Object[] object : mhsservice.getMHSBYID(ID_MHS)) {
            model.addAttribute("DataMHS", object);
        }
        return "mhs/form";
    }

    @GetMapping("/mhs/list")
    public String listMHS(Model model) {
        List<Object[]> listMHS = new ArrayList<>();
        for (Object[] object : mhsservice.listMHS()) {
            listMHS.add(object);
        }
        model.addAttribute("LISTMHS", listMHS);
        return "mhs/listMHS";
    }

    @PostMapping("/mhs/form/s")
    public String SaveMHS(
            @RequestParam("namaMHS") String nama,
            @RequestParam("tahunMHS") String tahun,
            @RequestParam("id_mhs") int id_mhs,
            @RequestParam("jurusanID") int jurusanID,
            @RequestParam("nik_mhs") String nik_mhs,
            @RequestParam("jurusanMHS") String jurusan
    ) {
        String nik = "";
//        switch (jurusan) {
//            case "Teknologi Informasi":
//                nik += "5";
//                break;
//            case "Sistem Informasi":
//                nik += "4";
//                break;
//            case "Management":
//                nik += "3";
//                break;
//            case "Akuntansi":
//                nik += "2";
//                break;
//            default:
//                nik += "1";
//        }
        nik+=jurusanID;
        nik += tahun;
        String count = "00" + Integer.toString(mhsservice.countMHS() + 1);
        System.out.println(Integer.toString(id_mhs).length()+" pj");
        if (id_mhs!=0) {
            System.out.println("OK");
            TbMhs mhs = new TbMhs(id_mhs, nama, nik_mhs, jurusan, tahun);
            mhsservice.saveMHS(mhs);
        } else {
            System.out.println("NO");
            nik += count;
            TbMhs mhs = new TbMhs(nama, nik, jurusan, tahun);
            mhsservice.saveMHS(mhs);
        }
        return "redirect:/mhs/list";
    }

    @GetMapping("/mhs/form/d/{id}")
    public String Deletemhs(@PathVariable(value = "id") String id_JB, Model model) {
        mhsservice.DeleteMHS(id_JB);
       return "redirect:/mhs/list";
    }
    
    @RequestMapping(value = "/mhs/getlistjurusan")
    @ResponseBody
    public List<Map<String, String>> autocompletejb(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : JS.getlistJurusanbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }
    @RequestMapping(value = "/mhs/form/e/getlistjurusan")
    @ResponseBody
    public List<Map<String, String>> autocompletejb2(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : JS.getlistJurusanbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }

}
