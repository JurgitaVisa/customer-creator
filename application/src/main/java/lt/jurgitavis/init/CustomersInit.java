package lt.jurgitavis.init;

import lt.jurgitavis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomersInit implements CommandLineRunner {
    @Autowired
    private CustomerService service;

    @Override
    public void run(String... args) throws Exception {
       service.generateNewCustomers(50);
    }
}
