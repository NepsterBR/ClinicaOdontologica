package br.com.letscode.clinicaodontologica.response;

import br.com.letscode.clinicaodontologica.entity.Consult;
import br.com.letscode.clinicaodontologica.entity.Dentist;
import br.com.letscode.clinicaodontologica.entity.Patient;
import br.com.letscode.clinicaodontologica.entity.complement.Specialty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsultResponse {

    private Dentist dentist;
    private Patient patient;
    private LocalDate date;
    private String procedure;
    private Specialty specialty;

    public ConsultResponse(Consult consult) {
        this.dentist = consult.getDentist();
        this.patient = consult.getPatient();
        this.date = consult.getDate();
        this.procedure = consult.getProcedure();
        this.specialty = consult.getSpecialty();
    }
}
