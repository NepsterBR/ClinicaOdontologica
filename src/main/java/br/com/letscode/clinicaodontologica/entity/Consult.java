package br.com.letscode.clinicaodontologica.entity;

import br.com.letscode.clinicaodontologica.entity.complement.Specialty;
import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;

@Entity
@Data
public class Consult {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Dentist dentist;
    @OneToOne
    private Patient patient;
    private DateFormat date;
    private String procedure;
    @Transient
    private Specialty specialty;
}
