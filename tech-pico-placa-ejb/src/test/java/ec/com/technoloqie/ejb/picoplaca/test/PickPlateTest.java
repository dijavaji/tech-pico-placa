package ec.com.technoloqie.ejb.picoplaca.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ejb.EJBContainer;
import javax.ejb.EJBException;
import javax.naming.NamingException;

import org.junit.Test;

import ec.com.technoloqie.ejb.picoplaca.business.CarEjb;
import ec.com.technoloqie.ejb.picoplaca.commons.exception.PicoPlacaException;
import ec.com.technoloqie.ejb.picoplaca.commons.log.PicoPlacaLog;
import ec.com.technoloqie.ejb.picoplaca.utils.ValidationTimeUtil;


public class PickPlateTest {
	
	@Test
	public void testHour() {
		String enrollmentId; 
		Date date; 
		Date hour;
		String dateStart = "01/14/2012 09:29:58";
		String dateStop = "04/12/2018 10:31:48";

		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try {
			date = format.parse(dateStart);
			Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
			calendar.setTime(date);   // assigns calendar to given date 
			calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
			calendar.get(Calendar.HOUR);        // gets hour in 12h format
			calendar.get(Calendar.MONTH);       // gets month number, NOTE this is zero based!
			calendar.get(Calendar.DAY_OF_WEEK);
			//validatePickPlateSchedule(calendar);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if(calendar.get(Calendar.HOUR_OF_DAY) >= 7 && (calendar.get(Calendar.HOUR_OF_DAY) <= 9) && calendar.get(Calendar.MINUTE) <= 30){
			
		}*/
		
	}
	
	
	@Test
	public void testPickPlateEjb(){
		try {
			PicoPlacaLog.info("Prueba test de contenedor ejb ");
			CarEjb instance = (CarEjb) EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/ScheduleDTO");
			instance.createCar(null);
			//assert
		} catch (EJBException e) {
			PicoPlacaLog.error("Error en el test de contenedor ejb ", e);
			//throw new PicoPlacaException("Error en el test de contenedor ejb ", e);
		} catch (NamingException e) {
			PicoPlacaLog.error("Error en el test de contenedor ejb ", e);
		}
	}
	
	@Test
	public void testPickLicensePlate(){
		String enrollmentId = "POG-0342";
		Date date;
		Date hour;
		String dateStart = "01/16/2012 09:29:58";
		String dateStop = "04/12/2018 10:31:48";

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		PicoPlacaLog.error("Prueba test de validacion de pico y placa ");
		try {
			date = format.parse(dateStart);
			hour = format.parse(dateStop);
			ValidationTimeUtil.getInstance().validatePickLicensePlate(enrollmentId, date, hour);
		} catch (Exception e) {
			PicoPlacaLog.error("Error en el testPickLicensePlate ", e);
		}
	}

}
