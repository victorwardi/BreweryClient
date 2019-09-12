package run.victor.brewery.web.client;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import run.victor.brewery.web.model.CustomerDTO;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Victor Wardi - @victorwardi on 9/11/2019
 */
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDTO dto = customerClient.getCustomerById(UUID.randomUUID());
        System.out.println(dto.toString());
        assertNotNull(dto);
    }

    @Test
    void saveCustomer() {
        URI uri = customerClient.saveCustomer(CustomerDTO.builder().name("Cacilds").build());
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateCustomer() {
        customerClient.updateCustomer(UUID.randomUUID(), CustomerDTO.builder().name("Cacilds").build());
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}