package lt.jurgitavis.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    @Size(min = 2, max = 70)
    @Pattern(regexp = "^[\\p{Lu}\\p{Lt}]\\p{Ll}*(?:\\h+[\\p{Lu}\\p{Lt}]\\p{Ll}*)*$", message="Please provide a valid name")
    @NotEmpty(message = "Name is required!")
    private String name;


    @Size(min = 2, max = 70)
    @Pattern(regexp = "^[\\p{Lu}\\p{Lt}]\\p{Ll}*(?:\\h+[\\p{Lu}\\p{Lt}]\\p{Ll}*)*$", message="Please provide a valid surname")
    @NotEmpty(message = "Surname is required!")
    private String surname;

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthdate is required!")
    private LocalDate birthdate;

    @Pattern(regexp = "^\\+(?!\\s*$)[0-9\\s]{11,20}$|", message="Please provide a valid phone number")
    @NotEmpty(message = "Phone number is required!")
    private String phoneNumber;

    @Email
    @NotEmpty(message = "Email is required!")
    private String email;
}
