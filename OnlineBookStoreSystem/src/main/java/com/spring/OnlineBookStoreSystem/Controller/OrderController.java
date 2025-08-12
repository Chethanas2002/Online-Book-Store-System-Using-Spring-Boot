package com.spring.OnlineBookStoreSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.DTO.OrderDTO.OrderRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.OrderDTO.OrderResponseDTO;
import com.spring.OnlineBookStoreSystem.Service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable int id) {
        Optional<OrderResponseDTO> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> addOrders(@RequestBody OrderRequestDTO dto) {
        return ResponseEntity.ok(orderService.addOrders(dto));
    }

    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable int id) {
        return orderService.deleteOrderById(id);
    }

    @GetMapping("/status/{status}")
    public List<OrderResponseDTO> findByStatus(@PathVariable String status) {
        return orderService.findByStatus(status);
    }

    @GetMapping("/user/{userId}")
    public List<OrderResponseDTO> findByUserId(@PathVariable int userId) {
        return orderService.findByUser_UserId(userId);
    }

    @GetMapping("/username/{userName}")
    public List<OrderResponseDTO> findByUserName(@PathVariable String userName) {
        return orderService.findByUser_UserName(userName);
    }

    @GetMapping("/user/{userId}/desc")
    public List<OrderResponseDTO> findByUserIdDesc(@PathVariable int userId) {
        return orderService.findByUser_UserIdOrderByOrderDateDesc(userId);
    }
}
