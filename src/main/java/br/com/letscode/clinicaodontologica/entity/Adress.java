package br.com.letscode.clinicaodontologica.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Adress {

    @Id
    private String zipCode;
    private String number;
    private String complement;
}
