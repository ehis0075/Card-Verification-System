//package card.bank.customer.model;
//
//
//import card.bank.customer.dto.UserSecurityDetailsDTO;
//import card.bank.auth.model.UserSecurityDetails;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.beans.BeanUtils;
//
//
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@Entity
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String firstName;
//
//    private String lastName;
//
//    private String phoneNumber;
//
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private UserSecurityDetails userSecurityDetails;
//
//    public static UserSecurityDetailsDTO getUserSecurityDetailsDTO(UserSecurityDetails userSecurityDetails) {
//
//        UserSecurityDetailsDTO userSecurityDetailsDTO = new UserSecurityDetailsDTO();
//        BeanUtils.copyProperties(userSecurityDetails, userSecurityDetailsDTO);
//
//        return userSecurityDetailsDTO;
//    }
//
//}
