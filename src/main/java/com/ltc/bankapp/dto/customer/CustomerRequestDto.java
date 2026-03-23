package com.ltc.bankapp.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequestDto {

    private String fullName;

    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

}