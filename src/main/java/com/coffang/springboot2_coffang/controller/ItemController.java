package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.service.ItemService;
import com.coffang.springboot2_coffang.dto.ItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/v1/items")
    @ResponseBody
    public List<ItemResponseDto> findAll() {
        return itemService.findAll();
    }
}
