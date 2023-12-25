package card.customer.dto;

import lombok.Data;


@Data
public class UpdateAdminUserDTO {

    private String firstName;

    private String lastName;

    //private String email;

    private String phoneNumber;

    private Long roleId;
}