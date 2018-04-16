package ec.com.technoloqie.ejb.picoplaca.commons.log;

import org.apache.log4j.Logger;

/**
 * Utilizado para el tratamiento de log del sistema.
 * @author dvasquez
 *
 */
public class PicoPlacaLog {
	
	static final Logger logger = Logger.getLogger(PicoPlacaLog.class);
	private static final PicoPlacaLog INSTANCIA = new PicoPlacaLog();
	
	public static void info(String parameter){
		logger.info(parameter);
	}
	
	public void debug(String parameter){
		logger.debug("This is debug : " + parameter);
		}
		
	public void warn(String parameter){
		logger.warn("This is warn : " + parameter);
		}
	
	public static void error(String parameter){
		logger.error(parameter);
	}
	
	public void fatal(String parameter){
		logger.fatal("This is fatal : " + parameter);
	}
	
	public static void getLog(){
		
	}
	public static void error(String string, Exception e) {
		error(string + e.getMessage());
	}

}
