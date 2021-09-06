package br.com.letscode.clinicaodontologica.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsultRequest {

    private long dentistId;
    private long patientId;
    private long specialityId;
    private LocalDate date;
    private String procedure;


}
