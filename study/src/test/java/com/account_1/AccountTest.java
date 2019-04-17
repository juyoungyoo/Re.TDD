package com.account_1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account(10000);
    }

    @Test
    public void 잔고조회() throws Exception {
        assertThat(account.getBalence(), is(10000));

        account = new Account(1000);
        assertThat(account.getBalence(), is(1000));

        account = new Account(0);
        assertThat(account.getBalence(),is(0));
    }

    @Test
    public void 입금() {
        account.deposit(1000);
        assertThat(account.getBalence(),is(11000));
    }

    @Test
    public void 출금() {
        account.withdraw(1000);
        assertThat(account.getBalence(), is(9000));
    }
}
