package br.com.letscode.clinicaodontologica.controller;

import br.com.letscode.clinicaodontologica.entity.Consult;
import br.com.letscode.clinicaodontologica.request.ConsultRequest;
import br.com.letscode.clinicaodontologica.response.ConsultResponse;
import br.com.letscode.clinicaodontologica.service.ConsultService;
import br.com.letscode.clinicaodontologica.service.SpecialConsultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/consult")
public class ConsultController {

    private final ConsultService consultService;
    private final SpecialConsultService specialConsultService;

    @PostMapping("register")
    public Mono<ConsultResponse> registerConsult(@RequestBody ConsultRequest consultRequest) {
        return consultService.registerConsult(consultRequest);
    }

    @GetMapping("/findall")
    public Flux<Consult> findAll() {
        return consultService.findAll();
    }

    @GetMapping("/special")
    public Mono<?> specialConsult(@RequestParam long patientId) {
    return specialConsultService.specialConsultByPatient(patientId);
    }

}
