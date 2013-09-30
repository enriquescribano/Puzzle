package practica1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Clase para representar el tablero.
 * 
 * @author Carlos Gonzalez
 * @author Enrique Escribano
 */
public class Tablero {
	private Pieza tablero[][];
	private ArrayList<String> visitados;

	/**
	 * Constructor.
	 * 
	 * @param fichero direccion local del fichero con la posicion inicial del tablero
	 * @throws Exception
	 */
	public Tablero(String fichero) throws Exception {
		this.visitados = new ArrayList<String>();
		Reader reader = new FileReader(fichero);
		BufferedReader br = new BufferedReader(reader);
		ArrayList<String> piezas = new ArrayList<String>();
		String linea = null;
		do {
			linea = br.readLine();
			if (linea != null) {
				piezas.add(linea);
			}
		} while (linea != null);
		int nfilas = piezas.size();
		linea = piezas.get(0);
		String[] filas = linea.split(",");
		int ncol = filas.length;
		this.tablero = new Pieza[nfilas][ncol];
		for (int i = 0; i < nfilas; i++) {
			linea = piezas.get(i);
			filas = linea.split(",");
			for (int j = 0; j < filas.length; j++) {
				this.tablero[i][j] = new Pieza(Integer.parseInt(filas[j]), i, j);
			}
		}
	}

	/**
	 * Getter.
	 * 
	 * @return Pieza[][] tablero
	 */
	public Pieza[][] getTablero() {
		return this.tablero;
	}

	/**
	 * Setter.
	 * 
	 * @param tablero
	 */
	public void setTablero(Pieza tablero[][]) {
		this.tablero = tablero;
	}

	/**
	 * Getter.
	 * 
	 * @return ArrayList<String> con tableros ya visitados.
	 */
	public ArrayList<String> getVisitados() {
		return this.visitados;
	}

	/**
	 * Setter
	 * 
	 * @param visitados
	 */
	public void setVisitados(ArrayList<String> visitados) {
		this.visitados = visitados;
	}

	/**
	 * toString.
	 */
	public String toString() {
		String piezas = "";
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				String pieza = String.valueOf(tablero[i][j].toString());
				piezas = piezas.concat(pieza + ",");
			}
		}
		return piezas;
	}

	/**
	 *Imprime por la consola la situacion actual de un tablero.
	 */
	public void imprimeTablero() {
		System.out.println();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j].toString() + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Devuelve la pieza del espacio de un tablero.
	 * 
	 * @return Pieza pieza del espacio.
	 */
	public Pieza buscaEspacio() {
		Pieza espacio = null;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j].getValor() == 0) {
					espacio = tablero[i][j];
				}
			}
		}
		return espacio;
	}
	
	/**
	 * Realiza el movimiento dado.
	 * 
	 * @param movimiento a realizar.
	 */
	public void hazMovimiento(Movimiento mov) {
		Pieza p1 = this.tablero[mov.getFilaActual()][mov.getColActual()];
		Pieza p2 = this.tablero[mov.getFilaDestino()][mov.getColDestino()];
		Pieza.cambiaPieza(p1, p2);
	}

	/**
	 * Devuelve si ya se ha visitado la situacion actual del tablero.
	 * @return true si ya se ha visitado o false si no.
	 */
	public boolean visitado() {
		if (this.visitados.contains(this.toString())) {
			return true;
		}
		return false;
	}

	/**
	 * Añader la situacion actual del tablero a las visitadas.
	 * 
	 * @param tablero situacion a añadir a visitados.
	 */
	public void anadeVisitado(Tablero tablero) {
		ArrayList<String> visitados = this.getVisitados();
		visitados.add(tablero.toString());
	}
	
	/**
	 * Calcula la paridad del numero.
	 * 
	 * @param numero
	 * @return true si es impar, false si es par.
	 */
	private static boolean esImpar(int numero) {
		  if (numero%2!=0)
			  return true;
		  else
			  return false;
		}
	
	/**
	 * Devuelve el numero de inversiones del puzzle.
	 * Una inversión es cuando una pieza precede a otra pieza con un número más bajo en él.
	 * 
	 * @return inversiones
	 */
	private int inversiones(){
		String tab=this.toString();
		String[] piezas = tab.split(",");
		int[] casillas = new int[piezas.length];
		for(int x =0;x<piezas.length;x++){
			casillas[x]=Integer.parseInt(piezas[x]);
		}
		int inversiones=0;
		for(int i=0;i<casillas.length;i++){
			if(casillas[i]==0){
				continue;
			}
			for(int j =i;j<casillas.length;j++){
				if(casillas[j]<casillas[i] && casillas[j]!=0){
					inversiones++;
				}
			}
		}
		return inversiones;
	}
	
	/**
	 * Calcula si el tablero es resoluble.
	 * 
	 * @param tablero
	 * @return true si es resoluble, false si no lo es.
	 */
	public static boolean resoluble(Tablero tablero){
		Pieza[][] tab = tablero.getTablero();
		int nfila = tab.length;
		int ncol = tab[0].length;
		int inversiones = tablero.inversiones();
		if(esImpar(ncol)){
			return !esImpar(inversiones);
		}
		else{
			int fespacio=tablero.buscaEspacio().getFila();
			return esImpar(nfila-fespacio)==!esImpar(inversiones);
		}
	}
	
	/**
	 * Indica si el tablero ya está resuelto.
	 * 
	 * @param tab
	 * @return true si esta resuelto, false si no lo esta.
	 */
	public static boolean estaResuelto(Tablero tablero) {
		Pieza[][] tab = tablero.getTablero();
		Pieza actual;
		Pieza anterior = tab[0][0];
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				actual = tab[i][j];
				if (i == tab.length - 1 && j == tab[i].length - 1) {
					if (tab[i][j].getValor() == 0) {
						return true;
					}
				} else if (actual.getValor() < anterior.getValor()) {
					return false;
				}
				anterior = actual;
			}
		}
		return false;
	}
	
	private static int solucionParcial(Tablero tablero){
		int sol=0;
		int deseado=1;
		Pieza[][] tab = tablero.getTablero();
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				Pieza actual = tab[i][j];
				if(actual.getValor()==deseado){
					sol++;
				} else{
					return sol;
				}
				deseado++;
			}
		}
		return sol;
	}

	public static boolean resuelve(Tablero tablero){
		if (estaResuelto(tablero))
			return true;
		if(!resoluble(tablero))
			return false;
		Pieza[][] tab= tablero.getTablero();
		int nfilas = tab.length;
		for(int i=1;i<=nfilas-2;i++){
			System.out.println("fila"+i);
			resuelveFila(tablero, i);
		}
		resuelveFinal(tablero);
		return true;
		
	}
	
	private static void resuelveFila(Tablero tablero,int fila){
		int solParcial;
		int solParcialnueva;
		Pieza[][] tab= tablero.getTablero();
		int ncol = tab[0].length;
		tablero.anadeVisitado(tablero);
		Pieza espacio= tablero.buscaEspacio();
		ArrayList<Movimiento> movimientosHechos = new ArrayList<Movimiento>();
		Movimiento ultimo = new Movimiento(-1, -1, espacio.getFila(), espacio.getColumna());
		movimientosHechos.add(ultimo);
		boolean valido=false;
		while(solucionParcial(tablero)<fila*ncol){
			tablero.imprimeTablero();
			ultimo=movimientosHechos.get(movimientosHechos.size()-1);
			Movimiento[] movimientos = Movimiento.dameMovimientos(ultimo.getFilaDestino(), ultimo.getColDestino());
			for(Movimiento mov:movimientos){
				if (mov.esValido(tablero)) {
					solParcial= solucionParcial(tablero);
					tablero.hazMovimiento(mov);
					solParcialnueva=solucionParcial(tablero);
					if((solParcialnueva < solParcial)&&(solParcialnueva < (fila*ncol-2))){
						tablero.anadeVisitado(tablero);
						tablero.hazMovimiento(mov);//deshace
						continue;
					}
					if (!tablero.visitado()) {
						tablero.anadeVisitado(tablero);
						movimientosHechos.add(mov);
						ultimo=mov;
						valido=true;
						break;
					}
					else{
						tablero.hazMovimiento(mov);
					}
				}
				valido=false;
			}
			if(!valido){// si hemos llegado a una posicion sin ningun movimiento valido
				tablero.hazMovimiento(ultimo);
				movimientosHechos.remove(movimientosHechos.size()-1);
			}
		}
	}
	
	private static void resuelveFinal(Tablero tablero){
		Pieza[][] tab= tablero.getTablero();
		int nfila = tab.length;
		int ncol = tab[0].length;
		int solParcial=(nfila-2)*ncol;
		int solParcialnueva;
		tablero.anadeVisitado(tablero);
		Pieza espacio= tablero.buscaEspacio();
		ArrayList<Movimiento> movimientosHechos = new ArrayList<Movimiento>();
		Movimiento ultimo = new Movimiento(-1, -1, espacio.getFila(), espacio.getColumna());
		movimientosHechos.add(ultimo);
		boolean valido=false;
		while(!estaResuelto(tablero)){
			tablero.imprimeTablero();
			ultimo=movimientosHechos.get(movimientosHechos.size()-1);
			Movimiento[] movimientos = Movimiento.dameMovimientos(ultimo.getFilaDestino(), ultimo.getColDestino());
			for(Movimiento mov:movimientos){
				if (mov.esValido(tablero)) {
					tablero.hazMovimiento(mov);
					solParcialnueva=solucionParcial(tablero);
					if((solParcialnueva < solParcial)){
						tablero.hazMovimiento(mov);//deshace
						tablero.anadeVisitado(tablero);
						continue;
					}
					if (!tablero.visitado()) {
						tablero.anadeVisitado(tablero);
						movimientosHechos.add(mov);
						ultimo=mov;
						valido=true;
						break;
					}
					else{
						tablero.hazMovimiento(mov);
					}
				}
				valido=false;
			}
			if(!valido){// si hemos llegado a una posicion sin ningun movimiento valido
				tablero.hazMovimiento(ultimo);
				movimientosHechos.remove(movimientosHechos.size()-1);
			}
		}
	}
	
	public static boolean resuelveRecursivo(Tablero tablero) {
		if (estaResuelto(tablero))
			return true;
		if(!resoluble(tablero))
			return false;
		Pieza[][] tab= tablero.getTablero();
		int nfilas = tab.length;
		for(int x=1;x<=nfilas-2;x++){
			System.out.println("fila"+x);
			Pieza espacio = tablero.buscaEspacio();
			int i = espacio.getFila();
			int j = espacio.getColumna();
			recursivoFila(tablero,  new Movimiento(-1, -1, i, j), x);
		}
		Pieza espacio = tablero.buscaEspacio();
		int i = espacio.getFila();
		int j = espacio.getColumna();
		return recursivoFinal(tablero, new Movimiento(-1, -1, i, j));
	}
	
	private static boolean recursivoFila(Tablero tablero,Movimiento movimiento,int fila) {
		Pieza[][] tab= tablero.getTablero();
		int ncol = tab[0].length;
		if (solucionParcial(tablero)>=fila*ncol)
			return true;
		Movimiento[] movimientos = Movimiento.dameMovimientos(movimiento.getFilaDestino(), movimiento.getColDestino());
		int solParcial;
		int solParcialnueva;
		for (int x = 0; x < movimientos.length; x++) {
			Movimiento mov = movimientos[x];
			solParcial=solucionParcial(tablero);
			if (mov.esValido(tablero)) {
				tablero.hazMovimiento(mov);
				solParcialnueva=solucionParcial(tablero);
				if((solParcialnueva < solParcial)&&(solParcialnueva < (fila*ncol-2))){
					tablero.anadeVisitado(tablero);
					tablero.hazMovimiento(mov);//deshace
					continue;
				}
				if (!tablero.visitado()) {
					tablero.imprimeTablero();
					tablero.anadeVisitado(tablero);
					if(recursivoFila(tablero, mov,fila)){
						return true;
					}
				} else {
					tablero.hazMovimiento(mov);
				}
			} else {
			}
		}
		tablero.hazMovimiento(movimiento);
		return false;
	}
	
	private static boolean recursivoFinal(Tablero tablero,Movimiento movimiento) {
		Pieza[][] tab= tablero.getTablero();
		int nfila = tab.length;
		int ncol = tab[0].length;
		int solParcial=(nfila-2)*ncol;
		int solParcialnueva;
		if (estaResuelto(tablero))
			return true;
		Movimiento[] movimientos = Movimiento.dameMovimientos(movimiento.getFilaDestino(), movimiento.getColDestino());
		for (int x = 0; x < movimientos.length; x++) {
			Movimiento mov = movimientos[x];
			if (mov.esValido(tablero)) {
				tablero.hazMovimiento(mov);
				solParcialnueva=solucionParcial(tablero);
				if(solParcialnueva < solParcial){
					tablero.anadeVisitado(tablero);
					tablero.hazMovimiento(mov);//deshace
					continue;
				}
				if (!tablero.visitado()) {
					tablero.anadeVisitado(tablero);
					if(recursivoFinal(tablero, mov)){
						return true;
					}
				} else {
					tablero.hazMovimiento(mov);
				}
			} else {
			}
		}
		tablero.hazMovimiento(movimiento);
		return false;
	}
}