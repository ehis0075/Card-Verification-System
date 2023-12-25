package card.customer.controller;


import card.customer.dto.CreateCustomerDTO;
import card.customer.dto.CustomerDTO;
import card.customer.service.CustomerService;
import card.general.dto.Response;
import card.general.enums.ResponseCodeAndMessage;
import card.general.service.GeneralService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final GeneralService generalService;
    private final CustomerService customerService;

    public CustomerController(GeneralService generalService, CustomerService customerService) {
        this.generalService = generalService;
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public Response createCustomer(@RequestBody CreateCustomerDTO requestDTO) {

        CustomerDTO data = customerService.addCustomer(requestDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }


}
