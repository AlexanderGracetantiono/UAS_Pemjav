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
import latihanSpringBoot.latihanSpringBoot.enitity.TbMhs;
import latihanSpringBoot.latihanSpringBoot.enitity.TbNilai;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMatkul;
import latihanSpringBoot.latihanSpringBoot.service.JabatanService;
import latihanSpringBoot.latihanSpringBoot.service.JurusanService;
import latihanSpringBoot.latihanSpringBoot.service.LoginService;
import latihanSpringBoot.latihanSpringBoot.service.MahasiswaService;
import latihanSpringBoot.latihanSpringBoot.service.MatkulService;
import latihanSpringBoot.latihanSpringBoot.service.NilaiService;
import latihanSpringBoot.latihanSpringBoot.service.RuangService;
import latihanSpringBoot.latihanSpringBoot.service.StaffService;
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
public class MatkulController {

    @Autowired
    private MatkulService MS;
    @Autowired
    private JurusanService JS;
    @Autowired
    private RuangService RS;
    @Autowired
    private StaffService SS;

    @GetMapping("/matkul/form")
    public String MatkulForm() {
        return "matkul/matkulform";
    }

    @GetMapping("/matkul/form/e/{id}")
    public String EditMatkul(@PathVariable(value = "id") String id_JB, Model model) {
        for (Object[] object : MS.getlistMatkulbyid(id_JB)) {
            model.addAttribute("DataJB", object);
        }

        return "matkul/matkulform";
    }

    @GetMapping("/matkul/form/d/{id}")
    public String DeleteMatkul(@PathVariable(value = "id") String id_JB, Model model) {
        MS.DeleteMatkul(id_JB);
        return "redirect:/matkul/list";
    }

    @PostMapping("/matkul/form/s")
    public String SaveMatkulForm(
            @RequestParam("namaMatkul") String matkulNama,
            @RequestParam("dosen") String dosen,
            @RequestParam("ruang") String ruang,
            @RequestParam("jurusan") String Jurusan,
            @RequestParam("id") int idsss
    ) {
        if (idsss != 0) {
            System.out.println("OKE");
            TbMatkul matkul = new TbMatkul(idsss, matkulNama, dosen, ruang, Jurusan, false);
            MS.SaveMatkul(matkul);
        } else {
            System.out.println("NO");
            TbMatkul matkul = new TbMatkul(matkulNama, dosen, ruang, Jurusan, false);
            MS.SaveMatkul(matkul);
        }
        return "redirect:/matkul/list";
    }

    @GetMapping("/matkul/list")
    public String ListMatkul(Model model) {
        List<Object[]> listJB = new ArrayList<>();
        for (Object[] object : MS.getlistMatkul()) {
            listJB.add(object);
        }
        model.addAttribute("DataJB", listJB);
        return "matkul/matkullist";
    }

    @RequestMapping(value = "/matkul/getlistruang")
    @ResponseBody
    public List<Map<String, String>> autocompletejb(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : RS.getlistRuangbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }

    @RequestMapping(value = "/matkul/form/e/getlistruang")
    @ResponseBody
    public List<Map<String, String>> autocompletejb2(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : RS.getlistRuangbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }

    @RequestMapping(value = "/matkul/getlistdosen")
    @ResponseBody
    public List<Map<String, String>> autocompletejb3(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : SS.getlistStaffbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString() + " - " + object[0].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }

    @RequestMapping(value = "/matkul/form/e/getlistdosen")
    @ResponseBody
    public List<Map<String, String>> autocompletejb23(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : SS.getlistStaffbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString() + " - " + object[0].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }
    @RequestMapping(value = "/matkul/getlistjurusan")
    @ResponseBody
    public List<Map<String, String>> autocompletejb22(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : JS.getlistJurusanbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString() + " - " + object[0].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }

    @RequestMapping(value = "/matkul/form/e/getlistjurusan")
    @ResponseBody
    public List<Map<String, String>> autocompletejb24(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

       for (Object[] object : JS.getlistJurusanbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString() + " - " + object[0].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }
}
