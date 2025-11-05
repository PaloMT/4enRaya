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
                else {
                    System.out.println("Error: El numero debe estar entre " + menor + " y " + mayor + ".");
                    entradaValida = false;
                }
            } else {
                System.out.println("Error: Debe introducir un numero entero.");
                entradaValida = false;
                scs.next();
            }} while (!entradaValida);
        scs.nextLine();
        return numero;
    }

	// ----------------------------------------------------------------------------------

    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        String cadena = scs.nextLine();
        return cadena;
    }

    // ----------------------------------------------------------------------------------

    public static char leerSiNo(String mensaje) {
        char decision;
        do{
            System.out.print(mensaje);
            decision = scs.next().charAt(0);
            if (decision == 's') return 'S';
            if (decision == 'n') return 'N';
        }while(decision != 'S' && decision != 'N');

        return decision;
    }
}
