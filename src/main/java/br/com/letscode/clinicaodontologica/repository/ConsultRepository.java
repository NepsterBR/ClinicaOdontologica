package br.com.letscode.clinicaodontologica.repository;

import br.com.letscode.clinicaodontologica.entity.Consult;
import br.com.letscode.clinicaodontologica.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


import java.util.List;


@Repository
public interface ConsultRepository extends JpaRepository<Consult, Integer> {

    List<Consult> findAllByPatient(Patient patient);


}
