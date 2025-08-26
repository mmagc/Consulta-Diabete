package br.com.consultadiabete.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class CreateUserDto {

    @NotBlank
    String name;

    @NotBlank
    @Email
    String email;

    @NotBlank
    String password;

}
