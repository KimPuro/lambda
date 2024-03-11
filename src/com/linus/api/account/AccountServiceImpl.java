package com.linus.api.account;


import com.linus.api.enums.Messenger;
import lombok.Getter;
import com.linus.api.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountServiceImpl implements AccountService {

    @Getter
    private static AccountService instance = new AccountServiceImpl();
    List<Account> accounts;
    Map<String, User> users;
    private AccountServiceImpl(){
        this.accounts = new ArrayList<>();
    }
    public Messenger save(User user){
        users.put(user.getUsername(), user);
        return Messenger.SUCCESS;
    }


    @Override
    public Messenger createAccount(Account account) {
        return null;
    }

    @Override
    public String deposit(Account account) {
        return null;
    }

    @Override
    public String withdraw(Account account) {
        return null;
    }

    @Override
    public String getBalance(String accountNumber) {
        return null;
    }

    @Override
    public String cancelAccount(String accountNumber) {
        return null;
    }

    @Override
    public List<?> getAccounts() {
        return null;
    }
}