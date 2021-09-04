package br.com.letscode.clinicaodontologica.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Adress {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String cep;
    private String numero;
    private String complemento;

}
