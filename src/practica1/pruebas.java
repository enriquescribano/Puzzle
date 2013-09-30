package practica1;

import java.util.ArrayList;

public class pruebas {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Tablero t = new Tablero("prueba4x4.txt");
		t.imprimeTablero();
		System.out.println("resuelto: "+t.estaResuelto(t));
		System.out.println("resoluble: "+t.resoluble(t));		
//		System.out.println(t.toString());	
		
		
		
//		t.imprimeTablero();
		System.out.println("resoluble "+t.resoluble(t));
//		t.resuelve(t);
//		t.termina4(t);
		Tablero.resuelveRecursivo(t);
//		Tablero.resuelve(t);
//		t.resuelveFila(t, 0);
		t.imprimeTablero();
	}

}