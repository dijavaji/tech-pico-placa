package ec.com.technoloqie.web.picoplaca.backbeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ec.com.technoloqie.ejb.picoplaca.business.ICarEjb;
import ec.com.technoloqie.ejb.picoplaca.dto.CarDTO;
import ec.com.technoloqie.ejb.picoplaca.dto.ScheduleDTO;

@ManagedBean
public class PickPlateBackBean {
	
	private String plate;
	
	private Date day;
	
	private Date hour;
	
	@EJB
	private ICarEjb carEjb;
	private CarDTO carDTO;
	private ScheduleDTO schedule;
	
	public void click() {
		this.carDTO = new CarDTO();
		this.carDTO.setEnrollmentId(this.plate);
		this.schedule = new ScheduleDTO();
		this.schedule.setRestrictionDate(this.day);
		this.schedule.setRestrictionHour(this.hour);
		this.carEjb.validatePickLicensePlate(this.carDTO, this.schedule);
		//PrimeFaces.current().ajax().update("form:display");
        //PrimeFaces.current().executeScript("PF('dlg').show()");
    }

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public CarDTO getCarDTO() {
		return carDTO;
	}

	public void setCarDTO(CarDTO carDTO) {
		this.carDTO = carDTO;
	}

	public ICarEjb getCarEjb() {
		return carEjb;
	}

	public void setCarEjb(ICarEjb carEjb) {
		this.carEjb = carEjb;
	}
}
