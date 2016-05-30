package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Consumption;
import br.edu.ifrn.postolegal.persistence.ConsumptionRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ConsumptionService extends Service<Consumption>
{
	@Inject
	public ConsumptionService(ConsumptionRepository repository)
	{
            super(repository);
	}

	@Override
	protected void validate(Consumption object) throws Exception
	{
		if (object.getVehicle() == null)
		{
                    throw new Exception("Informe o veículo.");
		}
                
                if (object.getHistory() == null)
		{
                    throw new Exception("Informe o histórico.");
		}
                
                if (object.getTotalPaid() > 0)
		{
                    throw new Exception("Informe um total maior que 0.");
		}
                
                if (object.getDate() != null)
		{
                    throw new Exception("Informe uma data.");
		}
                
                if (object.getOdometer() > 0)
		{
                    throw new Exception("Informe um Odômetro.");
		}
	}
}
