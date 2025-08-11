package com.spring.OnlineBookStoreSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.OnlineBookStoreSystem.Model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
