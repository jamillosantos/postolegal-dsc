package br.edu.ifrn.postolegal.view.crud;

import br.edu.ifrn.postolegal.domain.Station;
import br.edu.ifrn.postolegal.domain.StationProduct;
import br.edu.ifrn.postolegal.service.StationProductService;
import br.edu.ifrn.postolegal.service.StationService;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ViewScoped
@Named
public class StationProductCrudMBean extends CrudMBean<StationProduct, Long>
{
	@Getter
	private Station station;

	private StationService _stationService;

	private StationProductService _stationProductService;

	@PostConstruct
	@Override
	protected void init()
	{
		try
		{
			String stationId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("stationId");
			System.out.println(stationId);
			System.out.println(this._stationService);
			this.station = this._stationService.findOne(Long.parseLong(stationId));
			System.out.println(this.station);
		}
		catch (Exception e)
		{
			this.station = null;
			e.printStackTrace();
		}
	}

	@Inject
	public void setStationProductService(StationProductService _stationProductService)
	{
		this._stationProductService = _stationProductService;
	}

	@Inject
	public void setStationService(StationService _stationService)
	{
		this._stationService = _stationService;
	}

	@Override
	protected StationProduct createBean()
	{
		return StationProduct.builder().build();
	}

	public boolean hasStation()
	{
		return this.station != null;
	}

	@Override
	public List<StationProduct> find()
	{
		return this.toList(this._stationProductService.findAllByStation(this.station));
	}

	@Override
	protected StationProduct processBeforeInsert(StationProduct bean)
	{
		StationProduct result = super.processBeforeInsert(bean);
		result.setStation(this.station);
		return result;
	}
}
