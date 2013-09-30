package practica1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import org.junit.Test;

public class TestPieza {

	
	
	@Test
	public void testCrearPieza() {
		
		Pieza p1 = new Pieza (1, 0, 0);
		Pieza p2 = new Pieza (2, 0, 1);
		Pieza p3 = new Pieza (3, 1, 1);
		Pieza p4 = new Pieza (0, 1, 0);
		
		Assert.assertEquals(p1.getValor(),1);
		Assert.assertEquals(p2.getValor(),2);
		Assert.assertEquals(p3.getValor(),3);
		Assert.assertEquals(p4.getValor(),0);
		
		Assert.assertEquals(p1.getFila(),0);
		Assert.assertEquals(p2.getFila(),0);
		Assert.assertEquals(p4.getFila(),1);
		
		Assert.assertEquals(p1.getColumna(),0);
		Assert.assertEquals(p3.getColumna(),1);
		Assert.assertEquals(p4.getColumna(),0);
		
	}
	
	
	
	@Test
	public void testCambiaPieza(){
		
		Pieza p1 = new Pieza (1, 0, 0);
		Pieza p2 = new Pieza (2, 0, 1);
		Pieza p3 = new Pieza (3, 1, 1);
		Pieza p4 = new Pieza (0, 1, 0);
		
		Assert.assertTrue(p1.getValor()==1);
		Assert.assertEquals(p1.getColumna(),0);
		Assert.assertEquals(p2.getColumna(),1);
		
		Pieza.cambiaPieza(p1, p2);
		
		Assert.assertTrue(p1.getValor()==2);
		Assert.assertEquals(p1.getValor(),2);
		Assert.assertEquals(p2.getValor(),1);
		
		
		
		
		Assert.assertEquals(p3.getFila(),1);
		Assert.assertEquals(p4.getFila(),1);
		
		Pieza.cambiaPieza(p3, p4);
		
		Assert.assertEquals(p3.getValor(),0);
		Assert.assertEquals(p4.getValor(),3);
		
		
	}

	@Test
	public void testObtenerValor(){
		
		Pieza p1 = new Pieza (1, 0, 0);
		
		Assert.assertEquals(p1.getValor(), 1);
		
		Assert.assertEquals(p1.toString(),"1");
		
		Pieza p2 = new Pieza (2, 0, 1);
		
		Assert.assertEquals(p2.toString(),"2");
		
	}
	
	
	
}
