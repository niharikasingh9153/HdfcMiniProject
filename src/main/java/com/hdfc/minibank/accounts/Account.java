package com.hdfc.minibank.accounts;

import java.math.BigDecimal;

public abstract class Account {
    protected String accountNo;
    protected String customerId;
    protected BigDecimal balance;

    public Account(String accountNo, String customerId, BigDecimal balance) {
        this.accountNo = accountNo;
        this.customerId = customerId;
        this.balance = balance;
    }

    public abstract void deposit(BigDecimal amount);
    public abstract void withdraw(BigDecimal amount) throws Exception;
}
