
public class Coordenada {

	private int fila;
	private int columna;


	// ----------------------------------------------------------------------------------

	public Coordenada(int fila, int columna) {
		this.fila = fila;
        this.columna = columna;
	}

	// ----------------------------------------------------------------------------------

	public int getFila() {
		return fila;
	}

	// ----------------------------------------------------------------------------------

	public int getColumna() {
		return columna;
	}

	// ----------------------------------------------------------------------------------

	public Coordenada derecha() {
        Coordenada coDerecha = new Coordenada(fila,columna+1);
		return coDerecha; // Eliminar esta línea
	}

	public Coordenada izquierda() {
        Coordenada coIzquierda = new Coordenada(fila,columna-1);
		return coIzquierda;
	}

	public Coordenada arriba() {
        Coordenada coArriba = new Coordenada(fila-1,columna);
		return coArriba;
	}

	public Coordenada abajo() {
        Coordenada coAbajo = new Coordenada(fila+1,columna);
		return coAbajo;
	}
}
