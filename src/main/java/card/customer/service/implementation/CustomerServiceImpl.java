package card.customer.service.implementation;


import card.customer.dto.CreateCustomerDTO;
import card.customer.dto.CustomerDTO;
import card.customer.model.Customer;
import card.customer.repository.CustomerRepository;
import card.customer.service.CustomerService;
import card.general.service.GeneralService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final GeneralService generalService;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDTO addCustomer(CreateCustomerDTO createCustomerDTO) {
        log.info("Request to create a customer with payload = {}", createCustomerDTO);

        //create new customer
        Customer customer = new Customer();
        customer.setEmail(customer.getEmail());
        customer.setFirstName(createCustomerDTO.getFirstName());
        customer.setLastName(createCustomerDTO.getLastName());

        // save to db
        Customer savedAdminUser = saveCustomer(customer);

        // convert to dto
        return getCustomerDTO(savedAdminUser);
    }

    public Customer saveCustomer(Customer customer) {
        log.info("::: saving customer to db :::");
        return customerRepository.save(customer);
    }

    public CustomerDTO getCustomerDTO(Customer customer) {

        CustomerDTO customerDTO = new CustomerDTO();
        generalService.createDTOFromModel(customer, customerDTO);

        return customerDTO;
    }
}