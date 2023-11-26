package lk.itum.MarketMate.service;

import lk.itum.MarketMate.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto dto);

    void deleteCustomer(String id);

    void updateCustomer(CustomerDto dto);

    CustomerDto searchCustomer(String id);

    List<CustomerDto> getAllCustomers();
}
