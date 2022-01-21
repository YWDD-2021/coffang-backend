package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;
    private final ItemService itemService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "index";
    }

}