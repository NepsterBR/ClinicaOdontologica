package br.com.letscode.clinicaodontologica.repository;

import br.com.letscode.clinicaodontologica.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    Dentist findDentistById (long id);
}
