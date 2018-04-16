package ec.com.technoloqie.web.picoplaca.backbeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import org.primefaces.PrimeFaces;

@ManagedBean
public class PickPlateBackBean {
	
	private String plate;
	
	private Date day;
	
	private Date hour;
	
	public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
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
}
