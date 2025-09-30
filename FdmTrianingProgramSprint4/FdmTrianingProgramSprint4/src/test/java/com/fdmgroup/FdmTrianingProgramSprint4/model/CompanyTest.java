package com.fdmgroup.FdmTrianingProgramSprint4.model;

import com.fdmgroup.FdmTrianingProgramSprint4.dto.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerTest {

    private Customer customer;
    private Address mockAddress;

    @BeforeEach
    void setUp() {
        mockAddress = mock(Address.class);
        when(mockAddress.getAddressId()).thenReturn(123L);

        // Using an anonymous class since Customer is abstract
        customer = new Customer() {};
        customer.setAddress(mockAddress);
        customer.setName("Test Customer");
        customer.setCustomerId(1001L);
    }

    @Test
    void testSetAndGetCustomerId() {
        customer.setCustomerId(2002L);
        assertEquals(2002L, customer.getCustomerId());
    }

    @Test
    void testSetAndGetName() {
        customer.setName("New Name");
        assertEquals("New Name", customer.getName());
    }

    @Test
    void testSetAndGetAddress() {
        Address newAddress = mock(Address.class);
        customer.setAddress(newAddress);
        assertEquals(newAddress, customer.getAddress());
    }

    @Test
    void testSetAddressThrowsExceptionWhenNull() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> customer.setAddress(null)
        );
        assertEquals("Address cannot be null.", exception.getMessage());
    }

    @Test
    void testToDTO() {
        CustomerDTO customerDTO = customer.toDTO();
        assertEquals(1001L, customerDTO.getCustomerId());
        assertEquals("Test Customer", customerDTO.getName());
        assertEquals(123L, customerDTO.getAddressId());
    }

    @Test
    void testFromDTO() {
        CustomerDTO customerDTO = new CustomerDTO(2002L, "Updated Customer", 456L);
        Address newMockAddress = mock(Address.class);

        customer.fromDTO(customerDTO, newMockAddress);

        assertEquals(2002L, customer.getCustomerId());
        assertEquals("Updated Customer", customer.getName());
        assertEquals(newMockAddress, customer.getAddress());
    }
}

