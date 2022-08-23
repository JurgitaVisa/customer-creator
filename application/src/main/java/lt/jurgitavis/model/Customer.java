package lt.jurgitavis.model;

import lombok.*;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private static final AtomicLong nextId = new AtomicLong(1);

    private Long ID = nextId.getAndIncrement();
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private LocalDate birthdate;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;
}
