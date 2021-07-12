package com.mitrais.bootcamp.atm.service;

import com.mitrais.bootcamp.atm.entity.Account;
import com.mitrais.bootcamp.atm.model.TransferRequest;
import com.mitrais.bootcamp.atm.model.TransferResponse;
import com.mitrais.bootcamp.atm.model.WithdrawResponse;
import com.mitrais.bootcamp.atm.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;

    private AccountService accountService;

    @BeforeEach
    void setup() {
        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    @DisplayName("Test if account is Exist")
    void testIsAccountExist() {
        Mockito.when(accountRepository.findByAccountNumber("112233"))
                .thenReturn(new Account("John Doe", "012108", 100L, "112233"));

        boolean isExist = accountService.isAccountExist("112233");

        Assertions.assertTrue(isExist);
    }


    @Test
    @DisplayName("Find Account By Account Number And PIN")
    void testGetAccount() {
        Mockito.when(accountRepository.findByAccountNumberAndPin("112233", "012108"))
                .thenReturn(new Account("John Doe", "012108", 100L, "112233"));

        Account account = accountService.getAccount("112233", "012108");
        Assertions.assertNotNull(account);
    }

    @Test
    @DisplayName("Withdraw some amount from account")
    void testWithdrawBalance() {
        Account account = new Account("John Doe", "012108", 100L, "112233");
        Mockito.when(accountRepository.findByAccountNumber("112233"))
                .thenReturn(account);

        Mockito.when(accountRepository.reduceBalanceByAccountNumber(10L, account))
                .thenReturn(new Account("John Doe", "012108", 90L, "112233"));

        WithdrawResponse response = accountService.withdrawBalance("1", "112233", 0L);


        Assertions.assertEquals(response.getBalance(), "$90");
    }

    @Test
    @DisplayName("Transfer some amount from 112233 to 112244")
    void testTransfer() {
        Account account1 = new Account("John Doe", "012108", 100L, "112233");
        Mockito.when(accountRepository.findByAccountNumber("112233"))
                .thenReturn(account1);

        Account account2 = new Account("Jane Doe", "932012", 30L, "112244");
        Mockito.when(accountRepository.findByAccountNumber("112244"))
                .thenReturn(account2);

        Mockito.when(accountRepository.reduceBalanceByAccountNumber(10L, account1))
                .thenReturn(new Account("John Doe", "012108", 90L, "112233"));

        Mockito.when(accountRepository.increaseBalanceByAccountNumber(10L, account2))
                .thenReturn(new Account("John Doe", "932012", 40L, "112244"));

        TransferResponse response = accountService.transferFunds(new TransferRequest("112233", "112244", 10L, "102233"));
        Assertions.assertEquals(response.getBalance(), 90L);
        Assertions.assertEquals(response.getBalanceDestination(), 40L);
    }
}