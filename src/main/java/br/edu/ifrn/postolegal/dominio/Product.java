package br.edu.ifrn.postolegal.dominio;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_product", name = "ID_SEQUENCE", allocationSize = 1)
public class Product
{
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@Column(nullable = false, length = 60)
	private String title;

	@Singular
	@OneToMany(mappedBy = "product")
	private Set<StationProduct> stations;
}
