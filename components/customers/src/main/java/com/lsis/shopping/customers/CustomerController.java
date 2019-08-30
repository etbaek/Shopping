package com.lsis.shopping.customers;

import com.lsis.shopping.ordersapi.OrderClient;
import com.lsis.shopping.ordersapi.OrderInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerDataService customerDataService;
    private OrderClient orderClient;

    public CustomerController(CustomerDataService customerDataService, OrderClient orderClient) {
        this.customerDataService = customerDataService;
        this.orderClient = orderClient;
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        customerDataService.add(customer);
    }

    @GetMapping
    public List<Customer> getCustomerAll() {
        return customerDataService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerDataService.get(id);
    }

    @GetMapping("/{id}/order")
    public List<OrderInfo> getCustomerOrder(@PathVariable String id){
        return orderClient.getOrderByCustomerId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerDataService.deleteById(id);
    }

    @DeleteMapping
    public void deleteCustomer(@RequestBody Customer customer){
        customerDataService.delete(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer){
        customerDataService.update(customer);
    }
}
