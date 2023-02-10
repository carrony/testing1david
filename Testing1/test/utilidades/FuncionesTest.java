package utilidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import excepciones.DebeSerPositivoException;

class FuncionesTest {

	@Test
	void testEsBisiesto() throws DebeSerPositivoException {
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
				
		assertThrows(DebeSerPositivoException.class, 
				()->Funciones.esBisiesto(-4));
	}

	@Test
	void testGetDiagnostico() throws DebeSerPositivoException {
		assertEquals("Bajo Peso", 
				Funciones.getDiagnostico(10.2f),
				"DEbería devolver el texto Bajo Peso");
		assertEquals("Peso normal (saludable)", 
				Funciones.getDiagnostico(20f),
				"DEbería devolver el texto Peso normal (saludable)");
		
		assertEquals("Bajo Peso", 
				Funciones.getDiagnostico(18.5f),
				"DEbería devolver el texto Bajo Peso");
		
		assertEquals("Peso normal (saludable)", 
				Funciones.getDiagnostico(24.9f),
				"DEbería devolver el texto Peso normal (saludable)");
		
		assertEquals("Sobrepeso", 
				Funciones.getDiagnostico(25f),
				"DEbería devolver el texto 'Sobrepeso'");
		assertEquals("Sobrepeso", 
				Funciones.getDiagnostico(29.9f),
				"DEbería devolver el texto 'Sobrepeso'");
		assertEquals("Obesidad premórbida", 
				Funciones.getDiagnostico(35f),
				"DEbería devolver el texto 'Obesidad premórbida'");
		assertEquals("Obesidad premórbida", 
				Funciones.getDiagnostico(40f),
				"DEbería devolver el texto 'Obesidad premórbida'");
		assertEquals("Obesidad mórbida", 
				Funciones.getDiagnostico(48f),
				"DEbería devolver el texto 'Obesidad mórbida'");
		
		assertThrows(DebeSerPositivoException.class,
				()->Funciones.getDiagnostico(-20f),
				"debe lanzar una excepcion");
		
		
	}
	
	
}
