package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.User;
import br.edu.ifrn.postolegal.persistence.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserService extends Service<User, Long>
{
	@Inject
	public UserService(UserRepository repository)
	{
		super(repository);
	}

	@Override
	public void validate(User user) throws ValidationException
	{
		user.validate();
	}

}
