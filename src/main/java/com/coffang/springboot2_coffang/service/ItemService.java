package com.coffang.springboot2_coffang.service;

import com.coffang.springboot2_coffang.domain.item.Item;
import com.coffang.springboot2_coffang.domain.item.ItemRepository;
import com.coffang.springboot2_coffang.dto.ItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public List<ItemResponseDto> findAll() {
        List<Item> items = itemRepository.findAll();
        List<ItemResponseDto> itemResponseDtos =
                items.stream().map(Item::toResponseDto)
                        .collect(Collectors.toList());

        return itemResponseDtos;
    }
}
