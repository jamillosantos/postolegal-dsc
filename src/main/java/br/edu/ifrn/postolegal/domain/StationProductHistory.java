package br.edu.ifrn.postolegal.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author J. Santos &lt;jamillo@gmail.com&gt;
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_station_product_history", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StationProductHistory implements Serializable, Comparable<StationProductHistory>
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
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

	@Override
	public int compareTo(StationProductHistory history)
	{
		int result = this.station.compareTo(history.station);
		if (result == 0)
		{
			if ((result = this.product.compareTo(history.product)) == 0)
				result = this.date.compareTo(history.date);
		}
		return result;
	}
}
