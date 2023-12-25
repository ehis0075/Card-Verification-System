//package card.bank.customer.controller;
//
//
//import card.bank.customer.dto.CreateCustomerDTO;
//import card.bank.customer.dto.CustomerDTO;
//import card.bank.customer.service.CustomerService;
//import card.bank.general.dto.Response;
//import card.bank.general.enums.ResponseCodeAndMessage;
//import card.bank.general.service.GeneralService;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/api/v1/customers")
//public class CustomerController {
//
//    private final GeneralService generalService;
//    private final HttpServletRequest request;
//    private final CustomerService customerService;
//
//    public CustomerController(GeneralService generalService, HttpServletRequest request, CustomerService customerService) {
//        this.generalService = generalService;
//        this.request = request;
//        this.customerService = customerService;
//    }
//
//    @PostMapping("/create")
//    public Response createCustomer(@RequestBody CreateCustomerDTO requestDTO) {
//
//        CustomerDTO data = customerService.addCustomer(requestDTO);
//        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
//    }
//
//
//}
