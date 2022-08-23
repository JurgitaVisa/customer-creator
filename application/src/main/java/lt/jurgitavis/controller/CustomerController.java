package lt.jurgitavis.controller;

import lt.jurgitavis.dto.CustomerDTO;
import lt.jurgitavis.model.Customer;
import lt.jurgitavis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(value = "http://localhost:4200")
@Validated
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/create")
    public Customer createCustomer(@RequestBody @Valid CustomerDTO input){
        return customerService.createCustomer(input);
    }

    @GetMapping(value = "/generate/{count}")
    public List<Customer> generateNewCustomers(@PathVariable("count") @Min(1) @Max(value = 100, message = "Let's not go wild - from 1 up to a 100 please :)") int count){
        return customerService.generateNewCustomers(count);
    }

    @GetMapping(value = "/temporary")
    public CustomerDTO generateTemporaryCustomerData(){
        return customerService.generateTemporaryCustomerData();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getOne(id);
    }

    @GetMapping(value = "/all")
    public List<Customer> getListOfCustomers(){
        return customerService.findAll();
    }

    @PostMapping(value = "/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerDTO input){
        return customerService.updateCustomer(id, input);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

    @DeleteMapping(value = "/delete/list")
    public void deleteCustomer(@RequestBody List<Long> ids){
        customerService.deleteCustomers(ids);
    }


}
