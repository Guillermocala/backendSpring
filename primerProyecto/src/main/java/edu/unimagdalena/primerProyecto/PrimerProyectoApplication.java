package edu.unimagdalena.primerProyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.unimagdalena.primerProyecto.model.Propietario;
import edu.unimagdalena.primerProyecto.repository.PropietarioRepository;

@SpringBootApplication
public class PrimerProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerProyectoApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(PrimerProyectoApplication.class);
	@Bean
	public CommandLineRunner loadData(PropietarioRepository propietarioRep) {
		return (args)-> {
			Propietario propietario = new Propietario(null, "Andrés", "12345", null);
			propietarioRep.save(propietario);
			log.info("Propietario ingresado!");
			
		};
	}
}
