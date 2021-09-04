package br.com.letscode.clinicaodontologica.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Telephone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String telephone;
}
