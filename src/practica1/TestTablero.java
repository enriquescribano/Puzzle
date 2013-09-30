package practica1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestTablero {

	@Test
	public void testCrearTablero() throws Exception {
		
		Tablero tablero = new Tablero("prueba4x4(3).txt");
		tablero.imprimeTablero();
		
		String s = tablero.toString();
		
		Assert.assertEquals(s, "1,0,3,10,5,2,9,8,6,13,15,12,11,7,4,14,");
		Assert.assertNotNull(s);
		
	}

	@Test
	public void testHazMovimiento() throws Exception {

		Tablero tablero = new Tablero("prueba4x4(3).txt");
		tablero.imprimeTablero();
		
		Movimiento mov = new Movimiento (1,1,2,1);
		
		Assert.assertTrue(tablero.getTablero()[1][1].getValor()==2);		
		tablero.hazMovimiento(mov);
		Assert.assertTrue(tablero.getTablero()[1][1].getValor()==13);
		
		
		
		Movimiento mov2 = new Movimiento (2,3,3,3);
		
		Assert.assertTrue(tablero.getTablero()[3][3].getValor()==14);		
		tablero.hazMovimiento(mov2);
		Assert.assertTrue(tablero.getTablero()[3][3].getValor()==12);
		
		
	}
	
	
	
	
	
	
}
