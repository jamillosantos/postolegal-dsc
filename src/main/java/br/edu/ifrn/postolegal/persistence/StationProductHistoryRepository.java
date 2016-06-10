
package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import org.springframework.data.repository.CrudRepository;

public interface StationProductHistoryRepository extends CrudRepository<StationProductHistory, Long>
{
	Iterable<StationProductHistory> findAllByStation(Station station);

	Iterable<StationProductHistory> findAllByProduct(Product product);
}
