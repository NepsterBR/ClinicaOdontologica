package br.com.letscode.clinicaodontologica.service;

import br.com.letscode.clinicaodontologica.entity.Patient;
import br.com.letscode.clinicaodontologica.repository.PatientRepository;
import br.com.letscode.clinicaodontologica.request.PatientRequest;
import br.com.letscode.clinicaodontologica.response.PatientResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public Mono<PatientResponse> registerPatient(PatientRequest patientRequest) {
        return Mono.create( mono -> {
            var patient = patientRequest.convert();
            patientRepository.save(patient);
            mono.success(new PatientResponse(patient));
        });
    }

    public Flux<PatientResponse> findAll(){
        return Flux.fromIterable(new ArrayList<>(patientRepository.findAll())).map(this::convertToOne);
    }

    public PatientResponse convertToOne(Patient patient) {
        return new PatientResponse(patient);
    }
}
