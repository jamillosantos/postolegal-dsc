
package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StationProductHistoryRepository extends CrudRepository<StationProductHistory, Long>
{
	Set<StationProductHistory> findAllByStation(Station station);

	Set<StationProductHistory> findAllByProduct(Product product);
}
