package com.ltc.bankapp.mapper;

import com.ltc.bankapp.dto.customer.CustomerRequestDto;
import com.ltc.bankapp.dto.customer.CustomerResponseDto;
import com.ltc.bankapp.model.Customer;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequestDto dto){

        if (dto == null){
            return null;
        }

        Customer customer = new Customer();

        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());

        return customer;
    }

    public CustomerResponseDto toDto(Customer customer){

        if(customer == null){
            return null;
        }

        return new CustomerResponseDto(
                customer.getId(),
                customer.getFullName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }

    public void updateEntity(CustomerRequestDto dto, Customer customer){
        if (dto == null){
            return;
        }

        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
    }

}