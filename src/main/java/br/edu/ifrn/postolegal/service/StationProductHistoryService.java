package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.StationProductHistory;
import br.edu.ifrn.postolegal.persistence.StationProductHistoryRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StationProductHistoryService extends Service<StationProductHistory>
{
	@Inject
	public StationProductHistoryService(StationProductHistoryRepository repository)
	{
            super(repository);
	}

	@Override
	protected void validate(StationProductHistory object) throws Exception
	{
		if (object.getProduct()== null)
            {
                throw new Exception("Informe o Produto.");
            }

            if (object.getPrice()> 0)
            {
                throw new Exception("Informe um preço maior que 0.");
            }

            if (object.getStation()== null)
            {
                throw new Exception("Informe um posto.");
            }
            
            if (object.getDate()== null)
            {
                throw new Exception("Informe uma data.");
            }
	}
}
