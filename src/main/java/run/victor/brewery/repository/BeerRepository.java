package run.victor.brewery.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import run.victor.brewery.domain.Beer;

/**
 * Created by Victor Wardi - @victorwardi on 9/12/2019
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
