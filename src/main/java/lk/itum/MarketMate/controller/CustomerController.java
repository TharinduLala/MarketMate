package lk.itum.MarketMate.controller;

import lk.itum.MarketMate.dto.CustomerDto;
import lk.itum.MarketMate.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public String getAllCustomer() {
        return "Get All Customer";
    }

    @GetMapping(path = "/{customerId}")
    public String searchCustomer(@PathVariable String customerId) {
        return "Customer Search";
    }

    @PostMapping
    public String saveCustomer(@ModelAttribute CustomerDto customerDto) {
        return "Customer Saves";
    }

    @PutMapping
    public String updateCustomer(@RequestBody CustomerDto customerDto) {
        return "Customer Updated";
    }


    @DeleteMapping(params = {"id"})
    public String deleteCustomer(@RequestParam String customerId) {
        return "Customer Deleted";
    }


}
