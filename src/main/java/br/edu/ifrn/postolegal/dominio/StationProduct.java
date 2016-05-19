package br.edu.ifrn.postolegal.dominio;

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
@EqualsAndHashCode
@Builder
@Entity
@IdClass(StationProductId.class)
public class StationProduct implements Serializable, Comparable<StationProduct>
{
	private static final long serialVersionUID = 1L;

	@Id
	private Long productId;

	@Id
	private Long stationId;

	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name="employeeId", referencedColumnName="id")
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_station_product__product"))
  	private Product product;

	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn(name="stationId", referencedColumnName="id")
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_station_product__station"))
	private Station station;

	@Column(nullable = false)
	private float price;
        
        @Override
        public int compareTo(StationProduct o) {
        return stationId.compareTo(o.stationId);
        }
}
