package com.project.springCrud.Service;

import com.project.springCrud.CustomerRepo.CustomerRepo;
import com.project.springCrud.DTO.CustomerSaveDTO;
import com.project.springCrud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String addCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customer = new Customer(
                customerSaveDTO.getCustomerName(),
                customerSaveDTO.getCustomerAddress(),
                customerSaveDTO.getMobile()

        );

        customerRepo.save(customer);
        return customer.getCustomerName();
    }
}
