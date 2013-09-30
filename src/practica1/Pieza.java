package practica1;

/**
 * Clase para representar las piezas del tablero.
 * 
 * @author Carlos Gonzalez
 * @author Enrique Escribano
 */
public class Pieza {
	private int valor;
	private int[] posicion;

	/**
	 * 
	 * @param valor valor de la pieza.
	 * @param fila fila que ocupa la pieza en el tablero.
	 * @param columna columna que ocupa la pieza en el tablero.
	 */
	public Pieza(int valor,int fila,int columna){
		this.valor=valor;
		this.posicion=new int[2];
		this.posicion[0]=fila;
		this.posicion[1]=columna;
	}
	
	/**
	 * Getter.
	 * @return valor.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Setter.
	 * @param valor.
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * Getter.
	 * @return int[]
	 */
	public int[] getPosicion() {
		return posicion;
	}
	
	/**
	 * Getter.
	 * @return fila.
	 */
	public int getFila() {
		return posicion[0];
	}

	/**
	 * Getter.
	 * @return columna.
	 */
	public int getColumna() {
		return posicion[1];
	}
	
	/**
	 * toString.
	 */
	public String toString(){
		return String.valueOf(this.valor);
	}
	
	/**
	 * Metodo que intercambia el valor de dos piezas.
	 * 
	 * @param p1 pieza a intercambiar.
	 * @param p2 pieza a intercambiar.
	 */
	public static void cambiaPieza(Pieza p1,Pieza p2){
		int a = p1.getValor();
		p1.setValor(p2.getValor());
		p2.setValor(a);
	}

}
