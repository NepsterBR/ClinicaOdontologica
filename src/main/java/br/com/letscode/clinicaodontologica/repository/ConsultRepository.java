package br.com.letscode.clinicaodontologica.repository;

import br.com.letscode.clinicaodontologica.entity.Consult;
import br.com.letscode.clinicaodontologica.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Integer> {

}
