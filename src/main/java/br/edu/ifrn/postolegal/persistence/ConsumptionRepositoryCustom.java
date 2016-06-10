package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.Vehicle;

import java.util.Date;

public interface ConsumptionRepositoryCustom
{
	Float sumTotalPaid(Vehicle vehicle);

	Float totalPaidByMonth(Vehicle vehicle, Date date);
}
