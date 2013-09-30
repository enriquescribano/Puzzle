package practica1;

/**
 * Clase para representar los movimientos de piezas del tablero.
 * 
 * @author Carlos Gonzalez
 * @author Enrique Escribano
 */
public class Movimiento {
	private int filaActual;
	private int colActual;
	private int filaDestino;
	private int colDestino;

	/**
	 * Contructor.
	 * 
	 * @param fa fila actual de una pieza.
	 * @param ca columna actual de una pieza.
	 * @param fd fila destino de una pieza.
	 * @param cd columna destino de una pieza.
	 */
	public Movimiento(int fa, int ca, int fd, int cd) {
		this.filaActual = fa;
		this.colActual = ca;
		this.filaDestino = fd;
		this.colDestino = cd;
	}

	/**
	 * Getter.
	 * 
	 * @return filaActual
	 */
	public int getFilaActual() {
		return filaActual;
	}

	/**
	 * Setter.
	 * 
	 * @param filaActual
	 */
	public void setFilaActual(int filaActual) {
		this.filaActual = filaActual;
	}

	/**
	 * Getter.
	 * 
	 * @return columnaActual
	 */
	public int getColActual() {
		return colActual;
	}

	/**
	 * Setter.
	 * 
	 * @param colActual
	 */
	public void setColActual(int colActual) {
		this.colActual = colActual;
	}

	/**
	 * Getter.
	 * 
	 * @return filaDestino.
	 */
	public int getFilaDestino() {
		return filaDestino;
	}

	/**
	 * Setter.
	 * 
	 * @param filaDestino
	 */
	public void setFilaDestino(int filaDestino) {
		this.filaDestino = filaDestino;
	}

	/**
	 * Getter.
	 * 
	 * @return columnaDestino
	 */
	public int getColDestino() {
		return colDestino;
	}

	/**
	 * Setter.
	 * 
	 * @param colDestino
	 */
	public void setColDestino(int colDestino) {
		this.colDestino = colDestino;
	}

	/**
	 * Metodo que devuelve todos los posibles movimientos de una pieza ya sean validos o no.
	 * 
	 * @param i fila de la pieza a mover.
	 * @param j columna de la pieza a mover.
	 * @return
	 */
	public static Movimiento[] dameMovimientos(int i, int j) {
		Movimiento m1 = new Movimiento(i, j, i, j + 1);
		Movimiento m2 = new Movimiento(i, j, i + 1, j);
		Movimiento m3 = new Movimiento(i, j, i - 1, j);
		Movimiento m4 = new Movimiento(i, j, i, j - 1);
		Movimiento[] mov = { m1, m2, m3, m4 };
		return mov;
	}
	
	/**
	 * Indica si el movimiento es realizable teniendo en cuenta las dimensiones del tablero.
	 * 
	 * @param tablero tablero en el que se va a efectuar el movimiento.
	 * @return true si el movimiento es válido, false si alguna de las filas o columnas estan fuera de los limites del tablero.
	 */
	public boolean esValido(Tablero tablero) {
		if (this.colDestino >= 0 && this.colDestino < tablero.getTablero()[0].length) {
			if (this.filaDestino >= 0 && this.filaDestino < tablero.getTablero().length) {
				return true;
			}
		}
		return false;
	}
}
