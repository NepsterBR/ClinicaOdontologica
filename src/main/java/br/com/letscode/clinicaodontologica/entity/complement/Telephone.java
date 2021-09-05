package br.com.letscode.clinicaodontologica.entity.complement;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Telephone {

    @Id
    private String telephone1;
    private String telephone2;
}
