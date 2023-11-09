package angelomoreno.Es4_091123.payloads.aurori;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record NewAutoreDTO (
        @NotEmpty(message = "Il nome è un campo obbligatorio")
        @Size(min = 3, max = 20, message = "Il nome deve essere compreso tra i 3 e i 20 caratteri")
        String nome,

        @NotEmpty(message = "Il cognome è un campo obbligatorio")
        @Size(min = 5, max = 30, message = "Il nome deve essere compreso tra i 5 e i 30 caratteri")
        String cognome,

        @NotEmpty(message = "L'email è un campo obbligatorio")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
        String email,

        @NotEmpty(message = "La data di nascita è un campo obbligatorio")
        LocalDate dataDiNascita
){}