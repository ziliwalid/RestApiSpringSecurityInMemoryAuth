package com.example.apispringsecurity.Controllers;

import com.example.apispringsecurity.Repository.ProdRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ProdController {


    private final ProdRepository prodRepo;

    public ProdController(ProdRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    @GetMapping("/test")
    public String test(){
        return "test fulfilled mr hylian";
    }

    @GetMapping("/NoSecurity")
    public String testNonSecu(){
        return "3azi finia secu";
    }

    @GetMapping("/")

    public  String testwal(){
        return "test fulfilled";
    }
}
