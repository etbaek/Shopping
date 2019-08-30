package com.lsis.shopping.orders;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDataService {
    private OrderRepository orderRepository;

    public OrderDataService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void add(Order order){
        orderRepository.save(order);
    }

    public List<Order> getAll(){
        return (List<Order>) orderRepository.findAll();
    }

    public Order get(Long id){
        Optional<Order> orders = orderRepository.findById(id);
        return orders.get();
    }

    public List<Order> getByCustomerId(String customerId){
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders;
    }

    public void update(Order order){

        Order orderEntity = orderRepository.findById(order.getId()).get();
        if(order.getReceiverName()!=null) orderEntity.setReceiverName(order.getReceiverName());
        if(order.getReceiverAddress()!=null) orderEntity.setReceiverAddress(order.getReceiverAddress());
        if(order.getReceiverPhone()!=null) orderEntity.setReceiverPhone(order.getReceiverPhone());

        orderRepository.save(orderEntity);
    }

    public void delete(Order order){
        orderRepository.delete(order);
    }

    public void deleteById(Long id){
        orderRepository.deleteById(id);
    }
}
