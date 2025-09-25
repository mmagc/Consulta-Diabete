package br.com.consultadiabete;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@SpringBootApplication
@EnableJpaAuditing
public class ConsultadiabeteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultadiabeteApplication.class, args);

        log.info("""
                 \n
                 ██████╗ ██████╗ ███╗   ██╗███████╗██╗   ██╗██╗  ████████╗ █████╗     ██████╗ ██╗ █████╗ ██████╗ ███████╗████████╗███████╗
                ██╔════╝██╔═══██╗████╗  ██║██╔════╝██║   ██║██║  ╚══██╔══╝██╔══██╗    ██╔══██╗██║██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██╔════╝
                ██║     ██║   ██║██╔██╗ ██║███████╗██║   ██║██║     ██║   ███████║    ██║  ██║██║███████║██████╔╝█████╗     ██║   █████╗ \s
                ██║     ██║   ██║██║╚██╗██║╚════██║██║   ██║██║     ██║   ██╔══██║    ██║  ██║██║██╔══██║██╔══██╗██╔══╝     ██║   ██╔══╝ \s
                ╚██████╗╚██████╔╝██║ ╚████║███████║╚██████╔╝███████╗██║   ██║  ██║    ██████╔╝██║██║  ██║██████╔╝███████╗   ██║   ███████╗
                 ╚═════╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝    ╚═════╝ ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝   ╚═╝   ╚══════╝
                
                  \s
                    Consulta Diabete :: 0.1
                \s""");

	}

}
