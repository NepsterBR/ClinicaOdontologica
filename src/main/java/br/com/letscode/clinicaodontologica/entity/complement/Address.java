package br.com.letscode.clinicaodontologica.entity.complement;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String houseNumber;
    @SerializedName("cep")
    private String zipCode;
    private String complement;

}



