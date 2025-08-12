package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.DTO.OrderDTO.OrderItemResponseDTO;
import com.spring.OnlineBookStoreSystem.DTO.OrderDTO.OrderRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.OrderDTO.OrderResponseDTO;
import com.spring.OnlineBookStoreSystem.Model.OrderItem;
import com.spring.OnlineBookStoreSystem.Model.Orders;
import com.spring.OnlineBookStoreSystem.Model.User;
import com.spring.OnlineBookStoreSystem.Repository.OrderRepository;
import com.spring.OnlineBookStoreSystem.Repository.UserRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private UserRepository userRepo;

    public List<OrderResponseDTO> getAllOrders() {
        return orderRepo.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<OrderResponseDTO> getOrderById(int id) {
        return orderRepo.findById(id)
                .map(this::convertToResponseDTO);
    }

    public OrderResponseDTO addOrders(OrderRequestDTO dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Orders order = new Orders();
        order.setTotalPrice(dto.getTotalPrice());
        order.setOrderDate(dto.getOrderDate());
        order.setStatus(dto.getStatus());
        order.setUser(user);

        Orders savedOrder = orderRepo.save(order);
        return convertToResponseDTO(savedOrder);
    }

    public String deleteOrderById(int id) {
        if (!orderRepo.existsById(id)) {
            return "Order not found";
        }
        orderRepo.deleteById(id);
        return "Order deleted successfully";
    }

    public List<OrderResponseDTO> findByStatus(String status) {
        return orderRepo.findByStatusIgnoreCase(status).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDTO> findByUser_UserId(int id) {
        return orderRepo.findByUser_UserId(id).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDTO> findByUser_UserName(String name) {
        return orderRepo.findByUser_UserNameIgnoreCase(name).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDTO> findByUser_UserIdOrderByOrderDateDesc(int userId) {
        return orderRepo.findByUser_UserIdOrderByOrderDateDesc(userId).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private OrderResponseDTO convertToResponseDTO(Orders order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getOrderId());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setUserId(order.getUser().getUserId());
        dto.setUserName(order.getUser().getUserName());

        if (order.getOrderItem() != null) {
            dto.setOrderItems(order.getOrderItem().stream()
                    .map(this::convertOrderItemToDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    private OrderItemResponseDTO convertOrderItemToDTO(OrderItem item) {
        OrderItemResponseDTO dto = new OrderItemResponseDTO();
        dto.setOrderItemId(item.getOrderItemsId());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPriceAtPurchase());
        dto.setBookId(item.getBook().getBookId());
        dto.setBookTitle(item.getBook().getBookName());
        return dto;
    }
}
