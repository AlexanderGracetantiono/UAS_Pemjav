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
import latihanSpringBoot.latihanSpringBoot.service.JabatanService;
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
public class JabatanController {

    @Autowired
    private JabatanService jb;

    @GetMapping("/jabatan/form")
    public String JabatanForm(Model model) {
        model.addAttribute("DataJB", null);
        return "jabatan/jabatanform";
    }

    @GetMapping("/jabatan/form/e/{id}")
    public String EditJabatan(@PathVariable(value = "id") int id_JB, Model model) {
        for (Object[] object : jb.getlistjabatanbyid(id_JB)) {
            model.addAttribute("DataJB", object);
        }

        return "jabatan/jabatanform";
    }

    @GetMapping("/jabatan/form/d/{id}")
    public String DeleteJabatan(@PathVariable(value = "id") int id_JB, Model model) {
        jb.DeleteJabatan(id_JB);
        return "redirect:/jabatan/list";
    }

    @PostMapping("/jabatan/form/s")
    public String SaveJabatanForm(
            @RequestParam("nama") String Jabatan,
            @RequestParam("id") int id
    ) {
        if (id != 0) {
            TbJabatan jabatan = new TbJabatan(id, Jabatan, false);
            jb.SaveJabatan(jabatan);
        } else {
            TbJabatan jabatan = new TbJabatan(Jabatan, false);
            jb.SaveJabatan(jabatan);
        }
        return "redirect:/jabatan/list";
    }

    @GetMapping("/jabatan/list")
    public String ListJabatan(Model model) {
        List<Object[]> listJB = new ArrayList<>();
        for (Object[] object : jb.getlistjabatan()) {
            listJB.add(object);
        }
        model.addAttribute("DataJB", listJB);
        return "jabatan/jabatanlist";
    }

    

}
