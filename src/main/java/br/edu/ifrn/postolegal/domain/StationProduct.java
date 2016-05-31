package br.edu.ifrn.postolegal.domain;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

import javax.persistence.*;

/**
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"product", "station"})
@Builder
@Entity
@IdClass(StationProductId.class)
public class StationProduct implements Serializable, Comparable<StationProduct>
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_id", insertable = false, updatable = false)
	private Long productId;

	@Id
	@Column(name = "station_id", insertable = false, updatable = false)
	private Long stationId;

	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
	@JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_station_product__product"))
	private Product product;

	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name = "station_id", referencedColumnName = "id")
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
