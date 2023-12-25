package card.customer.service;


import card.customer.dto.CreateCustomerDTO;
import card.customer.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO addCustomer(CreateCustomerDTO createAdminUserDto);
}

