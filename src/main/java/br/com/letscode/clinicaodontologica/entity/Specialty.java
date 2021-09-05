package br.com.letscode.clinicaodontologica.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Specialty {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String speciality;

    public Specialty(String specialty) {
        this.speciality = specialty;
    }
}
