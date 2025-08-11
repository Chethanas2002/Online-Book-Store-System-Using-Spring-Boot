package com.spring.OnlineBookStoreSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.OnlineBookStoreSystem.Model.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
