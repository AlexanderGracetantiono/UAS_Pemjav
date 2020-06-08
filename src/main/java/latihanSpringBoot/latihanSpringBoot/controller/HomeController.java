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
public class HomeController {

    @Autowired
    private LoginService ls;
    @Autowired
    private MahasiswaService MHSS;
    @Autowired
    private StaffService SS;
    @Autowired
    private RuangService RS;
    @Autowired
    private MatkulService MS;

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
    public String HomePage(Model model) {

        model.addAttribute("SumMHS",MHSS.countMHS());
        model.addAttribute("SumMatkul",MS.CountMatkul());
        model.addAttribute("SumStaff",SS.CountStaff());
        model.addAttribute("SumRuang",RS.CountRuang());
        System.out.println("Hasil; "+ MHSS.countMHS());
        return "home";
    }

}
