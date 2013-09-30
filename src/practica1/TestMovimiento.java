package practica1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import org.junit.Test;

import java.util.ArrayList;

public class TestMovimiento {

	
	@Test
	public void testCrearMovimiento() {
		
		Movimiento m = new Movimiento (1,1,2,1);
		
		Assert.assertEquals(m.getColActual(),1);
		Assert.assertEquals(m.getFilaActual(),1);
		Assert.assertEquals(m.getColDestino(),1);
		Assert.assertEquals(m.getFilaDestino(),2);
		
	}
	
	@Test
	public void testMovimientosPosibles() {
	
		Movimiento [] mov = Movimiento.dameMovimientos(1, 2);
		
		for(int i =0; i<mov.length; i++){
			
			Assert.assertEquals(mov[0].getColActual(), 2);
			Assert.assertEquals(mov[0].getFilaActual(), 1);
			Assert.assertEquals(mov[0].getColDestino(), 3);
			Assert.assertEquals(mov[0].getFilaDestino(), 1);
			Assert.assertEquals(mov[1].getColDestino(), 2);
			Assert.assertEquals(mov[1].getFilaDestino(), 2);
			Assert.assertEquals(mov[2].getColDestino(), 2);
			Assert.assertEquals(mov[2].getFilaDestino(), 0);
			Assert.assertEquals(mov[0].getColDestino(), 3);
			Assert.assertEquals(mov[0].getFilaDestino(), 1);
			
		}
		
		Assert.assertEquals(mov.length, 4);
		
	}
	
	@Test
	public void testEsValido() throws Exception {
	
		Tablero tablero = new Tablero("prueba4x4(3).txt");
		tablero.imprimeTablero();
		
		Movimiento m1 = new Movimiento (1,1,2,1);
		Assert.assertTrue(m1.esValido(tablero));
		
		
		Movimiento m2 = new Movimiento (1,1,6,7);
		Assert.assertFalse(m2.esValido(tablero));
		
		
		Movimiento m3 = new Movimiento (0,0,3,8);
		Assert.assertFalse(m3.esValido(tablero));
		
		
		Movimiento m4 = new Movimiento (2,3,1,3);
		Assert.assertTrue(m4.esValido(tablero));
		
		
	}
	
	
	
	
}