package com.linus.api.account;

import com.linus.api.enums.Messenger;

import java.util.List;

public interface AccountService {
    Messenger createAccount(Account account);
    String deposit(Account account);
    String withdraw(Account account);
    String getBalance(String accountNumber);
    String cancelAccount(String accountNumber);
    List<?> getAccounts();
}