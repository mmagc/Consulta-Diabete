package br.com.consultadiabete.dto.glucoseData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlucoseDataResponseDTO {

    private int glucose;
    private String measurementTime;
    private String userName;

}
