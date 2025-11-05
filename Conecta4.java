import java.io.*;
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

    // ----------------------------------------------------------------------------------

    public static void main(String[] args) {
        Conecta4 partida = new Conecta4();
        partida.jugar();
    }

    // ----------------------------------------------------------------------------------

    public void jugar() {
        char opcion = Teclado.leerSiNo("Desea recuperar la partida? (S/N): ");
        if (opcion == 'S') {
            String nombre = Teclado.leerString("Ingrese el nombre del archivo: ");
            this.recuperarPartida(nombre); //esta en esta clase
        }
        tablero.mostrar();
        boolean finalPartida = false;
        while(!finalPartida) {
            Jugador jugador;
            if (turno == 1){
                jugador = jugador1;}
            else {
                jugador = jugador2;}

            System.out.println("Le toca poner al jugador con ficha "+jugador.getFicha());
            int columna = jugador.ponerFicha(tablero);

            if (columna == -1) {
                char opcion1 = Teclado.leerSiNo("¿Deseas guardar la partida? (S/N): ");
                if (opcion1 == 'S') {
                    String ruta = Teclado.leerString("Introduzca un nombre para la partida: ");
                    guardarPartida(ruta);}
                finalPartida = true;
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
                turno = (turno == 1) ? 2 : 1;
            }
        }
    }

    // ----------------------------------------------------------------------------------

    public void guardarPartida(String ruta) {
        PrintWriter in = null;
        try {
            in = new PrintWriter(new FileWriter(ruta));
            in.println(this.turno);
            for (int j = 0; j < Tablero.COLUMNAS; j++) {
                for (int i = Tablero.FILAS - 1; i >= 0; i--) {
                    Coordenada cordenada = new Coordenada(i, j);
                    char ficha = tablero.getFicha(cordenada);
                    if (ficha != Tablero.VACIA) {
                        in.println(j + " " + ficha);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR AL GUARDAR LA PARTIDA" + e.getMessage());
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
    }

    // ----------------------------------------------------------------------------------

    public void recuperarPartida(String ruta) {
        BufferedReader out = null;
        try {
            out = new BufferedReader(new FileReader(ruta));
            String linea = out.readLine();
            this.turno = Integer.parseInt(linea);
            while ((linea = out.readLine()) != null) {
                String[] partes = linea.split(" ");
                int columna = Integer.parseInt(partes[0]);
                char ficha = partes[1].charAt(0);
                tablero.colocar(columna, ficha);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException e) {
            System.out.println("Error, no haa diso posible recuperar la partida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error, fichero corrupto: " + e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero: "+e.getMessage());
            }
        }
    }


}