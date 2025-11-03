
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

    public int primeraLibre(int columna) {
        int i = FILAS -1;
        while (fichas [i][columna] == VACIA); {
            if (fichas [i][columna] == VACIA){
                i--;
            }
        }
        return i;
    }

    public boolean completo() {
        if (numFichasColocadas ==36) return true;
        else return false;
    }

    public void mostrar() {
        System.out.println("TABLERO:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(this.fichas[i][j]);
            }
            System.out.println();
        }
        for (int j = 0; j < COLUMNAS; j++) {System.out.print(j + " ");}
        System.out.println();
    }

    public char getFicha(Coordenada coordenada) {
        char ficha = fichas[coordenada.getFila()][coordenada.getColumna()];
        return ficha;
    }

    public boolean enTablero(Coordenada coordenada) {
        boolean result = false;
        if ((coordenada.getFila()<FILAS && coordenada.getFila()<=0 ) && (coordenada.getColumna()<COLUMNAS && coordenada.getColumna()<=0)){
           result = true;
        }
        return result;
    }

    public boolean hay4EnLinea(int columna) {
        // Revissar esto, si explota si no esta dejarlo
        if (this.numFichasColocadas <= 6) {
            return false;
        }

        int filaPieza = primeraLibre(columna);
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
            actual = actual.derecha(); // Seguimos moviéndonos a la derecha
        }
        if (contadorHorizontal >= 4) return true;

        // Vertical
        int contadorVertical = 1;
        actual = origen.abajo();
        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorVertical++;
            actual = actual.abajo();
        }
        if (contadorVertical >= 4) return true;

        // Diagonal 1
        int contadorDiagonal1 = 1;
        actual = origen.arriba().izquierda();
        // Bucle hacia Arriba-Izquierda
        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorDiagonal1++;
            actual = actual.arriba().izquierda();
        }
        actual = origen.abajo().derecha();
        while (enTablero(actual) && getFicha(actual) == ficha) {
            contadorDiagonal1++;
            actual = actual.abajo().derecha();
        }
        if (contadorDiagonal1 >= 4) return true;

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
        if (contadorDiagonal2 >= 4) return true;

        return false;
    }



}
