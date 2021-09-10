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
    private final AddressService addressService;

    public Mono<PatientResponse> registerPatient(PatientRequest patientRequest) {
        return Mono.create( mono -> {
            var patient = patientRequest.convert();
            patientRepository.save(patient);
            mono.success(convertToResponse(patient));
        });
    }

    public Flux<PatientResponse> findAll(){
        return Flux.fromIterable(new ArrayList<>(patientRepository.findAll())).map(this::convertToResponse);
    }

    public PatientResponse convertToResponse(Patient patient) {
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(patient.getName());
        patientResponse.setAge(patient.getAge());
        patientResponse.setTelephone(patient.getTelephone());
        addressService.getViaCep(patient.getAddress()).subscribe(patientResponse::setAddressResponse);
        patientResponse.getAddressResponse().setHouseNumber(patient.getAddress().getHouseNumber());
        patientResponse.getAddressResponse().setComplement(patient.getAddress().getComplement());

        return patientResponse;
    }
}
