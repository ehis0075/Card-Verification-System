package card.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CreateCustomerDTO {
    @NotBlank(message = "first name cannot be blank")
    private String firstName;
    @NotBlank(message = "last name cannot be blank")
    private String lastName;
    @Email(message = "Invalid email")
    @NotBlank(message = "Email cannot be blank")
    private String email;
}
