package br.edu.ifrn.postolegal.view.crud;

import br.edu.ifrn.postolegal.domain.Vehicle;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named

public class VehicleCrudMBean extends CrudMBean<Vehicle, Long>
{
	@Override
	protected Vehicle createBean()
	{
		return Vehicle.builder().build();
	}
}
