package br.edu.ifrn.postolegal.view.crud;

import br.edu.ifrn.postolegal.domain.User;
import br.edu.ifrn.postolegal.domain.Vehicle;
import br.edu.ifrn.postolegal.service.UserService;
import br.edu.ifrn.postolegal.service.VehicleService;
import lombok.Getter;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ViewScoped
@Named

public class VehicleCrudMBean extends CrudMBean<Vehicle, Long>
{
	@Getter
	private User user;

	private UserService _userService;

	@Inject
	public void setUserService(UserService userService)
	{
		this._userService = userService;
	}

	@Override
	protected void init()
	{
		super.init();
		try
		{
			this.user = this._userService.findOne(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId")));
		}
		catch (Exception e)
		{
			this.user = null;
		}
	}

	public boolean hasUser()
	{
		return this.user != null;
	}

	@Override
	protected Vehicle createBean()
	{
		return Vehicle.builder().build();
	}

	@Override
	protected Vehicle processBeforeInsertUpdate(Vehicle bean)
	{
		Vehicle result = super.processBeforeInsertUpdate(bean);
		result.setUser(this.user);
		return result;
	}

	@Override
	public List<Vehicle> find()
	{
		return this.toList(((VehicleService)this.getService()).findAllByUser(this.user));
	}
}
