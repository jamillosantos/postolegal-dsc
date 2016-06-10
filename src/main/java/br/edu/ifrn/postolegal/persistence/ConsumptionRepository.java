
package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Consumption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ConsumptionRepository extends CrudRepository<Consumption, Long>,// ConsumptionRepositoryCustom,
	QueryByExampleExecutor<Consumption>
{ }
