package br.edu.ifrn.postolegal.persistence;

import br.edu.ifrn.postolegal.domain.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.Instant;
import java.util.Date;

@Named
public class DomainFactory
{
	@Inject
	private UserRepository userRepository;

	@Inject
	private VehicleRepository vehicleRepository;

	@Inject
	private StationProductHistoryRepository stationProductHistoryRepository;

	@Inject
	private ProductRepository productRepository;

	@Inject
	private StationRepository stationRepository;

	@Inject
	private ConsumptionRepository consumptionRepository;

	@Inject
	private StationProductRepository stationProduct;

	public User user()
	{
		User u = User.builder()
			.email("user@email.com")
			.name("João da Silva")
			.password("Password")
			.salt("salt")
			.build();
		this.userRepository.save(u);
		return u;
	}

	public Vehicle vehicle()
	{
		Vehicle v = Vehicle.builder()
			.user(this.user())
			.licensePlate("ABC1234")
			.model("Uno")
			.engine("1.0")
			.year(2012)
			.build();
		this.vehicleRepository.save(v);
		return v;
	}

	public Vehicle vehicle(String plate)
	{
		Vehicle v = Vehicle.builder()
			.user(this.user())
			.licensePlate(plate)
			.model("Uno")
			.engine("1.0")
			.year(2012)
			.build();
		this.vehicleRepository.save(v);
		return v;
	}

	public StationProductHistory stationProductHistory()
	{
		StationProductHistory h = StationProductHistory.builder().product(this.product())
			.station(this.station()).price(2.7f).date(new Date()).build();
		this.stationProductHistoryRepository.save(h);
		return h;
	}

	public StationProductHistory stationProductHistory(Product product)
	{
		StationProductHistory h = StationProductHistory.builder().product(product)
			.station(this.station()).price(2.7f).date(new Date()).build();
		this.stationProductHistoryRepository.save(h);
		return h;
	}

	public StationProductHistory stationProductHistory(Station station)
	{
		StationProductHistory h = StationProductHistory.builder().product(this.product())
			.station(station).price(2.7f).date(new Date()).build();
		this.stationProductHistoryRepository.save(h);
		return h;
	}

	public Station station(String name)
	{
		Station s = Station.builder().name(name).build();
		this.stationRepository.save(s);
		return s;
	}

	public Station station()
	{
		return this.station("Posto 01");
	}

	public Product product()
	{
		return this.product("Gasolina");
	}

	public Product product(String title)
	{
		Product p = Product.builder().title(title).build();
		this.productRepository.save(p);
		return p;
	}

	public Consumption consumption(Vehicle vehicle)
	{
		Consumption consumption = Consumption.builder()
			.vehicle(vehicle)
			.history(this.stationProductHistory())
			.totalPaid(12f)
			.odometer(1.2f)
			.date(Date.from(Instant.now()))
			.build();
		this.consumptionRepository.save(consumption);
		return consumption;
	}

	public void stationProduct(Station station, Product product)
	{
		this.stationProduct.save(StationProduct.builder()
			.station(station)
			.product(product)
			.price(1.2f)
			.build());
	}
}
