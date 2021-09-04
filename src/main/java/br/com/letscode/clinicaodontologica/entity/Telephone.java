package br.com.letscode.clinicaodontologica.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Data
public class Telephone {

    @Id
    @JoinColumn(name = "Patient", referencedColumnName = "telephone")
    private String telephone;
}
