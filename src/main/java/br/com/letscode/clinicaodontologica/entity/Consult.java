package br.com.letscode.clinicaodontologica.entity;

import br.com.letscode.clinicaodontologica.entity.complement.Specialty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Consult {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Dentist dentist;
    @OneToOne
    private Patient patient;
    private LocalDate date;
    private String procedure;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Specialty specialty;

    public Consult(Dentist dentist, Patient patient, LocalDate date, String procedure,Specialty speciality) {
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
        this.procedure = procedure;
        this.specialty = speciality;
    }

}

