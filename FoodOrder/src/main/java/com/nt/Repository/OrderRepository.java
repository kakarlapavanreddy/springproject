package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.FoodOrder;

public interface OrderRepository extends JpaRepository<FoodOrder, Long> {

}