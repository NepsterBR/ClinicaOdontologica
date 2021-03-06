package br.com.letscode.clinicaodontologica.controller;

import br.com.letscode.clinicaodontologica.entity.Dentist;
import br.com.letscode.clinicaodontologica.request.DentistRequest;
import br.com.letscode.clinicaodontologica.response.DentistResponse;
import br.com.letscode.clinicaodontologica.service.DentistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    @PostMapping("register")
    public Mono<DentistResponse> registerDentist(@RequestBody DentistRequest dentistRequest) {
        return dentistService.registerDentist(dentistRequest);
    }

    @GetMapping("findall")
    public Flux<DentistResponse> findAll(){
        return dentistService.findAll();
    }

}
