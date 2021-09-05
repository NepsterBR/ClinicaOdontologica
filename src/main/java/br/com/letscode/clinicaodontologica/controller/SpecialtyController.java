package br.com.letscode.clinicaodontologica.controller;

import br.com.letscode.clinicaodontologica.entity.Specialty;
import br.com.letscode.clinicaodontologica.request.SpecialtyRequest;
import br.com.letscode.clinicaodontologica.response.SpecialtyResponse;
import br.com.letscode.clinicaodontologica.service.SpecialtyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @PostMapping("register")
    public Mono<SpecialtyResponse> registerSpecialty(@RequestBody SpecialtyRequest specialtyRequest) {
        return specialtyService.registerSpecialty(specialtyRequest);
    }

    @GetMapping("findall")
    public Flux<Specialty> findAll(){
        return specialtyService.findAll();
    }

}
