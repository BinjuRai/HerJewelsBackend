package com.example.herjewels.Controller;

import com.example.herjewels.Entity.Order;
import com.example.herjewels.Service.OrderService;
import com.example.herjewels.dto.OrderDTO;
import com.example.herjewels.dto.OrderHistoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            orderService.createOrder(order);
            return ResponseEntity.ok("Order successfully created");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order");
        }
    }

    @GetMapping("/history")
    public ResponseEntity<List<OrderDTO>> getOrderHistory() {
        try {
            List<OrderHistoryDTO> orderHistoryDTOs = orderService.getOrderHistory();
            List<OrderDTO> orderHistory = orderHistoryDTOs.stream()
                    .map(orderHistoryDTO -> convertToOrderDTO(orderHistoryDTO))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(orderHistory);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private OrderDTO convertToOrderDTO(OrderHistoryDTO orderHistoryDTO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderHistoryDTO.getOrderId());
        orderDTO.setProductName(orderHistoryDTO.getProductName());
        orderDTO.setPrice(orderHistoryDTO.getPrice());
        orderDTO.setQuantity(orderHistoryDTO.getQuantity());
        orderDTO.setTotal(orderHistoryDTO.getTotal());
//        orderDTO.setOrderDate(orderHistoryDTO.getOrderDate());

        return orderDTO;
    }
}