package ec.com.technoloqie.ejb.picoplaca.business;

import javax.ejb.Local;

import ec.com.technoloqie.ejb.picoplaca.commons.exception.PicoPlacaException;
import ec.com.technoloqie.ejb.picoplaca.dto.CarDTO;

/**
 * 
 * @author diego
 *
 */
@Local
public interface ICarEjb {
	
	/**
	 * Utilizado para crear un automovil de persistencia
	 * @param car
	 * @throws PicoPlacaException
	 */
	void createCar(CarDTO car) throws PicoPlacaException;
	
}
