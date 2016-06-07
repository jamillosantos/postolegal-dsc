package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.persistence.StationRepository;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author renato
 */
@Named
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
		if (object.getLatitude() == 0f)
			throw new RequiredException("latitude");
		if (object.getLongitude() == 0f)
			throw new RequiredException("longitude");
	}
}
