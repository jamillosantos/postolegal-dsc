package br.edu.ifrn.postolegal.dominio;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_station_product_history", name = "ID_SEQUENCE", allocationSize = 1)
public class StationProductHistory
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@NonNull
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_station_product_history__product"))
	private Product product;

	@NonNull
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_station_product_history__station"))
	private Station station;

	@Column(nullable = false)
	private float price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date;
}
