package com.spring.OnlineBookStoreSystem.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.DTO.CartDTO.CartRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.CartDTO.CartResponseDTO;
import com.spring.OnlineBookStoreSystem.Model.Cart;
import com.spring.OnlineBookStoreSystem.Model.User;
import com.spring.OnlineBookStoreSystem.Repository.CartRepository;
import com.spring.OnlineBookStoreSystem.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    public CartResponseDTO addCart(CartRequestDTO cartRequest) {
        User user = userRepo.findById(cartRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        Cart savedCart = cartRepo.save(cart);

        return convertToDTO(savedCart);
    }

    public Optional<CartResponseDTO> getCartById(int id) {
        return cartRepo.findById(id).map(this::convertToDTO);
    }

    public String deleteCartById(int id) {
        if (!cartRepo.existsById(id)) {
            return "Cart not found";
        }
        cartRepo.deleteById(id);
        return "Cart deleted successfully";
    }

    public Optional<CartResponseDTO> findByCartByUserId(int userId) {
        return cartRepo.findByUser_UserId(userId).map(this::convertToDTO);
    }

    public Optional<CartResponseDTO> findByCartByUserName(String userName) {
        return cartRepo.findByUser_UserName(userName).map(this::convertToDTO);
    }

    @Transactional
    public String deleteCartByUserId(int userId) {
        Optional<Cart> cartOpt = cartRepo.findByUser_UserId(userId);
        if (cartOpt.isPresent()) {
            Cart cart = cartOpt.get();
            cart.setUser(null);
            cartRepo.delete(cart);
            return "Cart deleted successfully with user id: " + userId;
        } else {
            return "No cart found for user id: " + userId;
        }
    }

    private CartResponseDTO convertToDTO(Cart cart) {
        CartResponseDTO dto = new CartResponseDTO();
        dto.setCartId(cart.getCartId());
        if (cart.getUser() != null) {
            dto.setUserId(cart.getUser().getUserId());
            dto.setUserName(cart.getUser().getUserName());
        }
        if (cart.getCartItem() != null) {
            dto.setCartItemIds(
                cart.getCartItem().stream()
                    .map(item -> item.getCartItemsId()) // assuming CartItem has ID
                    .collect(Collectors.toList())
            );
        }
        return dto;
    }
}
