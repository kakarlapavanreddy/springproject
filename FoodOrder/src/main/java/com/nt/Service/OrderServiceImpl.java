package com.nt.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.FoodOrder;
import com.nt.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    // ADD ORDER
    @Override
    public FoodOrder addOrder(FoodOrder order) {

        return repository.save(order);
    }

    // GET ALL ORDERS
    @Override
    public List<FoodOrder> getAllOrders() {

        return repository.findAll();
    }

    // GET ORDER BY ID
    @Override
    public FoodOrder getOrderById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with ID : " + id));
    }

    // UPDATE ORDER
    @Override
    public FoodOrder updateOrder(Long id, FoodOrder order) {

        FoodOrder existingOrder = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cannot update. Order not found with ID : " + id));

        existingOrder.setCustomerName(order.getCustomerName());
        existingOrder.setFoodItem(order.getFoodItem());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setPrice(order.getPrice());

        return repository.save(existingOrder);
    }

    // DELETE ORDER
    @Override
    public void deleteOrder(Long id) {

        FoodOrder existingOrder = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cannot delete. Order not found with ID : " + id));

        repository.delete(existingOrder);
    }
}