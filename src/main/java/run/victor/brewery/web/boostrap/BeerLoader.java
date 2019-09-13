package run.victor.brewery.web.boostrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import run.victor.brewery.web.domain.Beer;
import run.victor.brewery.web.repository.BeerRepository;
import run.victor.brewery.web.model.enums.BeerStyleEnum;

/**
 * Created by Victor Wardi - @victorwardi on 9/12/2019
 */
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeers();
    }

    private void loadBeers() {
        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                .name("Teresopolis")
                .style(BeerStyleEnum.ALE.name())
                .price(BigDecimal.TEN)
                .upc(2268595L)
                .minOnHand(10)
                .quantityToBrew(5)
                .build());

            beerRepository.save(Beer.builder()
                .name("Stela Artois")
                .style(BeerStyleEnum.IPA.name())
                .price(BigDecimal.valueOf(10.2))
                .upc(3100020L)
                .minOnHand(20)
                .quantityToBrew(5)
                .build());

            beerRepository.save(Beer.builder()
                .name("Heiniken")
                .style(BeerStyleEnum.LARGER.name())
                .price(BigDecimal.valueOf(8.2))
                .upc(5500022L)
                .minOnHand(15)
                .quantityToBrew(5)
                .build());
        }

        System.out.println("Loaded beers: " + beerRepository.count());
    }
}
