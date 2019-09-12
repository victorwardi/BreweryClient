package run.victor.brewery.web.client;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import run.victor.brewery.web.model.BeerDTO;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Victor Wardi - @victorwardi on 9/9/2019
 */
@SpringBootTest
class BreweryClientTest {

  @Autowired
  BreweryClient breweryClient;

  @Test
  void getBeerById() {

    BeerDTO beerDTO = breweryClient.getBeerById(UUID.randomUUID());
    System.out.println(beerDTO.toString());
    assertNotNull(beerDTO);
  }

    @Test
    void saveBeer() {
        URI uri = breweryClient.saveBeer(BeerDTO.builder().beerName("Cacilds").build());
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeer() {
        breweryClient.updateBeer(UUID.randomUUID(), BeerDTO.builder().beerName("Cacilds").build());
    }
    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}