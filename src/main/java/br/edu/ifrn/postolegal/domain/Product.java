package br.edu.ifrn.postolegal.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"title"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_product", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product implements Serializable, Comparable<Product>
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@Column(nullable = false)
	private String title;

	@Singular
	@OneToMany(mappedBy = "product")
	private Set<StationProduct> stations;

	@Override
	public int compareTo(Product product)
	{
		return product.title.compareTo(this.title);
	}
}
