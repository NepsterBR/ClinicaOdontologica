package br.com.letscode.clinicaodontologica.entity;

import br.com.letscode.clinicaodontologica.entity.complement.Address;
import br.com.letscode.clinicaodontologica.entity.complement.Telephone;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToOne (cascade = CascadeType.PERSIST)
    private Address address;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Telephone> telephone;


    public Patient(String name, int age, Address address, List<Telephone> telephone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.telephone = telephone;
    }
}
