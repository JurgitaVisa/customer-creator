package lt.jurgitavis.service;

import lt.jurgitavis.dto.CustomerDTO;
import lt.jurgitavis.model.Customer;
import lt.jurgitavis.persongenerator.model.Person;
import lt.jurgitavis.persongenerator.service.RandomPersonService;
import lt.jurgitavis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private RandomPersonService randomPersonService;
    @Autowired
    private CustomerRepository repository;

    public Customer createCustomer(CustomerDTO input) {
        Customer customer = new Customer(
                input.getName(),
                input.getSurname(),
                input.getBirthdate(),
                input.getPhoneNumber(),
                input.getEmail());

        return repository.createCustomer(customer);
    }

    public List<Customer> generateNewCustomers(int count) {
        List<Customer> customers = randomPersonService
                .getListOfRandomPersons(count)
                .stream()
                .map(person ->
                        new Customer(
                                person.getName(),
                                person.getSurname(),
                                person.getBirthdate(),
                                person.getPhoneNumber(),
                                person.getEmail()))
                .collect(Collectors.toList());

        return repository.addListOfCustomers(customers);
    }

    public CustomerDTO generateTemporaryCustomerData() {
        Person random = randomPersonService.getRandomPerson();
        return new CustomerDTO(
                random.getName(),
                random.getSurname(),
                random.getBirthdate(),
                random.getPhoneNumber(),
                random.getEmail());
    }

    public Customer getOne(Long ID) {
        return repository.getOne(ID);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer updateCustomer(Long ID, CustomerDTO input) {
        Customer customer = repository.getOne(ID);
        customer.setName(input.getName());
        customer.setSurname(input.getSurname());
        customer.setBirthdate(input.getBirthdate());
        customer.setPhoneNumber(input.getPhoneNumber());
        customer.setEmail(input.getEmail());

        return repository.updateCustomer(customer);
    }

    public void deleteCustomer(Long ID) {
        repository.deleteCustomer(ID);
    }

    public void deleteCustomers(List<Long> IDs) {
        IDs.forEach(id -> repository.deleteCustomer(id));
    }


}
