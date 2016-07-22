package br.edu.ifrn.postolegal.view.options;

import br.edu.ifrn.postolegal.domain.Product;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class ProductOptions extends Options<Product, Long>
{
	@Override
	public String label(Product product)
	{
		return product.getTitle();
	}

	@Override
	protected Object key(Product product)
	{
		return product.getId();
	}

}
