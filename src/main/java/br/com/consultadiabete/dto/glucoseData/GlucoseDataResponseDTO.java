package br.com.consultadiabete.dto.glucoseData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlucoseDataResponseDTO {

    private UUID id;
    private int glucose;
    private String meassurementTime;
    private String userName;

}
