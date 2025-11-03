public class Conecta4 {
    private Tablero tablero;
    private Jugador jugador1, jugador2;
    private int turno;

    public Conecta4() {
        tablero= new Tablero();
        jugador1= new Jugador('X');
        jugador2= new Jugador('O');
        turno =1;

    }

    public static void main(String[] args) {
        Conecta4 partida = new Conecta4();
        partida.jugar();
    }

    // ----------------------------------------------------------------------------------
    public void jugar() {
        char opcion = Teclado.leerSiNo("Desea recuperar la partida? (S/N): ");
        if (opcion == 'S' || opcion == 's') {
            String nombre = Teclado.leerString("Ingrese el nombre del archivo: ");
            this.recuperarPartida(nombre); //esta en esta clase
        }
        tablero.mostrar();
        boolean finalPartida = false;
        while(!finalPartida) {
            Jugador jugador; // es solamente una referencia que apunta al jugador q juega en cada momento
            if (turno == 1){
                jugador = jugador1;}
            else {
                jugador = jugador2;}

            System.out.println("Le toca poner al jugador con ficha "+jugador.getFicha());
            int columna = jugador.ponerFicha(tablero);
            if (columna == -1) {
                char opcion1 = Teclado.leerSiNo("¿Deseas guardar la partida? (S/N): ");
                if (opcion == 'S' || opcion == 's') {
                    String ruta = Teclado.leerString("Introduzca un nombre para la partida: ");
                    guardarPartida(ruta);
                    finalPartida = true;
                }
            } else {
                tablero.colocar(columna, jugador.getFicha());

                tablero.mostrar();

                if(tablero.hay4EnLinea(columna)) {
                    System.out.println("HA GANADO EL JUGADOR CON FICHA "+jugador.getFicha());
                    finalPartida = true;
                } else if(tablero.completo()){
                    System.out.println("PARTIDA EN TABLAS");
                    finalPartida = true;
                }
            }
            turno = turno == 1 ? 2 : 1;
        }
    }

    public void guardarPartida(String ruta) {
        // TODO iteración 4
    }

    public void recuperarPartida(String ruta) {
        // TODO iteración 4
    }


}