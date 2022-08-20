package lt.jurgitavis.init;

import lt.jurgitavis.model.Customer;
import lt.jurgitavis.persongenerator.service.RandomPersonService;
import lt.jurgitavis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomersInit implements CommandLineRunner {
    @Autowired
    private RandomPersonService randomPersonService;
    @Autowired
    private CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        List<Customer> customers = randomPersonService
                .getListOfRandomPersons(100)
                .stream()
                .map(person ->
                        new Customer(
                                person.getName(),
                                person.getSurname(),
                                person.getBirthdate(),
                                person.getPhoneNumber(),
                                person.getEmail()))
                .collect(Collectors.toList());

        repository.addListOfCustomers(customers);
    }
}
