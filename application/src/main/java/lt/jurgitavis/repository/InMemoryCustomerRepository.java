package lt.jurgitavis.repository;

import lt.jurgitavis.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    private Map<Long, Customer> customersInDB = new HashMap<>();

    @Override
    public Customer createCustomer(Customer customer) {
        customersInDB.putIfAbsent(customer.getID(), customer);
        return customer;
    }

    @Override
    public List<Customer> addListOfCustomers(List<Customer> customers) {
        customers.forEach(customer -> customersInDB.putIfAbsent(customer.getID(), customer));
        return customers;
    }

    @Override
    public Customer getOne(Long ID) {
        return customersInDB.get(ID);
    }

    @Override
    public List<Customer> findAll() {
        return customersInDB.values().stream().collect(Collectors.toList());
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customersInDB.put(customer.getID(), customer);
        return customer;
    }

    @Override
    public void deleteCustomer(Long ID) {
        customersInDB.remove(ID);
    }

}
