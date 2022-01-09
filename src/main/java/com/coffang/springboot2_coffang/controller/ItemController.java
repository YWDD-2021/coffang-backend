package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.service.ItemService;
import com.coffang.springboot2_coffang.dto.ItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/api/v1/items")
    public List<ItemResponseDto> findAll() {
        return itemService.findAll();
    }
}
