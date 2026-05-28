package com.museo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// CAMBIO: Clase renombrada de TripsAnApplication a MuseoCarrosApplication
// CAMBIO: Package cambiado de com.trips a com.museo
@SpringBootApplication
public class MuseoCarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseoCarrosApplication.class, args);
	}

}
