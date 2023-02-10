package utilidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import excepciones.AnioDebeSerPositivoException;

class FuncionesTest {

	@Test
	void testEsBisiesto() throws AnioDebeSerPositivoException {
		assertFalse(Funciones.esBisiesto(2023), 
				"El test ha fallado, 2023 no es bisiesto");
		
		assertTrue(Funciones.esBisiesto(2024), 
				"El año 2024 es bisiesto");
		
		assertTrue(Funciones.esBisiesto(2000), 
				"El año 2000 es bisiesto");
		
//		assertFalse(Funciones.esBisiesto(2100),
//				"EL año 2100 NO es bisiesto");
		
//		assertThrows(AnioDebeSerPositivoException.class, 
//				new Executable() {
//					@Override
//					public void execute() throws Throwable {
//						Funciones.esBisiesto(-4)
//					}
//		});
				
		assertThrows(AnioDebeSerPositivoException.class, 
				()->Funciones.esBisiesto(-4));
	}

}
