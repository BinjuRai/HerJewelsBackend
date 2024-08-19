package com.example.herjewels.Service;

import com.example.herjewels.Entity.Order;
import com.example.herjewels.dto.OrderHistoryDTO;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);
    List<Order> getAllOrders();
    List<OrderHistoryDTO> getOrderHistory();
}
