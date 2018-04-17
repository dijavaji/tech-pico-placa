package ec.com.technoloqie.ejb.picoplaca.business;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.com.technoloqie.ejb.picoplaca.commons.exception.PicoPlacaException;
import ec.com.technoloqie.ejb.picoplaca.commons.log.PicoPlacaLog;
import ec.com.technoloqie.ejb.picoplaca.dto.CarDTO;
import ec.com.technoloqie.ejb.picoplaca.dto.ScheduleDTO;
import ec.com.technoloqie.ejb.picoplaca.utils.ValidationTimeUtil;

@Stateless
public class CarEjb implements ICarEjb{

	@PersistenceContext
    private EntityManager em;
	@Override
	public void createCar(CarDTO car) throws PicoPlacaException{
		try{
			//em.persist(car);
			//em.flush();
		}catch(Exception e){
			PicoPlacaLog.error("Error al crear un automovil", e);
			throw new PicoPlacaException("Error al crear un automovil", e);
		} 
	}
	
	@Override
	public Boolean validatePickLicensePlate(CarDTO car, ScheduleDTO restrictSchedule) throws PicoPlacaException{
		Boolean validate = Boolean.FALSE;
		try {
			Date dateHour = new Date(restrictSchedule.getRestrictionDate().getTime() + restrictSchedule.getRestrictionHour().getHours());
			validate = ValidationTimeUtil.getInstance().validatePickLicensePlate(car.getEnrollmentId(), dateHour);
		} catch (Exception e) {
			PicoPlacaLog.error("Error al validar el pico y placa ", e);
			throw new PicoPlacaException("Error al validar el pico y placa ", e);
		}
		return validate;
	}

}
