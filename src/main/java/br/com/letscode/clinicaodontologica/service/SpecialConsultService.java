package br.com.letscode.clinicaodontologica.service;

import br.com.letscode.clinicaodontologica.entity.Consult;
import br.com.letscode.clinicaodontologica.repository.ConsultRepository;
import br.com.letscode.clinicaodontologica.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;


@AllArgsConstructor
@Service
public class SpecialConsultService {

    private final ConsultRepository consultRepository;
    private final PatientRepository patientRepository;

    public Mono<?> specialConsultByPatient(long patientId){
        return Mono.create(mono -> {
            var patient = patientRepository.findPatientById(patientId);
            var consuts = consultRepository.findAllByPatient(patient);
            var sorted = consuts.stream().sorted(Comparator.comparing(Consult::getDate).reversed());
            mono.success(sorted);
            Flux.just(mono);
        });

    }


}