package lk.itum.MarketMate.service.impl;

import jakarta.transaction.Transactional;
import lk.itum.MarketMate.dto.CustomerDto;
import lk.itum.MarketMate.entity.Customer;
import lk.itum.MarketMate.repo.CustomerRepo;
import lk.itum.MarketMate.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper mapper) {
        this.customerRepo = customerRepo;
        this.mapper = mapper;
    }


    @Override
    public void saveCustomer(CustomerDto dto) {
        if (!customerRepo.existsById(dto.getCustomerId())) {
            customerRepo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("This Customer ID is Already Exists.");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please Check Customer Id. No Such Customer to Delete.");
        }
    }

    @Override
    public void updateCustomer(CustomerDto dto) {
        if (!customerRepo.existsById(dto.getCustomerId())) {
            customerRepo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("Please Check Customer Id. No Such Customer to Update.");
        }
    }

    @Override
    public CustomerDto searchCustomer(String id) {
        if (customerRepo.existsById(id)) {
            return mapper.map(customerRepo.findById(id).get(), CustomerDto.class);
        } else {
            throw new RuntimeException("No Such Customer for " + id + "..!");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return mapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDto>>() {
        }.getType());
    }
}
