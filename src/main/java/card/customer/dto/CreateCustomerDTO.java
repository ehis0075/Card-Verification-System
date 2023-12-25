package card.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Phone number cannot be blank")
    @Size(min = 11, max = 11, message = "Phone number must contain 11 digits")
    private String phoneNumber;
    @NotNull(message = "Role id cannot be null")
    private Long roleId;
    @NotBlank(message = "password cannot be blank")
    private String password;
}
