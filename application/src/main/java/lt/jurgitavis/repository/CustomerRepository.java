package lt.jurgitavis.repository;

import lt.jurgitavis.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {

    Customer createCustomer(Customer customer);
    void addListOfCustomers(List<Customer> customers);
    Customer getOne(String ID);
    List<Customer> findAll();
    Customer updateCustomer(Customer customer);
    void deleteCustomer(String ID);
}
