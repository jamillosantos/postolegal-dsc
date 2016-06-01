package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.domain.User;
import br.edu.ifrn.postolegal.persistence.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author renato
 */
@Named
public class UserService extends Service<User>
{
	@Inject
	public UserService(UserRepository repository)
	{
		super(repository);
	}

	@Override
	public void validate(User object) throws ValidationException
	{
		if ((object.getName() == null) || object.getName().equals(""))
			throw new RequiredException("nome");

		if ((object.getEmail() == null) || object.getEmail().equals(""))
			throw new RequiredException("email");

		if ((object.getPassword() == null) || object.getPassword().equals(""))
			throw new RequiredException("senha");
	}

}
