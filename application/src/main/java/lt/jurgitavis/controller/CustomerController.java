package lt.jurgitavis.controller;

import lt.jurgitavis.dto.CustomerDTO;
import lt.jurgitavis.model.Customer;
import lt.jurgitavis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/create")
    public Customer createCustomer(@RequestBody @Valid CustomerDTO input){
        return customerService.createCustomer(input);
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerService.getOne(id);
    }

    @GetMapping(value = "/all")
    public List<Customer> getListOfCustomers(){
        return customerService.findAll();
    }

    @PostMapping(value = "/update/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody @Valid CustomerDTO input){
        return customerService.updateCustomer(id, input);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }

    @DeleteMapping(value = "/delete/list")
    public void deleteCustomer(@RequestBody List<String> ids){
        customerService.deleteCustomers(ids);
    }


}
