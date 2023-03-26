package com.project.springCrud.Service;

import com.project.springCrud.DTO.CustomerDTO;
import com.project.springCrud.DTO.CustomerSaveDTO;
import com.project.springCrud.DTO.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveDTO customerSaveDTO);

    List<CustomerDTO> getAllCustomer();

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    boolean deleteCustomer(int id);
}
