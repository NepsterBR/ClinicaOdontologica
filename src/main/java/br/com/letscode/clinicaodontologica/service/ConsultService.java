package br.com.letscode.clinicaodontologica.service;

import br.com.letscode.clinicaodontologica.entity.Consult;
import br.com.letscode.clinicaodontologica.entity.Dentist;
import br.com.letscode.clinicaodontologica.entity.Patient;
import br.com.letscode.clinicaodontologica.entity.complement.Specialty;
import br.com.letscode.clinicaodontologica.repository.ConsultRepository;
import br.com.letscode.clinicaodontologica.repository.DentistRepository;
import br.com.letscode.clinicaodontologica.repository.PatientRepository;
import br.com.letscode.clinicaodontologica.repository.SpecialtyRepository;
import br.com.letscode.clinicaodontologica.request.ConsultRequest;
import br.com.letscode.clinicaodontologica.response.ConsultResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ConsultService {

    private final ConsultRepository consultRepository;
    private final DentistRepository dentistRepository;
    private final PatientRepository patientRepository;
    private final SpecialtyRepository specialtyRepository;

    public Mono<ConsultResponse> registerConsult(ConsultRequest consultRequest) {
        return Mono.create(mono -> {
            var consult = convert(consultRequest);
            consultRepository.save(consult);
            mono.success(new ConsultResponse(consult));
        });
    }

    public Flux<Consult> findAll() {
        return Flux.fromIterable(new ArrayList<>(consultRepository.findAll())).map(this::convertToOne);
    }

    public Consult convertToOne(Consult consult) {
        return consult;
    }


    public Consult convert(ConsultRequest consultRequest) {
        Dentist dentist = dentistRepository.findDentistById(consultRequest.getDentistId());
        Patient patient = patientRepository.findPatientById(consultRequest.getPatientId());
        Specialty speciality = specialtyRepository.findSpecialityById(consultRequest.getSpecialityId());

        return new Consult(dentist, patient, consultRequest.getDate(), consultRequest.getProcedure(), speciality);
    }



}
