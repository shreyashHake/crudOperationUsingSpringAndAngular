package com.project.springCrud.CustomerController;

import com.project.springCrud.DTO.CustomerDTO;
import com.project.springCrud.DTO.CustomerSaveDTO;
import com.project.springCrud.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
