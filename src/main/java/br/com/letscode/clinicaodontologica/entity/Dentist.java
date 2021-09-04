package br.com.letscode.clinicaodontologica.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Dentist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int idade;
    @OneToOne
    private Adress adress;
    @OneToMany
    private List<Telephone> telephones;
    @OneToMany
    private List<Specialty> specialties;
}
