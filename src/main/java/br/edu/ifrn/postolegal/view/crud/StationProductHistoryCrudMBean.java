package br.edu.ifrn.postolegal.view.crud;

import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.domain.StationProductHistory;
import br.edu.ifrn.postolegal.service.StationProductHistoryService;
import br.edu.ifrn.postolegal.service.StationProductService;
import lombok.Getter;

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
