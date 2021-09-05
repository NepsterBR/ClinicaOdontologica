package br.com.letscode.clinicaodontologica.entity;

import br.com.letscode.clinicaodontologica.entity.complement.Adress;
import br.com.letscode.clinicaodontologica.entity.complement.Telephone;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Adress adress;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Telephone> telephone;


    public Patient(String name, int age, Adress adress, List<Telephone> telephone) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.telephone = telephone;
    }
}
