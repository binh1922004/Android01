package hcmute.edu.server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
    String email;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
