package br.com.letscode.clinicaodontologica.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AddressResponse {
    private String houseNumber;
    private String complement;
    @SerializedName("cep")
    private String zipCode;
    @SerializedName("logradouro")
    private String street;
    @SerializedName("bairro")
    private String district;
    @SerializedName("localidade")
    private String city;
    @SerializedName("uf")
    private String state;
}
