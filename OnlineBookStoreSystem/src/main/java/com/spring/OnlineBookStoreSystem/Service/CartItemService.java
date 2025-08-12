package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.DTO.CartItemDTO.CartItemRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.CartItemDTO.CartItemResponseDTO;
import com.spring.OnlineBookStoreSystem.Model.Book;
import com.spring.OnlineBookStoreSystem.Model.Cart;
import com.spring.OnlineBookStoreSystem.Model.CartItem;
import com.spring.OnlineBookStoreSystem.Repository.BookRepository;
import com.spring.OnlineBookStoreSystem.Repository.CartItemRepository;
import com.spring.OnlineBookStoreSystem.Repository.CartRepository;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cItemRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private BookRepository bookRepo;

    public Optional<CartItemResponseDTO> getCartItemById(int cartItemId) {
        return cItemRepo.findById(cartItemId)
                .map(this::convertToResponseDTO);
    }

    public List<CartItemResponseDTO> getAllCartItem() {
        return cItemRepo.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public CartItemResponseDTO addCartItem(CartItemRequestDTO dto) {
        Cart cart = cartRepo.findById(dto.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found with ID: " + dto.getCartId()));

        Book book = bookRepo.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + dto.getBookId()));

        CartItem cartItem = new CartItem();
        cartItem.setQuantity(dto.getQuantity());
        cartItem.setPrice(dto.getPrice());
        cartItem.setCart(cart);
        cartItem.setBook(book);

        CartItem savedItem = cItemRepo.save(cartItem);

        return convertToResponseDTO(savedItem);
    }

    public String deleteCartItemById(int cartItemId) {
        if (!cItemRepo.existsById(cartItemId)) {
            return "Cart Item not found";
        }
        cItemRepo.deleteById(cartItemId);
        return "Cart item deleted successfully";
    }

    private CartItemResponseDTO convertToResponseDTO(CartItem cartItem) {
        return new CartItemResponseDTO(
                cartItem.getCartItemsId(),
                cartItem.getQuantity(),
                cartItem.getPrice(),
                cartItem.getCart().getCartId(),
                cartItem.getBook().getBookId(),
                cartItem.getBook().getBookName()
        );
    }
    
    public List<CartItemResponseDTO> getCartItemsByUserId(int userId) {
        return cItemRepo.findByCart_User_UserId(userId)
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }
}
