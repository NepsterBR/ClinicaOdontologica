package br.com.letscode.clinicaodontologica.service;

import br.com.letscode.clinicaodontologica.entity.Dentist;
import br.com.letscode.clinicaodontologica.repository.DentistRepository;
import br.com.letscode.clinicaodontologica.request.DentistRequest;
import br.com.letscode.clinicaodontologica.response.DentistResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class DentistService {

    private final DentistRepository dentistRepository;
    private final AddressService addressService;

    public Mono<DentistResponse> registerDentist(DentistRequest dentistRequest) {
        return Mono.create(mono -> {
            var dentist = dentistRequest.convert();
            dentistRepository.save(dentist);
            mono.success(convertToResponse(dentist));
        });
    }

    public Flux<DentistResponse> findAll() {
        return Flux.fromIterable(new ArrayList<>(dentistRepository.findAll())).map(this::convertToResponse);
    }

    public DentistResponse convertToResponse(Dentist dentist) {
        DentistResponse dentistResponse = new DentistResponse();
        dentistResponse.setName(dentist.getName());
        dentistResponse.setAge(dentist.getAge());
        dentistResponse.setTelephone(dentist.getTelephones());
        dentistResponse.setSpecialties(dentist.getSpecialties());
        addressService.getViaCep(dentist.getAddress()).subscribe(dentistResponse::setAddressResponse);
        dentistResponse.getAddressResponse().setHouseNumber(dentist.getAddress().getHouseNumber());
        dentistResponse.getAddressResponse().setComplement(dentist.getAddress().getComplement());
        return dentistResponse;
    }
}
