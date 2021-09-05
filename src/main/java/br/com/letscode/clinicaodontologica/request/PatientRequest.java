package br.com.letscode.clinicaodontologica.request;

import br.com.letscode.clinicaodontologica.entity.Adress;
import br.com.letscode.clinicaodontologica.entity.Patient;
import br.com.letscode.clinicaodontologica.entity.Telephone;
import lombok.Data;

import java.util.List;

@Data
public class PatientRequest {

    private String name;
    private int age;
    private Adress adress;
    private List<Telephone> telephone;

    public Patient convert() {
        return new Patient(name, age, adress, telephone);
    }
}
