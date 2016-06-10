
package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.domain.StationProductId;
import org.springframework.data.repository.CrudRepository;

public interface StationProductRepository extends CrudRepository<StationProduct, StationProductId>
{
	Iterable<StationProduct> findAllByProduct(Product product);

	Iterable<StationProduct> findAllByStation(Station station);
}
