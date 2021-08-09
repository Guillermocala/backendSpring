package edu.unimagdalena.primerProyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unimagdalena.primerProyecto.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}
