package ec.com.technoloqie.ejb.picoplaca.commons.exception;

/**
 * Clase para el tratamiento de los errores que pueden ocurrir en la ejecucion del codigo
 * @author dvasquez
 *
 */
@SuppressWarnings("serial")
public class PicoPlacaException extends RuntimeException{
	
	public PicoPlacaException() {
        super();
    }
    
	public PicoPlacaException(String msg, Throwable nested) {
        super(msg, nested);
    }
    
	public PicoPlacaException(String message) {
        super(message);
    }
    
	public PicoPlacaException(Throwable nested) {
        super(nested);
    }
}
