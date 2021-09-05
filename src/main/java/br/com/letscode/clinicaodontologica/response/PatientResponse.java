package br.com.letscode.clinicaodontologica.response;

import br.com.letscode.clinicaodontologica.entity.Adress;
import br.com.letscode.clinicaodontologica.entity.Patient;
import br.com.letscode.clinicaodontologica.entity.Telephone;
import lombok.Data;

import java.util.List;

@Data
public class PatientResponse {

    private String name;
    private int age;
    private Adress adress;
    private List<Telephone> telephone;

    public PatientResponse(Patient patient){
        this.name = patient.getName();
        this.age = patient.getAge();
        this.adress = patient.getAdress();
        this.telephone = patient.getTelephone();
    }
}
