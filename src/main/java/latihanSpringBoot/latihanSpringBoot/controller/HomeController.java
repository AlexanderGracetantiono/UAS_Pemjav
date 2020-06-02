/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanSpringBoot.latihanSpringBoot.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author alexa
 */
@Controller
public class HomeController {
      @GetMapping("/Home")
    public String HomeRoute(
    ) throws IOException {
//          return "approval/parkingreimbursement/ParkingAddLocation";
        return "index";
    }
}
