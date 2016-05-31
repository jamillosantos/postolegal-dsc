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
@EqualsAndHashCode(of = {"vehicle", "date"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_consumption", name = "ID_SEQUENCE", allocationSize = 1)
public class Consumption implements Serializable, Comparable<Consumption>
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@NonNull
	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_consumption__vehicle"))
	private Vehicle vehicle;

	@NonNull
	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_consumption__history"))
	private StationProductHistory history;

	@Column(nullable = false)
	private float totalPaid;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(nullable = false)
	private int odometer;

	private boolean valid;

	@Override
	public int compareTo(Consumption consumption)
	{
		return this.date.compareTo(consumption.date);
	}
}
