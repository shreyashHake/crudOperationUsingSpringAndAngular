package com.project.springCrud.Service;

import com.project.springCrud.CustomerRepo.CustomerRepo;
import com.project.springCrud.DTO.CustomerDTO;
import com.project.springCrud.DTO.CustomerSaveDTO;
import com.project.springCrud.DTO.CustomerUpdateDTO;
import com.project.springCrud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer: getCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getMobile()
            );
            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setMobile(customerUpdateDTO.getMobile());

            customerRepo.save(customer);

            return "Updated Successfully!";

        } else {
            System.out.println("Customer Id does not exits");
        }

        return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            System.out.println("Customer Not found");
        }
        return true;
    }

}
