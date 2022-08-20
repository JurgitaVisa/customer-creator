package lt.jurgitavis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    @NotEmpty(message = "Vardas privalomas!")
    @Size(min = 2, max = 70)
    @Pattern(regexp = "^\\p{L}+(?: \\p{L}+)*$")
    private String name;

    @NotEmpty(message = "Pavardė privaloma!")
    @Size(min = 2, max = 70)
    @Pattern(regexp = "^\\p{L}+(?: \\p{L}+)*$")
    private String surname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotEmpty(message = "Gimimo data privaloma!")
    private LocalDate birthDate;

    @Pattern(regexp = "^\\+(?!\\s*$)[0-9\\s]{5,20}$|")
    @NotEmpty(message = "Telefonas privalomas!")
    private String phoneNumber;

    @Email
    @NotEmpty(message = "El. paštas privalomas!")
    private String email;
}
