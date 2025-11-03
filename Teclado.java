import java.util.Scanner;

public class Teclado {


    public static int leerEntero( int menor, int mayor, String mensaje) {
        Scanner scs = new Scanner(System.in);
        int numero = 0;
        do {System.out.print(mensaje);
            if (!scs.hasNextInt()){
                leerEntero( menor, mayor, mensaje);
            }
            else numero = scs.nextInt();

        } while ((numero < menor || numero > mayor) && !scs.hasNextInt());

        return numero;}

	// ----------------------------------------------------------------------------------

    public static String leerString(String mensaje) {
        Scanner scs = new Scanner(System.in);
        String cadena;
        System.out.println(mensaje);
        cadena = scs.nextLine();
        return cadena;
    }

    // ----------------------------------------------------------------------------------

    public static char leerSiNo(String mensaje) {
        Scanner scs = new Scanner(System.in);
        char decision;
        do{
            System.out.print(mensaje);
            decision = scs.next().charAt(0);
        }while(decision != 'S' && decision != 'N' && decision != 's' && decision != 'n');
        if (decision == 's') return 'S';
        if (decision == 'n') return 'N';
        return decision;
    }
}
