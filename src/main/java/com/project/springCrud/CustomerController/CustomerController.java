package com.project.springCrud.CustomerController;

import com.project.springCrud.DTO.CustomerDTO;
import com.project.springCrud.DTO.CustomerSaveDTO;
import com.project.springCrud.DTO.CustomerUpdateDTO;
import com.project.springCrud.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO) {
        return customerService.addCustomer(customerSaveDTO);
    }

    @GetMapping(path = "/getAllCustomer")
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomer();
        return allCustomers;
    }

    @PostMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        return customerService.updateCustomer(customerUpdateDTO);
    }
    @DeleteMapping(path = "/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id)
    {
        boolean deletecustomer = customerService.deleteCustomer(id);
        return "deleted";
    }
}
