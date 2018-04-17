package ec.com.technoloqie.ejb.picoplaca.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ec.com.technoloqie.ejb.picoplaca.commons.exception.PicoPlacaException;

/**
 * Clase singleton utilitario para poder validar los horarios de pico y placa.
 * @author dvasquez
 *
 */
public class ValidationTimeUtil {

	
	private static ValidationTimeUtil instance = new ValidationTimeUtil();
	
	
	private ValidationTimeUtil(){}
	
	public static ValidationTimeUtil getInstance(){
		return instance;
	}
	
	/**
	 * Utilizado para validar la hora del pico y placa.
	 * @param calendar 
	 * @return
	 */
	public Boolean validatePickPlateSchedule(Calendar calendar) throws PicoPlacaException{
		Boolean validHour = Boolean.FALSE;
		if((calendar.get(Calendar.HOUR_OF_DAY) >= 7 && (calendar.get(Calendar.HOUR_OF_DAY) <= 9) && calendar.get(Calendar.MINUTE) <= 30)
				|| (calendar.get(Calendar.HOUR_OF_DAY) >= 16 && (calendar.get(Calendar.HOUR_OF_DAY) <= 19) && calendar.get(Calendar.MINUTE) <= 30)){
			validHour = Boolean.TRUE;
		}
		return validHour;
	}
	
	/**
	 * Utilizado para poder validar el pico y placa de un automovil. 
	 * @param enrollmentId numero de placa
	 * @param date fecha
	 * @return
	 */
	public Boolean validatePickLicensePlate(String enrollmentId, Date date) throws PicoPlacaException{
		Boolean valid = Boolean.FALSE;
		Calendar calendar = GregorianCalendar.getInstance(); 
		calendar.setTime(date);    
		if(validatePickPlateSchedule(calendar)){
			Integer lastDigit = getLastLicensePlate(enrollmentId);
			 switch (calendar.get(Calendar.DAY_OF_WEEK)) {
	            case 2:  if( lastDigit == 1 || lastDigit == 2){		//dia lunes
					 		valid = Boolean.TRUE;
				 			}
	                     break;
	            case 3:  if( lastDigit == 3 || lastDigit == 4){		//dia martes
					 		valid = Boolean.TRUE;
				 			}
		                 break;
	            case 4:  if( lastDigit == 5 || lastDigit == 6){		//dia miercoles
					 		valid = Boolean.TRUE;
				 			}
		                 break;
	            case 5:  if( lastDigit == 7 || lastDigit == 8){		//dia jueves
					 		valid = Boolean.TRUE;
				 			}
		                 break;
	            case 6:  if( lastDigit == 9 || lastDigit == 0){ 	//dia viernes
					 		valid = Boolean.TRUE;
				 			}
		                 break;
	        } 
		}
		
		return valid;
	}
	
	public Integer getLastLicensePlate(String enrollmentId) throws PicoPlacaException{
		Integer last = -1;	//ultimo digito de la licencia
		enrollmentId = enrollmentId.trim();
		String lastDigit = enrollmentId.substring(enrollmentId.length() -1);
		last = Integer.parseInt(lastDigit);
		//Pattern pattern = Pattern.compile("\\d{3}");
		//Matcher matcher = pattern.matcher(lastDigit);
		//matcher.matches();
		//lastDigit.split("[^0-9]+");
		return last;
	}

}
