package com.ltc.bankapp.service;

import com.ltc.bankapp.dto.customer.CustomerRequestDto;
import com.ltc.bankapp.dto.customer.CustomerResponseDto;
import com.ltc.bankapp.exception.CustomerNotFoundException;
import com.ltc.bankapp.mapper.CustomerMapper;
import com.ltc.bankapp.model.Customer;
import com.ltc.bankapp.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    public CustomerResponseDto create(CustomerRequestDto customerRequestDto){

        Customer customer = customerMapper.toEntity(customerRequestDto);
        customerRepo.save(customer);
        return customerMapper.toDto(customer);

    }

    public Page<CustomerResponseDto> getAll(Pageable pageable){

        return customerRepo.findAll(pageable)
                .map(customerMapper::toDto);    // Convert each element to dto
    }

    public CustomerResponseDto findById(Long id){

        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found" + id));

        return customerMapper.toDto(customer);
    }

    public CustomerResponseDto update(Long id, CustomerRequestDto customerRequestDto){

        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found" + id));

        customerMapper.updateEntity(customerRequestDto, customer);
        customerRepo.save(customer);
        return customerMapper.toDto(customer);

    }

    public void delete(Long id){

        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found" + id));

                customerRepo.delete(customer);
    }
}
