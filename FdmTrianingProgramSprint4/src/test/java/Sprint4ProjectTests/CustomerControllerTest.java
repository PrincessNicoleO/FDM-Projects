package Sprint4ProjectTests;

import Sprint4Project.controller.CustomerController;
import Sprint4Project.exception.CustomerNotFoundException;
import Sprint4Project.model.Customer;
import Sprint4Project.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindCustomerById_Success() throws Exception {
        Customer customer = new Customer("John Doe", "123", "Cityville", "Provinceville", "A1B 2C3");
        customer.setCustomerId(1L);

        when(customerService.findCustomerById(1L)).thenReturn(Optional.of(customer));

        mockMvc.perform(get("/api/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.streetNumber").value("123"))
                .andExpect(jsonPath("$.city").value("Cityville"))
                .andExpect(jsonPath("$.province").value("Provinceville"))
                .andExpect(jsonPath("$.postalCode").value("A1B 2C3"));

        verify(customerService, times(1)).findCustomerById(1L);
    }

    @Test
    public void testFindCustomerById_NotFound() throws Exception {
        when(customerService.findCustomerById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/customers/1"))
                .andExpect(status().isNotFound());

        verify(customerService, times(1)).findCustomerById(1L);
    }

    @Test
    public void testFindAllCustomers() throws Exception {
        Customer customer1 = new Customer("John Doe", "123", "Cityville", "Provinceville", "A1B 2C3");
        customer1.setCustomerId(1L);
        Customer customer2 = new Customer("Jane Smith", "456", "Townville", "Stateville", "D4E 5F6");
        customer2.setCustomerId(2L);

        when(customerService.findAllCustomers()).thenReturn(Arrays.asList(customer1, customer2));

        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"));

        verify(customerService, times(1)).findAllCustomers();
    }

    @Test
    public void testUpdateCustomer_Success() throws Exception {
        Customer existingCustomer = new Customer("John Doe", "123", "Cityville", "Provinceville", "A1B 2C3");
        existingCustomer.setCustomerId(1L);
        Customer updatedCustomer = new Customer("John Updated", "123", "New City", "New Province", "A1B 2C3");
        updatedCustomer.setCustomerId(1L);

        when(customerService.findCustomerById(1L)).thenReturn(Optional.of(existingCustomer));
        when(customerService.createCustomer(Mockito.any(Customer.class))).thenReturn(updatedCustomer);

        mockMvc.perform(put("/api/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCustomer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Updated"))
                .andExpect(jsonPath("$.city").value("New City"))
                .andExpect(jsonPath("$.province").value("New Province"));

        verify(customerService, times(1)).findCustomerById(1L);
        verify(customerService, times(1)).createCustomer(Mockito.any(Customer.class));
    }

    @Test
    public void testUpdateCustomer_NotFound() throws Exception {
        Customer updatedCustomer = new Customer("John Updated", "123", "New City", "New Province", "A1B 2C3");
        updatedCustomer.setCustomerId(1L);

        when(customerService.findCustomerById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCustomer)))
                .andExpect(status().isNotFound());

        verify(customerService, times(1)).findCustomerById(1L);
        verify(customerService, times(0)).createCustomer(Mockito.any(Customer.class));
    }

    @Test
    public void testDeleteCustomer_Success() throws Exception {
        doNothing().when(customerService).deleteCustomer(1L);

        mockMvc.perform(delete("/api/customers/1"))
                .andExpect(status().isNoContent());

        verify(customerService, times(1)).deleteCustomer(1L);
    }

    @Test
    public void testDeleteCustomer_NotFound() throws Exception {
        doThrow(new CustomerNotFoundException("Customer not found")).when(customerService).deleteCustomer(1L);

        mockMvc.perform(delete("/api/customers/1"))
                .andExpect(status().isNotFound());

        verify(customerService, times(1)).deleteCustomer(1L);
    }
}
