package br.com.letscode.clinicaodontologica.response;

import br.com.letscode.clinicaodontologica.entity.Patient;
import br.com.letscode.clinicaodontologica.entity.Telephone;
import lombok.Data;

import java.util.List;

@Data
public class PatientResponse {

    private String name;
    private int age;
    private String zipCode;
    private String number;
    private String complement;
    private List<Telephone> telephone;

    public PatientResponse(Patient patient){
        this.name = patient.getName();
        this.age = patient.getAge();
        this.zipCode = patient.getZipCode();
        this.number = patient.getNumber();
        this.complement = patient.getComplement();
        this.telephone = patient.getTelephone();
    }
}
