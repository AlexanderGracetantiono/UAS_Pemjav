/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import latihanSpringBoot.latihanSpringBoot.enitity.TbRuang;
import latihanSpringBoot.latihanSpringBoot.service.JabatanService;
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

/**
 *
 * @author alexa
 */
@Controller
public class RuangController {

    @Autowired
    private RuangService jb;
    @Autowired
    private StaffService ss;
    
    @GetMapping("/ruang/form")
    public String RuangForm(Model model) {
        model.addAttribute("DataJB", null);
        return "ruang/ruangform";
    }

    @GetMapping("/ruang/form/e/{id}")
    public String EditRuang(@PathVariable(value = "id") String id_JB, Model model) {
        for (Object[] object : jb.getlistRuangbyid(id_JB)) {
            model.addAttribute("DataJB", object);
        }

        return "ruang/ruangform";
    }

    @GetMapping("/ruang/form/d/{id}")
    public String DeleteRuang(@PathVariable(value = "id") String id_JB, Model model) {
        jb.DeleteRuang(id_JB);
       return "redirect:/ruang/list";
    }

    @PostMapping("/ruang/form/s")
    public String SaveRuangForm(
            @RequestParam("nama") String ruangNama,
            @RequestParam("staff") String staff,
            @RequestParam("id") int ids
    ) {
        
        if (ids!=0) {
            System.out.println("OKE");
            TbRuang ruang = new TbRuang(ids, ruangNama, staff,false);
            jb.SaveRuang(ruang);
        } else {
            System.out.println("NO");
            TbRuang ruang = new TbRuang(ruangNama, staff,false);
            jb.SaveRuang(ruang);
        }
        return "redirect:/ruang/list";
    }

    @GetMapping("/ruang/list")
    public String ListRuang(Model model) {
        List<Object[]> listJB = new ArrayList<>();
        for (Object[] object : jb.getlistRuang()) {
            listJB.add(object);
        }
        model.addAttribute("DataJB", listJB);
        return "ruang/ruanglist";
    }

    @RequestMapping(value = "/ruang/getliststaff")
    @ResponseBody
    public List<Map<String, String>> autocompletejb(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : ss.getlistStaffbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString()+" - "+object[2].toString());
            map.put("value", object[1].toString());
            listJB.add(map);
        }

        return listJB;
    }
    @RequestMapping(value = "/ruang/form/e/getliststaff")
    @ResponseBody
    public List<Map<String, String>> autocompletejb2(@RequestParam(value = "term", required = false, defaultValue = "") String term, Model model
    ) {
        System.out.println("Term: " + term);
        List<Map<String, String>> listJB = new ArrayList<>();

        for (Object[] object : ss.getlistStaffbyname(term)) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("label", object[1].toString()+" - "+object[2].toString());
            map.put("value", object[1].toString());
            listJB.add(map);
        }

        return listJB;
    }

}
