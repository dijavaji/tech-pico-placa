package ec.com.technoloqie.ejb.picoplaca.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.com.technoloqie.ejb.picoplaca.commons.exception.PicoPlacaException;
import ec.com.technoloqie.ejb.picoplaca.commons.log.PicoPlacaLog;
import ec.com.technoloqie.ejb.picoplaca.dto.CarDTO;

@Stateless
public class CarEjb implements ICarEjb{

	//@PersistenceContext
    //private EntityManager em;
	//@Override
	public void createCar(CarDTO car) throws PicoPlacaException{
		try{
			//em.persist(car);
			//em.flush();
		}catch(Exception e){
			PicoPlacaLog.error("Error al crear un automovil", e);
			throw new PicoPlacaException("Error al crear un automovil", e);
		} 
	}

}
