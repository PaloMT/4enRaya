//Sara Paloma Martínez-Tizón García BW0100 IWSM12
public class Tablero {
    public static final int COLUMNAS = 7;
    public static final int FILAS = 6;
    public static final char VACIA = ' ';

    private char[][] fichas;
    private int numFichasColocadas;

    public Tablero(){
        fichas = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++){
            for (int j=0; j<COLUMNAS; j++){
                fichas [i][j] = VACIA;
            }}
        numFichasColocadas = 0;
    }
    // ----------------------------------------------------------------------------------

    public void colocar(int columna, char ficha) {
        int libre = primeraLibre(columna);
        fichas [libre][columna] = ficha;
        numFichasColocadas ++;

    }

    // ----------------------------------------------------------------------------------

    public int primeraLibre(int columna) {
        for (int i = FILAS - 1; i >= 0; i--) {
            if (fichas[i][columna] == VACIA) {
                return i;
            }
        }
        return -1;
    }

    // ----------------------------------------------------------------------------------

    public boolean completo() {
        if (numFichasColocadas == FILAS*COLUMNAS) return true;
        return false;
    }

    // ----------------------------------------------------------------------------------

    public void mostrar() {
        System.out.println("TABLERO:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(this.fichas[i][j] + " ");
            }
            System.out.println();
        }
        for (int j = 0; j < COLUMNAS; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    // ----------------------------------------------------------------------------------

    public char getFicha(Coordenada coordenada) {
        char ficha = fichas[coordenada.getFila()][coordenada.getColumna()];
        return ficha;
    }

    // ----------------------------------------------------------------------------------

    public boolean enTablero(Coordenada coordenada) {
        boolean result = false;
        if ((coordenada.getFila()<FILAS && coordenada.getFila()>=0 ) && (coordenada.getColumna()<COLUMNAS && coordenada.getColumna()>=0)){
           result = true;
        }
        return result;
    }

    // ----------------------------------------------------------------------------------

    public boolean hay4EnLinea(int columna) {
        int filaPieza = -1;
        int i = 0;
        boolean encontrada = false;
        while (i < FILAS && !encontrada) {
            if (fichas[i][columna] != VACIA) {
                filaPieza = i;
                encontrada = true;}
            i++;
        }

        if (filaPieza == -1) {
            return false;
        }

        Coordenada origen = new Coordenada(filaPieza, columna);
        char ficha = this.getFicha(origen);

        // Horizontal
        int contadorHorizontal = 1;
        Coordenada actual = origen.izquierda();
        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorHorizontal++;
            actual = actual.izquierda();
        }
        actual = origen.derecha();

        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorHorizontal++;
            actual = actual.derecha();
        }
        // Vertical
        int contadorVertical = 1;
        actual = origen.abajo();
        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorVertical++;
            actual = actual.abajo();
        }
        // Diagonal 1
        int contadorDiagonal1 = 1;
        actual = origen.arriba().izquierda();
        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorDiagonal1++;
            actual = actual.arriba().izquierda();
        }
        actual = origen.abajo().derecha();
        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorDiagonal1++;
            actual = actual.abajo().derecha();
        }

        // Diagonal 2
        int contadorDiagonal2 = 1;
        actual = origen.arriba().derecha();
        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorDiagonal2++;
            actual = actual.arriba().derecha();
        }
        actual = origen.abajo().izquierda();
        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorDiagonal2++;
            actual = actual.abajo().izquierda();
        }
        return (contadorDiagonal2 >= 4 || contadorDiagonal1 >= 4 || contadorVertical >= 4 || contadorHorizontal >= 4);
    }
}
