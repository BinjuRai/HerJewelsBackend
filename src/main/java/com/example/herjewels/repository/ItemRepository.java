package com.example.herjewels.repository;

import com.example.herjewels.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByProductName(String productName);
}
