package br.com.letscode.clinicaodontologica.response;

import br.com.letscode.clinicaodontologica.entity.complement.Adress;
import br.com.letscode.clinicaodontologica.entity.Dentist;
import br.com.letscode.clinicaodontologica.entity.complement.Specialty;
import br.com.letscode.clinicaodontologica.entity.complement.Telephone;
import lombok.Data;

import java.util.List;

@Data
public class DentistResponse {

    private String name;
    private int age;
    private Adress adress;
    private List<Telephone> telephone;
    private List<Specialty> specialties;

    public DentistResponse(Dentist dentist){
        this.name = dentist.getName();
        this.age = dentist.getAge();
        this.adress = dentist.getAdress();
        this.telephone = dentist.getTelephones();
        this.specialties = dentist.getSpecialties();
    }
}
