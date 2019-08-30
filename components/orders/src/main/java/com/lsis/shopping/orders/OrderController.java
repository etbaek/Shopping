package com.lsis.shopping.orders;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderDataService orderDataService;


    public OrderController(OrderDataService orderDataService) {
        this.orderDataService = orderDataService;
    }

    @PostMapping
    public void addOrder(@RequestBody Order order){
        orderDataService.add(order);
    }

    @GetMapping
    public List<Order> getOrder(@RequestParam(value="customerId", required =false, defaultValue="00000000") String customerId) {
        if(!customerId.equals("00000000")){
            return orderDataService.getByCustomerId(customerId);
        }
        else {
            return orderDataService.getAll();
        }
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderDataService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderDataService.deleteById(id);
    }

    @DeleteMapping
    public void deleteOrder(@RequestBody Order order){
        orderDataService.delete(order);
    }

    @PutMapping
    public void updateOrder(@RequestBody Order order){
        orderDataService.update(order);
    }

}
