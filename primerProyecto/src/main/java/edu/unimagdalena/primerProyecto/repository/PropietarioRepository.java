package edu.unimagdalena.primerProyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.primerProyecto.model.Propietario;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {

}
