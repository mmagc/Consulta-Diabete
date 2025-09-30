package br.com.consultadiabete.dto.glucoseData;

import br.com.consultadiabete.dto.users.CreateUserDto;
import br.com.consultadiabete.entities.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateGlucoseDto {

    @NotNull
    @Column(nullable = false)
    int glucose;

    @NotBlank
    @Column(nullable = false)
    String meassurementTime;

    @NotNull(message = "User ID is required")
    private UUID userId;

}
