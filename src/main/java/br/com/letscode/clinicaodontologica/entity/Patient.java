package br.com.letscode.clinicaodontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String zipCode;
    private String number;
    private String complement;
    @OneToMany
    private List<Telephone> telephone;


    public Patient(String name, int age, String zipCode, String number, String complement, List<Telephone> telephone) {
        this.name = name;
        this.age = age;
        this.zipCode = zipCode;
        this.number = number;
        this.complement = complement;
        this.telephone = telephone;
    }
}
