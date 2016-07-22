
package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Product;
import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.domain.StationProductId;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StationProductRepository extends CrudRepository<StationProduct, Long>
{
	Set<StationProduct> findAllByProduct(Product product);

	Set<StationProduct> findAllByStation(Station station);
}
