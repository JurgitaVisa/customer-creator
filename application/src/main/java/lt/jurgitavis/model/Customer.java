package lt.jurgitavis.model;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Customer {
    String ID = UUID.randomUUID().toString();

    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private LocalDate birthDate;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;
}
