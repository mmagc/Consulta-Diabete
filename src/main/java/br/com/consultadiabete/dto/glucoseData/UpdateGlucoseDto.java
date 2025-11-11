package br.com.consultadiabete.dto.glucoseData;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGlucoseDto {

    @NotNull
    int glucose;

    @NotBlank
    String meassurementTime;

}
