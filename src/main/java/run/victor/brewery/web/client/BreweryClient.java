package run.victor.brewery.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;
import run.victor.brewery.web.model.BeerDTO;

/**
 * Created by Victor Wardi - @victorwardi on 9/9/2019
 */
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beers";

    @Value("${vr.brewery.apiHost}")
    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID id) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + "/" + id.toString(), BeerDTO.class);
    }

    public URI saveBeer(BeerDTO beerDTO) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDTO);
    }

    public void updateBeer(UUID id, BeerDTO beerDTO){
        restTemplate.put(apiHost  + BEER_PATH_V1 + "/" + id.toString(), beerDTO);
    }

    public void deleteBeer(UUID id) {

        restTemplate.delete(apiHost  + BEER_PATH_V1 + "/" + id.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

}
