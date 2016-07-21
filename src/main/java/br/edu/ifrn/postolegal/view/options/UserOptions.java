package br.edu.ifrn.postolegal.view.options;

import br.edu.ifrn.postolegal.domain.User;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class UserOptions extends Options<User, Long>
{
	@Override
	public String label(User user)
	{
		return user.getName();
	}

	@Override
	protected Object key(User user)
	{
		return user.getId();
	}

}
