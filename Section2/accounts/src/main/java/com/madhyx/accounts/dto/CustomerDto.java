package com.madhyx.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name Can Not Be Empty")
    @Size(min=5, message = "Name Can Not Be Less Than 5 letters")
    private String name;

    @NotEmpty(message = "Email Can Not Be Empty")
    @Email(message = "Email Fields Are Not Correct")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number Must Be 10 Digits")
    private String mobileNumber;
    private AccountsDto accountsDto;
}
