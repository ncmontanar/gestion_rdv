package hopital.gestion_rdv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GestionRdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionRdvApplication.class, args);
	}

}
