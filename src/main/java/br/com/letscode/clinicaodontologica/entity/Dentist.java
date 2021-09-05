package br.com.letscode.clinicaodontologica.entity;

import br.com.letscode.clinicaodontologica.entity.complement.Adress;
import br.com.letscode.clinicaodontologica.entity.complement.Specialty;
import br.com.letscode.clinicaodontologica.entity.complement.Telephone;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Adress adress;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Telephone> telephones;
    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Specialty> specialties;

    public Dentist(String name, int age, Adress adress, List<Telephone> telephone, List<Specialty> specialties) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.telephones = telephone;
        this.specialties = specialties;
    }
}
