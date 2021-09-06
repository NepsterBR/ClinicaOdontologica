package br.com.letscode.clinicaodontologica.service;

import br.com.letscode.clinicaodontologica.entity.Consult;
import br.com.letscode.clinicaodontologica.entity.Patient;
import br.com.letscode.clinicaodontologica.repository.ConsultRepository;
import br.com.letscode.clinicaodontologica.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;


@AllArgsConstructor
@Service
public class SpecialConsultService {

    private final ConsultRepository consultRepository;
    private final PatientRepository patientRepository;

    public Mono<?> specialConsultByPatient(long patientId){
         var flux = Mono.create(mono -> {
            var patient = patientRepository.findPatientById(patientId);
            var consuts = consultRepository.findAllByPatient(patient);
            consuts.stream().sorted(Comparator.comparing(Consult::getDate).reversed());
            mono.success(consuts);
            Flux.just(mono);
        });
        return flux;

//        return Flux.mergeComparing(consultRepository.findAllByPatient(patient))
//
//        listaRanking.stream()
//                .sorted(Comparator.comparingInt(QuizClient::getScore).reversed());
//        return Flux.fromIterable(new ArrayList<Iterable<Consult>>((Collection<? extends Iterable<Consult>>)
//                consultRepository.findAllByPatient(patient)));
    }

    public Patient convertToOne(Patient patient) {
        return patient;
    }
}
