//package card.bank.customer.service.implementation;
//
//
//import card.bank.auth.model.UserSecurityDetails;
//import card.bank.auth.service.UserSecurityDetailsService;
//import card.bank.customer.dto.CreateCustomerDTO;
//import card.bank.customer.dto.CustomerDTO;
//import card.bank.customer.dto.UserSecurityDetailsDTO;
//import card.bank.customer.model.Customer;
//import card.bank.customer.repository.CustomerRepository;
//import card.bank.customer.service.CustomerService;
//import card.bank.exception.GeneralException;
//import card.bank.general.enums.ResponseCodeAndMessage;
//import card.bank.general.service.GeneralService;
//import card.bank.util.GeneralUtil;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.Objects;
//
//@Slf4j
//@Service
//@AllArgsConstructor
//public class CustomerServiceImpl implements CustomerService {
//
//    private final GeneralService generalService;
//    private final CustomerRepository customerRepository;
//    private final UserSecurityDetailsService userSecurityDetailsService;
//
//
//    @Override
//    public CustomerDTO addCustomer(CreateCustomerDTO createAdminUserDto) {
//        log.info("Request to create an customer with payload = {}", createAdminUserDto);
//
//        //validate first name, last name and phone number
//        GeneralUtil.validateNameAndPhoneNumber(createAdminUserDto.getFirstName(), createAdminUserDto.getLastName(), createAdminUserDto.getPhoneNumber());
//
//        // check that email is not null or empty
//        validateEmail(createAdminUserDto.getEmail());
//
//        //validate that email does not exist
//        boolean isExist = userSecurityDetailsService.validateEmail(createAdminUserDto.getEmail());
//        if (isExist) {
//            throw new GeneralException(ResponseCodeAndMessage.ALREADY_EXIST_86.responseCode, "Email already Exist!");
//        }
//
//        UserSecurityDetails userSecurityDetails = userSecurityDetailsService.createUserSecurityDetails(createAdminUserDto);
//
//        //create new admin user
//        Customer customer = new Customer();
//        customer.setFirstName(createAdminUserDto.getFirstName());
//        customer.setLastName(createAdminUserDto.getLastName());
//        customer.setPhoneNumber(createAdminUserDto.getPhoneNumber());
//        customer.setUserSecurityDetails(userSecurityDetails);
//
//        // save to db
//        Customer savedAdminUser = saveAdminUser(customer);
//
//        // convert to dto
//        return getCustomerDTO(savedAdminUser);
//    }
//
//    @Override
//    public Long getCustomerIdByEmail(String email) {
//        return customerRepository.findCustomerByUserSecurityDetails_Email(email).orElseThrow(() ->
//                new GeneralException(ResponseCodeAndMessage.RECORD_NOT_FOUND_88.responseCode, "Customer not found")).getId();
//    }
//
//    private void validateEmail(String email) {
//        if (GeneralUtil.invalidEmail(email)) {
//            log.info("Admin User email {} is invalid", email);
//            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "Admin User Email " + email + " is invalid!");
//        }
//
//        if (userSecurityDetailsService.validateEmail(email)) {
//            throw new GeneralException(ResponseCodeAndMessage.ALREADY_EXIST_86.responseCode, "Email already exist");
//        }
//    }
//
//
//    public Customer saveAdminUser(Customer adminUser) {
//        log.info("::: saving admin user to db :::");
//        return customerRepository.save(adminUser);
//    }
//
//
//    public CustomerDTO getCustomerDTO(Customer customer) {
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        generalService.createDTOFromModel(customer, customerDTO);
//
//        UserSecurityDetails userSecurityDetails = customer.getUserSecurityDetails();
//
//        if (Objects.nonNull(customer.getUserSecurityDetails())) {
//            UserSecurityDetailsDTO userSecurityDetailsDTO = Customer.getUserSecurityDetailsDTO(userSecurityDetails);
//            customerDTO.setUserSecurityDetailsDTO(userSecurityDetailsDTO);
//        }
//
//        // set the others
//        customerDTO.setEmail(userSecurityDetails.getEmail());
//        customerDTO.setEnabled(userSecurityDetails.isEnabled());
//
//        return customerDTO;
//    }
//}