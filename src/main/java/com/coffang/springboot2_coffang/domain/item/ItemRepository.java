package com.coffang.springboot2_coffang.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//ItemRepository만 사용해도 type casting을 사용해서 Brewing,Coffee,Serveware를 모두 가져올 수 있다.
public interface ItemRepository extends JpaRepository<Item,Long> {
}

