package run.victor.brewery.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import run.victor.brewery.web.model.CustomerDTO;

/**
 * Created by Victor Wardi - @victorwardi on 9/11/2019
 */
@Component
public class CustomerClient {

    public final String BEER_PATH_V1 = "/api/v1/customers";

    @Value("${vr.brewery.apiHost}")
    private String apiHost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDTO getCustomerById(UUID id) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + "/" + id.toString(), CustomerDTO.class);
    }

    public URI saveCustomer(CustomerDTO customerDTO) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, customerDTO);
    }

    public void updateCustomer(UUID id, CustomerDTO customerDTO){
        restTemplate.put(apiHost  + BEER_PATH_V1 + "/" + id.toString(), customerDTO);
    }

    public void deleteCustomer(UUID id) {

        restTemplate.delete(apiHost  + BEER_PATH_V1 + "/" + id.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
