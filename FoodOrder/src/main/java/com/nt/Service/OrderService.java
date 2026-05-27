package com.nt.Service;

import java.util.List;

import com.nt.Entity.FoodOrder;

public interface OrderService {

    FoodOrder addOrder(FoodOrder order);

    List<FoodOrder> getAllOrders();

    FoodOrder getOrderById(Long id);

    FoodOrder updateOrder(Long id, FoodOrder order);

    void deleteOrder(Long id);
}