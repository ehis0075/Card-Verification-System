package card.customer.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserSecurityDetailsDTO {

    private Long id;
    private String email;
    private String password;
    private boolean enabled;
    private boolean locked;
    private Set<String> authorities;
    private boolean isLoggedIn;
}
