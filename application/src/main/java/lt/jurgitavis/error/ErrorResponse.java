package lt.jurgitavis.error;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private Map<String, String > details;

    public ErrorResponse(String message, Map<String, String> details) {
        super();
        this.message = message;
        this.details = details;
    }
}
