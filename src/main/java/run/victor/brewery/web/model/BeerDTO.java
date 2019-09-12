package run.victor.brewery.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import run.victor.brewery.web.model.enums.BeerStyleEnum;

/**
 * Created by Victor Wardi - @victorwardi on 9/6/2019
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BeerDTO {

    private UUID id;
    private Integer version;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    private String beerName;
    private BeerStyleEnum beerStyle;

    private Long upc;

    private BigDecimal price;

}
