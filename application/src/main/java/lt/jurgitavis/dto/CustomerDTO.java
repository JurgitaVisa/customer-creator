package lt.jurgitavis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    @Size(min = 2, max = 70)
    @Pattern(regexp = "^[\\p{Lu}\\p{Lt}]\\p{Ll}*(?:\\h+[\\p{Lu}\\p{Lt}]\\p{Ll}*)*$", message="Please provide a valid name")
    @NotEmpty(message = "Vardas privalomas!")
    private String name;


    @Size(min = 2, max = 70)
    @Pattern(regexp = "^[\\p{Lu}\\p{Lt}]\\p{Ll}*(?:\\h+[\\p{Lu}\\p{Lt}]\\p{Ll}*)*$", message="Please provide a valid surname")
    @NotEmpty(message = "Pavardė privaloma!")
    private String surname;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Gimimo data privaloma!")
    private LocalDate birthDate;

    @Pattern(regexp = "^\\+(?!\\s*$)[0-9\\s]{11,20}$|", message="Please provide a valid phone number")
    @NotEmpty(message = "Telefonas privalomas!")
    private String phoneNumber;

    @Email
    @NotEmpty(message = "El. paštas privalomas!")
    private String email;
}
