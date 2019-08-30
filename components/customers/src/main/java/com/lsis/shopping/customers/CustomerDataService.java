package com.lsis.shopping.customers;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDataService {
    private CustomerRepository customerRepository;

    public CustomerDataService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void add(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> getAll(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer get(String id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    public void update(Customer customer){
        Customer customerEntity = customerRepository.findById(customer.getId()).get();
        if(customer.getName()!=null) customerEntity.setName(customer.getName());
        if(customer.getPhone()!=null) customerEntity.setPhone(customer.getPhone());
        if(customer.getEmail()!=null) customerEntity.setEmail(customer.getEmail());

        customerRepository.save(customerEntity);
    }

    public void delete(Customer customer){
        customerRepository.delete(customer);
    }

    public void deleteById(String id){
        customerRepository.deleteById(id);
    }
}
