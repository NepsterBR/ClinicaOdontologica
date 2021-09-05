package br.com.letscode.clinicaodontologica.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Dentist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    @Transient
    private List<String> telephones;
    @Transient
    private List<Specialty> specialties;
}
