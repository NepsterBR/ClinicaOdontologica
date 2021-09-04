package br.com.letscode.clinicaodontologica.repository;

import br.com.letscode.clinicaodontologica.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Stream<Patient> findByNameIsNotNull();
}
