package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.QConsumption;
import br.edu.ifrn.postolegal.domain.Vehicle;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.Date;

public class ConsumptionRepositoryCustomImpl implements ConsumptionRepositoryCustom
{
	private final EntityManager entityManager;

	@Inject
	public ConsumptionRepositoryCustomImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public Float sumTotalPaid(Vehicle vehicle)
	{
		QConsumption qConsumption = QConsumption.consumption;
		JPQLQueryFactory factory = new JPAQueryFactory(entityManager);

		return factory
			.from(qConsumption)
			.where(qConsumption.vehicle.eq(vehicle))
			.select(qConsumption.totalPaid.sum())
			.fetchOne();
	}

	public Float totalPaidByMonth(Vehicle vehicle, Date date)
	{
		QConsumption qConsumption = QConsumption.consumption;
		JPQLQueryFactory factory = new JPAQueryFactory(entityManager);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date start = Date.from(c.toInstant());
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date end = Date.from(c.toInstant());

		return factory
			.from(qConsumption)
			.where(qConsumption.vehicle.eq(vehicle).and(qConsumption.date.between(start, end)))
			.select(qConsumption.totalPaid.sum())
			.fetchOne();
	}
}
