package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Consumption;
import javax.inject.Named;

@Named
public class ConsumptionRepositoryInMemory extends RepositoryInMemory<Consumption> implements ConsumptionRepository {
    
}
