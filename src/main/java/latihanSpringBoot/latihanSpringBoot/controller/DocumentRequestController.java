/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.HRISNEW.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dharta
 */
@Controller
public class DocumentRequestController {
     @GetMapping("/saveDocumentRequest")
    public String index() {
        System.out.println("Running Document Request");
        return "requester/documentrequest/documentRequest";
    }
    
    @RequestMapping("/historyDocumentRequest")
    public String historyDocumentRequest() {

        return "requester/documentrequest/historyDocumentRequest";
    }
}
