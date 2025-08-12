package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.DTO.UserDTO.UserRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.UserDTO.UserResponseDTO;
import com.spring.OnlineBookStoreSystem.Model.Cart;
import com.spring.OnlineBookStoreSystem.Model.Orders;
import com.spring.OnlineBookStoreSystem.Model.User;
import com.spring.OnlineBookStoreSystem.Model.UserDetails;
import com.spring.OnlineBookStoreSystem.Repository.CartRepository;
import com.spring.OnlineBookStoreSystem.Repository.OrderRepository;
import com.spring.OnlineBookStoreSystem.Repository.UserDetailsRepository;
import com.spring.OnlineBookStoreSystem.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CartRepository cartRepo;
    @Autowired
    private UserDetailsRepository userDetailsRepo;
    @Autowired
    private OrderRepository ordersRepo;

    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserResponseDTO> getUserByUserId(int id) {
        return userRepo.findById(id)
                .map(this::convertToResponseDTO);
    }

    public String deleteUserById(int id) {
        if (!userRepo.existsById(id)) {
            return "No User Found";
        }
        userRepo.deleteById(id);
        return "User deleted successfully";
    }

    public UserResponseDTO saveUser(UserRequestDTO userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        User savedUser = userRepo.save(user);
        return convertToResponseDTO(savedUser);
    }

    public String linkUserWithCart(int userId, int cartId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        user.setCart(cart);
        cart.setUser(user);

        userRepo.save(user);
        return "User linked with Cart successfully";
    }

    public String linkUserWithUserDetails(int userId, int detailsId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserDetails details = userDetailsRepo.findById(detailsId)
                .orElseThrow(() -> new RuntimeException("UserDetails not found"));

        user.setUserDetails(details);
        details.setUser(user);

        userRepo.save(user);
        return "User linked with UserDetails successfully";
    }

    public String linkUserWithOrder(int userId, int orderId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Orders order = ordersRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setUser(user);
        user.getOrder().add(order);

        userRepo.save(user);
        return "User linked with Order successfully";
    }

    private UserResponseDTO convertToResponseDTO(User user) {
        UserResponseDTO userDto = new UserResponseDTO();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
