package com.example.herjewels.Service;

import com.example.herjewels.Entity.Item;
import com.example.herjewels.dto.ItemDTO;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    void deleteByName(String productName);
    String save(ItemDTO productDTO);
    List<Item> getAll();
    Optional<Item> getById(Integer productId);
    void deleteById(Integer productId);

    Optional<Item> getByProductName(String productName);

    void update(ItemDTO updatedItemDTO);
}
