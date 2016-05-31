package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.persistence.StationProductRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StationProductService extends Service<StationProduct>
{
	@Inject
	public StationProductService(StationProductRepository repository)
	{
            super(repository);
	}

	@Override
	protected void validate(StationProduct object) throws Exception
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
	}
}
