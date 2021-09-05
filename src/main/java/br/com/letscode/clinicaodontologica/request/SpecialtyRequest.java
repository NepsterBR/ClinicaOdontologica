package br.com.letscode.clinicaodontologica.request;

import br.com.letscode.clinicaodontologica.entity.Specialty;
import lombok.Data;

@Data
public class SpecialtyRequest {

    private String specialty;

    public Specialty convert(){
        return new Specialty(specialty);
    }
}
