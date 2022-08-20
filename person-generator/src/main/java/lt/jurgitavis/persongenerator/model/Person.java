package lt.jurgitavis.persongenerator.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
	private String name;
	private String surname;
	private LocalDate birthdate;
	private String phoneNumber;
	private String email;
}
