package br.edu.ifrn.postolegal.domain;

import java.io.Serializable;
import java.util.Set;

import lombok.*;

import javax.persistence.*;

/**
 * @author jbull
 */
@Getter
@Setter
@ToString(exclude = {"consumptions"})
@EqualsAndHashCode(of = {"licensePlate"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_vehicle", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Vehicle implements Serializable, Comparable<Vehicle>
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@Singular
	@OneToMany(mappedBy = "vehicle")
	public Set<Consumption> consumptions;

	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_vehicle__user"))
	private User user;

	@Column(nullable = false)
	private Integer year;

	@Column(nullable = false)
	private String engine;

	@Column(nullable = false)
	private String model;

	@Column(nullable = false)
	private String licensePlate;

	@Override
	public int compareTo(Vehicle vehicle)
	{
		int result = this.model.compareTo(vehicle.model);
		if (result == 0)
		{
			if ((result = this.year.compareTo(vehicle.year)) == 0)
				result = this.licensePlate.compareTo(vehicle.licensePlate);
		}
		return result;
	}
}
