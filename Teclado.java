//Sara Paloma Martínez-Tizón García BW0100 IWSM12
import java.util.Scanner;

public class Teclado {
    private static Scanner scs = new Scanner(System.in);

    public static int leerEntero(int menor, int mayor, String mensaje) {
        int numero = 0;
        boolean entradaValida;
        do {
            System.out.print(mensaje);
            if (scs.hasNextInt()) {
                numero = scs.nextInt();
                if (numero >= menor && numero <= mayor) {entradaValida = true;}
                else {entradaValida = false;}
            } else {
                entradaValida = false;
                scs.next();}
        } while (!entradaValida);
        scs.nextLine();
        return numero;
    }

	// ----------------------------------------------------------------------------------

    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        String cadena = scs.nextLine();
        return cadena;
    }

    // ---------------------------------------------------------------------------------

    public static char leerSiNo(String mensaje) {
        char resultado = ' ';
        boolean seguir = true;
        while(seguir) {
            System.out.print(mensaje);
            String entrada = scs.nextLine();
            if (entrada.length() == 1) {
                resultado = entrada.charAt(0);
                if (resultado == 's') { resultado = 'S';}
                else if (resultado == 'n') { resultado = 'N';}}
            if (resultado == 'S' || resultado == 'N') {
                seguir = false;
            }
        }
        return resultado;
    }
    }
