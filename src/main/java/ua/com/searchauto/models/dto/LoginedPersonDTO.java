package ua.com.searchauto.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginedPersonDTO {

    @NotBlank
    @Size(min = 2, message = "too short")
    @Size(max = 200, message = "too long")
    private String username;
    @Email
    private String password;
}
