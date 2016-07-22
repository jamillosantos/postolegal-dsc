
package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StationProductHistoryRepository extends CrudRepository<StationProductHistory, Long>
{
	List<StationProductHistory> findAllByStation(Station station);

	List<StationProductHistory> findAllByProduct(Product product);

	List<StationProductHistory> findAllByStationAndProduct(Station station, Product product);
}
