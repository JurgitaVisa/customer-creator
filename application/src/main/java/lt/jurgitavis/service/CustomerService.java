package lt.jurgitavis.service;

import lt.jurgitavis.dto.CustomerDTO;
import lt.jurgitavis.model.Customer;
import lt.jurgitavis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer createCustomer(CustomerDTO input) {
        Customer customer = new Customer(
                input.getName(),
                input.getSurname(),
                input.getBirthDate(),
                input.getPhoneNumber(),
                input.getEmail());

        return repository.createCustomer(customer);
    }

    public Customer getOne(String ID) {
        return repository.getOne(ID);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer updateCustomer(String ID, CustomerDTO input) {
        Customer customer = repository.getOne(ID);
        customer.setName(input.getName());
        customer.setSurname(input.getSurname());
        customer.setBirthDate(input.getBirthDate());
        customer.setPhoneNumber(input.getPhoneNumber());
        customer.setEmail(input.getEmail());

        return repository.updateCustomer(customer);
    }

    public void deleteCustomer(String ID) {
        repository.deleteCustomer(ID);
    }

    public void deleteCustomers(List<String> IDs) {
        IDs.forEach(id -> repository.deleteCustomer(id));
    }
}
