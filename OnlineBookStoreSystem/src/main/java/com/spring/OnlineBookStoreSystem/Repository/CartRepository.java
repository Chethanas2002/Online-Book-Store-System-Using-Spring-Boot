package com.spring.OnlineBookStoreSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.OnlineBookStoreSystem.Model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
