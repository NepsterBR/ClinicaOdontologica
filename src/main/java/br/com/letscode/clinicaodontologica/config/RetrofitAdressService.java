package br.com.letscode.clinicaodontologica.config;

import br.com.letscode.clinicaodontologica.response.AddressResponse;
import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAdressService {

    @GET("{cep}/json")
    Mono<AddressResponse> getAddress(@Path("cep") String cep);
}
