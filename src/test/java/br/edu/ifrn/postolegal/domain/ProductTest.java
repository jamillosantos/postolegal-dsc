package br.edu.ifrn.postolegal.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author renato
 */
@Test
public class ProductTest
{
	private static final String TITLE_1 = "Gasolina";

	private static final String TITLE_2 = "Álcool";

	public void testEquals()
	{
		assertThat(Product.builder().title(TITLE_1).build())
			.isEqualTo(Product.builder().title(TITLE_1).build());
	}

	public void testNotEquals()
	{
		assertThat(Product.builder().title(TITLE_1).build())
			.isNotEqualTo(Product.builder().title(TITLE_2).build());
	}

	public void testCompareTo()
	{
		Product p1 = Product.builder().title(TITLE_1).build();
		Product p2 = Product.builder().title(TITLE_2).build();
		Set<Product> products = new TreeSet<Product>();
		products.add(p1);
		products.add(p2);
		assertThat(products.iterator().next()).isEqualTo(p2);
	}
}
