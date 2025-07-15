package com.madhyx.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account Number Must Be 10 Digits")
    private Long accountNumber;

    @NotEmpty(message = "Account Type Can Not Be Empty")
    private String accountType;

    @NotEmpty(message = "Branch Address Can Not Be Empty")
    private String branchAddress;
}
