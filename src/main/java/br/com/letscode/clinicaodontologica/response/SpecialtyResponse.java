package br.com.letscode.clinicaodontologica.response;

import br.com.letscode.clinicaodontologica.entity.Specialty;
import lombok.Data;

@Data
public class SpecialtyResponse {

    private String specialty;

    public SpecialtyResponse(Specialty specialty){
        this.specialty = specialty.getSpeciality();
    }
}
