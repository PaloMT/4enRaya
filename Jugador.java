public class Jugador {
    private char ficha;

    public Jugador(char ficha) {
        this.ficha = ficha;
    }

    public char getFicha() {
        return ficha;
    }

    public int ponerFicha(Tablero tablero) {
        int columna = 0;
        do{
            columna = Teclado.leerEntero(0, Tablero.COLUMNAS, "Introduzca el número de columna [0, 6] o -1 para salir: ");
            if (columna >= 0 && columna <= Tablero.COLUMNAS) {
                if (tablero.primeraLibre(columna) == -1) {
                    System.out.println("Columna completa");
                }
                tablero.colocar(columna, ficha);
            }
        } while (columna >= 0 && columna <= Tablero.COLUMNAS && tablero.primeraLibre(columna) == -1);
        return columna;
    }
}
