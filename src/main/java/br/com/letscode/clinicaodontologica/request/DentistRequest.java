package br.com.letscode.clinicaodontologica.request;

import br.com.letscode.clinicaodontologica.entity.Dentist;
import br.com.letscode.clinicaodontologica.entity.complement.Address;
import br.com.letscode.clinicaodontologica.entity.complement.Specialty;
import br.com.letscode.clinicaodontologica.entity.complement.Telephone;
import lombok.Data;

import java.util.List;

@Data
public class DentistRequest {

    private String name;
    private int age;
    private Address address;
    private List<Telephone> telephone;
    private List<Specialty> specialties;

    public Dentist convert() {
        return new Dentist(name, age, address, telephone, specialties);
    }
}
