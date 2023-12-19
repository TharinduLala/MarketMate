package lk.itum.MarketMate.controller;

import lk.itum.MarketMate.dto.CustomerDto;
import lk.itum.MarketMate.service.CustomerService;
import lk.itum.MarketMate.util.ResponseUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomer() {
        return new ResponseUtil(200,"OK",customerService.getAllCustomers());
    }

    @GetMapping(path = "/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String customerId) {
        return new ResponseUtil(200,"OK",customerService.searchCustomer(customerId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        return new ResponseUtil(200,"Saved Successfully",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);
        return new ResponseUtil(200,"Updated Successfully..",null);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseUtil(200,"Deleted Successfully",null);
    }


}
