package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.persistence.StationRepository;

import javax.inject.Inject;

/**
 * @author renato
 */
public class StationService extends Service<Station>
{
	@Inject
	public StationService(StationRepository repository)
	{
		super(repository);
	}

	@Override
	protected void validate(Station object) throws ValidationException
	{
		if ((object.getName() == null) || object.getName().equals(""))
			throw new RequiredException("nome");
	}
}
