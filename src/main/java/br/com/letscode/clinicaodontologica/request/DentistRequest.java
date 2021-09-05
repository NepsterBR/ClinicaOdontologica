package br.com.letscode.clinicaodontologica.request;

import br.com.letscode.clinicaodontologica.entity.*;
import br.com.letscode.clinicaodontologica.entity.complement.Adress;
import br.com.letscode.clinicaodontologica.entity.complement.Specialty;
import br.com.letscode.clinicaodontologica.entity.complement.Telephone;
import lombok.Data;

import java.util.List;

@Data
public class DentistRequest {

    private String name;
    private int age;
    private Adress adress;
    private List<Telephone> telephone;
    private List<Specialty> specialties;

    public Dentist convert() {
        return new Dentist(name, age, adress, telephone, specialties);
    }
}
