package br.edu.ifrn.postolegal.domain;

import java.io.Serializable;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"product", "station"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_station_product", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StationProduct implements Serializable, Comparable<StationProduct>
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_station_product__product"))
	private Product product;

	@ManyToOne(optional = false)
	@JoinColumn(name = "station_id", nullable = false, foreignKey = @ForeignKey(name = "fk_station_product__station"))
	private Station station;

	@Column(nullable = false)
	private float price;

	@Override
	public int compareTo(StationProduct stationProduct)
	{
		int result = this.station.compareTo(stationProduct.station);
		if (result == 0)
			result = this.product.compareTo(stationProduct.product);
		return result;
	}
}
