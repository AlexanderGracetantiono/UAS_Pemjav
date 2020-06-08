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
import latihanSpringBoot.latihanSpringBoot.enitity.TbJurusan;
import latihanSpringBoot.latihanSpringBoot.enitity.TbMhs;
import latihanSpringBoot.latihanSpringBoot.enitity.TbNilai;
import latihanSpringBoot.latihanSpringBoot.service.JabatanService;
import latihanSpringBoot.latihanSpringBoot.service.JurusanService;
import latihanSpringBoot.latihanSpringBoot.service.LoginService;
import latihanSpringBoot.latihanSpringBoot.service.MahasiswaService;
import latihanSpringBoot.latihanSpringBoot.service.NilaiService;
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
public class JurusanController {

    @Autowired
    private JurusanService jb;
    @Autowired
    private StaffService ss;

    @GetMapping("/jurusan/form")
    public String JurusanForm(Model model) {
        model.addAttribute("DataJB", null);
        return "jurusan/jurusanform";
    }

    @GetMapping("/jurusan/form/e/{id}")
    public String EditJurusan(@PathVariable(value = "id") int id_JB, Model model) {
        for (Object[] object : jb.getlistjurusanbyid(id_JB)) {
            model.addAttribute("DataJB", object);
        }

        return "jurusan/jurusanform";
    }

    @GetMapping("/jurusan/form/d/{id}")
    public String DeleteJurusan(@PathVariable(value = "id") int id_JB, Model model) {
        jb.DeleteJurusan(id_JB);
       return "redirect:/jurusan/list";
    }

    @PostMapping("/jurusan/form/s")
    public String SaveJurusanForm(
            @RequestParam("nama") String jurusanNama,
            @RequestParam("prodi") String prodi,
            @RequestParam("id") int idsss
    ) {
        if (idsss != 0) {
            System.out.println("OKE");
            TbJurusan jurusan = new TbJurusan(idsss, jurusanNama, prodi, false);
            jb.SaveJurusan(jurusan);
        } else {
            System.out.println("NO");
              TbJurusan jurusan = new TbJurusan( jurusanNama, prodi, false);
            jb.SaveJurusan(jurusan);
        }
        return "redirect:/jurusan/list";
    }

    @GetMapping("/jurusan/list")
    public String ListJurusan(Model model) {
        List<Object[]> listJB = new ArrayList<>();
        for (Object[] object : jb.getlistjurusan()) {
            listJB.add(object);
        }
        model.addAttribute("DataJB", listJB);
        return "jurusan/jurusanlist";
    }

    @RequestMapping(value = "/jurusan/getliststaff")
    @ResponseBody
    public List<Map<String, String>> autocompletestaff(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : ss.getlistStaffbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString()+" - "+object[2].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }
    @RequestMapping(value = "/jurusan/form/e/getliststaff")
    @ResponseBody
    public List<Map<String, String>> autocompletestaff2(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : ss.getlistStaffbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString()+" - "+object[2].toString());
            map.put("value", object[1].toString());
            map.put("id", object[0].toString());
            listJB.add(map);
        }

        return listJB;
    }

}
