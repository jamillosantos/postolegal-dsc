package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.User;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserFactory
{
	@Inject
	private UserRepository userRepository;

	public User user()
	{
		User u = User.builder()
			.email("user@email.com")
			.name("João da Silva")
			.password("Password")
			.salt("salt")
			.build();
		this.userRepository.save(u);
		return u;
	}
}
