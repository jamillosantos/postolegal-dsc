package br.edu.ifrn.postolegal.view.crud;

import br.edu.ifrn.postolegal.domain.Product;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class ProductCrudMBean extends CrudMBean<Product, Long>
{
	@Override
	protected Product createBean()
	{
		return Product.builder().build();
	}

	@Override
	public boolean isCheckBeforeDelete(Product bean)
	{
		return true;
	}
}
