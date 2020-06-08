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
import latihanSpringBoot.latihanSpringBoot.enitity.TbNilai;
import latihanSpringBoot.latihanSpringBoot.service.LoginService;
import latihanSpringBoot.latihanSpringBoot.service.MahasiswaService;
import latihanSpringBoot.latihanSpringBoot.service.MatkulService;
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
public class NilaiController {

    @Autowired
    private MatkulService MS;
    @Autowired
    private MahasiswaService mhsservice;
    @Autowired
    private NilaiService nilaiService;

    
    @GetMapping("/nilai/form")
    public String FormNilai() {
        return "nilai/form";
    }

     @GetMapping("/nilai/form/d/{id}")
    public String DeleteNilai(@PathVariable(value = "id") int id_JB, Model model) {
        nilaiService.DeleteNilai(id_JB);
       return "redirect:/nilai/list";
    }
    @PostMapping("/nilai/form/s")
    public String SaveNilaiForm(
            @RequestParam("uts") int uts,
            @RequestParam("uas") int uas,
            @RequestParam("harian") int harian,
            @RequestParam("namaMHS") String namaMHS,
            @RequestParam("matkul") String matkul,
            @RequestParam("NIM") String NIK
    ) {
        System.out.println("Nilai: "+NIK+" "+uts+" "+uas+" "+harian+namaMHS);
        String Grade="";
        double rerata = uts*0.35 +uas*0.35 +harian*0.3;
        if (rerata>=85)Grade ="A";
        else if(rerata>=80)Grade="A-";
        else if(rerata>=75)Grade="B+";
        else if(rerata>=70)Grade="B";
        else if(rerata>=60)Grade="B-";
        else if(rerata>=55)Grade="C+";
        else if(rerata>=50)Grade="C";
        else if(rerata<=45)Grade="D";
        TbNilai tb_nilai = new TbNilai(matkul, NIK, namaMHS, uas, uts, harian, harian, Grade, false);
        nilaiService.saveNilaiAkhir(tb_nilai);
        return "redirect:/nilai/list";
    }

    @RequestMapping(value = "/nilai/getlistmhs")
    @ResponseBody
    public List<Map<String, String>> autocomplete2(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {

        List<Map<String, String>> listParking = new ArrayList<>();

        for (Object[] object : mhsservice.getMHSbyName(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString() + " - " + object[2].toString());
            map.put("value", object[1].toString());
            map.put("nim", object[2].toString());
            map.put("jurusan", object[3].toString());
            listParking.add(map);
        }

        return listParking;
    }
    @RequestMapping(value = "/nilai/getmatkul")
    @ResponseBody
    public List<Map<String, String>> autocompletss(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {

        List<Map<String, String>> listParking = new ArrayList<>();

        for (Object[] object : MS.getlistMatkulbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString() + " - " + object[2].toString());
            map.put("value", object[1].toString());
            map.put("nim", object[2].toString());
            map.put("jurusan", object[3].toString());
            listParking.add(map);
        }

        return listParking;
    }

    @GetMapping("/nilai/list")
    public String ListNilai(Model model) {
        List<Object[]> listJB = new ArrayList<>();
        for (Object[] object : nilaiService.getListNilai()) {
            listJB.add(object);
        }
        model.addAttribute("DataJB", listJB);
        return "nilai/nilailist";
    }

    
}
