package br.edu.ifrn.postolegal.view.crud;

import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import br.edu.ifrn.postolegal.service.StationProductHistoryService;
import br.edu.ifrn.postolegal.service.StationProductService;
import lombok.Getter;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ViewScoped
@Named
public class StationProductHistoryCrudMBean extends CrudMBean<StationProductHistory, Long>
{
	@Getter
	private StationProduct stationProduct;

	private StationProductService _stationProductService;

	@Getter
	private BarChartModel chart;

	@Override
	protected void init()
	{
		try
		{
			this.stationProduct = this._stationProductService.findOne(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("stationProductId")));
		}
		catch (Exception e)
		{
			this.stationProduct = null;
		}

		this.chart = new BarChartModel();

		ChartSeries prices = new ChartSeries();
		prices.setLabel("Preços");
		float maxValue = 0;
		for (StationProductHistory h : this.find())
		{
			prices.set(h.getDate(), h.getPrice());
			if (maxValue < h.getPrice())
				maxValue = h.getPrice();
		}
		this.chart.setTitle("Histórico de preço");
		this.chart.setLegendPosition("ne");

		Axis xAxis = this.chart.getAxis(AxisType.X);
		xAxis.setLabel("Data");
		Axis yAxis = this.chart.getAxis(AxisType.Y);
		yAxis.setLabel("Preço");
		yAxis.setMin(0);
		yAxis.setMax(maxValue + 0.25);

		this.chart.addSeries(prices);
	}

	@Inject
	public void setStationProductService(StationProductService _stationProductService)
	{
		this._stationProductService = _stationProductService;
	}

	@Override
	protected StationProductHistory createBean()
	{
		return StationProductHistory.builder()
			.product(this.stationProduct.getProduct())
			.station(this.stationProduct.getStation())
			.build();
	}

	public boolean hasStationProduct()
	{
		return this.stationProduct != null;
	}

	@Override
	public List<StationProductHistory> find()
	{
		return this.toList(((StationProductHistoryService)this.getService())
			.findAllByStationProduct(this.stationProduct));
	}
}
