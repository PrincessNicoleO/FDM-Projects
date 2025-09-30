package com.fdmgroup.FdmTrianingProgramSprint4.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fdmgroup.FdmTrianingProgramSprint4.dto.AccountDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    private Account account;
    private Customer mockCustomer;

    @BeforeEach
    void setUp() {
        mockCustomer = mock(Customer.class);
        when(mockCustomer.getCustomerId()).thenReturn(1L);
        account = new Account(500.0, mockCustomer) {};
    }

    @Test
    void testConstructorWithArguments() {
        assertNotNull(account);
        assertEquals(500.0, account.getBalance());
        assertEquals(mockCustomer, account.getCustomer());
    }

    @Test
    void testDefaultConstructor() {
        Account defaultAccount = new Account() {};
        assertNotNull(defaultAccount);
        assertNull(defaultAccount.getBalance());
        assertNull(defaultAccount.getCustomer());
    }

    @Test
    void testSetAndGetAccountId() {
        account.setAccountId(10L);
        assertEquals(10L, account.getAccountId());
    }

    @Test
    void testSetAndGetBalance() {
        account.setBalance(1000.0);
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void testSetAndGetCustomer() {
        Customer anotherCustomer = mock(Customer.class);
        account.setCustomer(anotherCustomer);
        assertEquals(anotherCustomer, account.getCustomer());
    }

    @Test
    void testToDTO() {
        account.setAccountId(15L);
        AccountDTO dto = account.toDTO();
        assertEquals(15L, dto.getAccountId());
        assertEquals(500.0, dto.getBalance());
        assertEquals(1L, dto.getCustomerId());
    }

    @Test
    void testToString() {
        account.setAccountId(25L);
        String result = account.toString();
        assertTrue(result.contains("accountId=25"));
        assertTrue(result.contains("balance=500.0"));
        assertTrue(result.contains("customer="));
    }
}

