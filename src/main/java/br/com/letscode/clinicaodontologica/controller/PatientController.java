package br.com.letscode.clinicaodontologica.controller;

import br.com.letscode.clinicaodontologica.request.PatientRequest;
import br.com.letscode.clinicaodontologica.response.PatientResponse;
import br.com.letscode.clinicaodontologica.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping("register")
    public Mono<PatientResponse> registerPatient(@RequestBody PatientRequest patientRequest) {
        return patientService.registerPatient(patientRequest);
    }

    @GetMapping("findall")
    public Flux<PatientResponse> findAll(){
        return patientService.findAll();
    }

}
