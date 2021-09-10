package br.com.letscode.clinicaodontologica.service;

import br.com.letscode.clinicaodontologica.config.RetrofitAdressService;
import br.com.letscode.clinicaodontologica.config.RetrofitInitializer;
import br.com.letscode.clinicaodontologica.entity.complement.Address;
import br.com.letscode.clinicaodontologica.response.AddressResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import retrofit2.Retrofit;

@Service
public class AddressService {

    private final Retrofit retrofit;

    public AddressService() {
        this.retrofit = RetrofitInitializer.getRetrofit();
    }

    public Mono<AddressResponse> getViaCep (Address address){
        return this.retrofit.create(RetrofitAdressService.class).getAddress(address.getZipCode());
    }


}

