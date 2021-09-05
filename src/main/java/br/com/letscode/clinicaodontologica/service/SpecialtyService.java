package br.com.letscode.clinicaodontologica.service;

import br.com.letscode.clinicaodontologica.entity.Specialty;
import br.com.letscode.clinicaodontologica.repository.SpecialtyRepository;
import br.com.letscode.clinicaodontologica.request.SpecialtyRequest;
import br.com.letscode.clinicaodontologica.response.SpecialtyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public Mono<SpecialtyResponse> registerSpecialty(SpecialtyRequest specialtyRequest) {
        return Mono.create( mono -> {
            var specialty = specialtyRequest.convert();
            specialtyRepository.save(specialty);
            mono.success(new SpecialtyResponse(specialty));
        });
    }

    public Flux<Specialty> findAll(){
        return Flux.fromIterable(new ArrayList<>(specialtyRepository.findAll())).map(this::convertToOne);
    }

    public Specialty convertToOne(Specialty specialty) {
        return specialty;
    }
}
