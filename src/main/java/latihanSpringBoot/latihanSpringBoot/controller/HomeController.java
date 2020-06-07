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
public class HomeController {

    @Autowired
    private LoginService ls;
    @Autowired
    private MahasiswaService mhsservice;
    @Autowired
    private NilaiService nilaiService;

    @GetMapping("/")
    public String HomeRoute() {
        return "login";
    }

    @GetMapping("/login")
    public String LoginPage() {
        return "login";
    }

    @PostMapping("/loginpage")
    public String UserLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        try {
            int counter = 0;
            for (Object[] object : ls.checkUserLogin(username, password)) {
                System.out.println("LoginData: " + object[2]);
                counter++;
            }
            if (counter == 1) {
                return "redirect:/home";
            } else {
                return "redirect:/login?err=invalid";
            }
        } catch (Exception e) {
            return "redirect:/login?err=invalid";
        }

    }

    @GetMapping("/home")
    public String HomePage() {
        return "home";
    }

    @GetMapping("/nilai/form")
    public String FormNilai() {
        return "nilai/form";
    }

    @PostMapping("/nilai/form/s")
    public String SaveNilaiForm(
            @RequestParam("uts") int uts,
            @RequestParam("uas") int uas,
            @RequestParam("harian") int harian,
            @RequestParam("namaMHS") String namaMHS,
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
        TbNilai tb_nilai = new TbNilai(NIK, uas, uts, harian, (int) rerata, Grade);
        nilaiService.saveNilaiAkhir(tb_nilai);
        return "redirect:/nilai/list";
    }

    @RequestMapping(value = "/nilai/getlistmhs")
    @ResponseBody
    public List<Map<String, String>> autocomplete2(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {

        List<Map<String, String>> listParking = new ArrayList<>();

        for (Object[] object : mhsservice.listMHS()) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString() + " - " + object[2].toString());
            map.put("value", object[1].toString());
            map.put("nim", object[2].toString());
            listParking.add(map);
        }

        return listParking;
    }

    @GetMapping("/nilai/list")
    public String ListNilai() {
        return "home";
    }

    @GetMapping("/mhs/form")
    public String FormMHS(Model model) {
        model.addAttribute("DataMHS", null);
        return "mhs/form";
    }

    @GetMapping("/mhs/e/{id}")
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
            @RequestParam("jurusanMHS") String jurusan
    ) {
        String nik = "";
        switch (jurusan) {
            case "Teknologi Informasi":
                nik += "5";
                break;
            case "Sistem Informasi":
                nik += "4";
                break;
            case "Management":
                nik += "3";
                break;
            case "Akuntansi":
                nik += "2";
                break;
            default:
                nik += "1";
        }
        nik += tahun;
        String count = "00" + Integer.toString(mhsservice.countMHS() + 1);
        if (id_mhs != 0) {
            nik += "00" + id_mhs;
            TbMhs mhs = new TbMhs(id_mhs, nama, nik, jurusan, tahun);
            mhsservice.saveMHS(mhs);
        } else {
            nik += count;
            TbMhs mhs = new TbMhs(nama, nik, jurusan, tahun);
            mhsservice.saveMHS(mhs);
        }
        return "redirect:/mhs/list";
    }
}
