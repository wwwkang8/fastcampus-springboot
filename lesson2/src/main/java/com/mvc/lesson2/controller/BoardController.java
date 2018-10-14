package com.mvc.lesson2.controller;

import com.mvc.lesson2.utils.ServerInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/boards")
public class BoardController {

    @GetMapping
    public String list(
            ServerInfo serverInfo,
            @RequestParam
    ){

    }

}
