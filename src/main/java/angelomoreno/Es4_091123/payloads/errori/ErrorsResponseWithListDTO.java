package angelomoreno.Es4_091123.payloads.errori;

import java.util.Date;
import java.util.List;

public record ErrorsResponseWithListDTO(String message, Date timeOfError, List<String> errorList) {
}
