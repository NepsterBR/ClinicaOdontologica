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

    public Mono<DentistResponse> registerDentist(DentistRequest dentistRequest) {
        return Mono.create( mono -> {
            var dentist = dentistRequest.convert();
            dentistRepository.save(dentist);
            mono.success(new DentistResponse(dentist));
        });
    }

    public Flux<Dentist> findAll(){
        return Flux.fromIterable(new ArrayList<>(dentistRepository.findAll())).map(this::convertToOne);
    }

    public Dentist convertToOne(Dentist dentist) {
        return dentist;
    }
}
