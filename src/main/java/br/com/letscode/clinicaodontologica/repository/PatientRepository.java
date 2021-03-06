package br.com.letscode.clinicaodontologica.repository;

import br.com.letscode.clinicaodontologica.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findPatientById(long patientId);
}
