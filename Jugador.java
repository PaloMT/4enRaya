//Sara Paloma Martínez-Tizón García BW0100 IWSM12
public class Jugador {
    private char ficha;

    public Jugador(char ficha) {
        this.ficha = ficha;
    }

    // ----------------------------------------------------------------------------------

    public char getFicha() {
        return ficha;
    }

    // ----------------------------------------------------------------------------------

    public int ponerFicha(Tablero tablero) {
        int columna;
        boolean columnaValida;
        do {
            columnaValida = true;
            columna = Teclado.leerEntero(-1, Tablero.COLUMNAS - 1, "Introduzca el número de columna [0-6] o -1 para salir: ");
            if ((columna != -1) && (tablero.primeraLibre(columna)) == -1 ) {
                    System.out.println("Columna completa. Inténtelo de nuevo.");
                    columnaValida = false;}
        } while (columna != -1 && !columnaValida);
        return columna;
    }
}
