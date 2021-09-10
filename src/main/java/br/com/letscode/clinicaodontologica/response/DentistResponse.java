package br.com.letscode.clinicaodontologica.response;

import br.com.letscode.clinicaodontologica.entity.complement.Specialty;
import br.com.letscode.clinicaodontologica.entity.complement.Telephone;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.List;

@Data
public class DentistResponse {

    private String name;
    private int age;
    @OneToOne(cascade = CascadeType.PERSIST)
    private AddressResponse addressResponse;
    private List<Telephone> telephone;
    private List<Specialty> specialties;

}
