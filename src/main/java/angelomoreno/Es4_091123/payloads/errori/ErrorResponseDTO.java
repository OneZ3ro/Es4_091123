package angelomoreno.Es4_091123.payloads.errori;

import java.util.Date;

public record ErrorResponseDTO(String message, Date timeOfError) {
}
