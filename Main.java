import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String opcion="";

        while(!opcion.equals("s")){
            System.out.print("Elige un ejercicio (1 o 2 o s para salir): ");
            opcion = sc.next();

            switch (opcion) {
                case "1"->{
                    ejercicio1();
                }
                case "2"->{
                    ejercicio2();
                }
                case "s"->{
                    System.out.println("Adios");
                }
                default -> {
                    System.out.println("Intentalo de nuevo");
                }
            }
        }


    }

    public static void ejercicio1(){
        System.out.println("Crea un programa que solicite al usuario una frase y realice las siguientes operaciones usando String:\n" +
                "\n" +
                "Contar cuántos caracteres tiene la frase (excluyendo espacios). Haz una función que se llame cuentaCaracteres\n" +
                "Contar cuántas veces aparece una vocal específica, elegida por el usuario. Haz una función que se llame cuentaVocales\n" +
                "Hay que controlar que la frase no sea vacía y que el usuario meta una vocal y no otro carácter.");

        Scanner sc = new Scanner(System.in);
        String frase="";
        String vocal="";
        String vocales="(?=.*[aeiou])";

        while (frase.isEmpty() && !vocal.matches(vocales)) {
            System.out.print("Introduce una frase: ");
            frase = sc.nextLine();

            System.out.print("Introduce un vocal: ");
            vocal = sc.nextLine();
        }



        System.out.println("La frase tiene " + cuentaCaracteres(frase) + " caracteres, excluyendo espacios.");
        System.out.println("La vocal " + vocal + " aparece " + cuentaVocales(frase,vocal) + " veces");


    }

    private static int cuentaCaracteres(String frase){
        String sinEspacios=frase.replaceAll(" ","");

        int cuentaCaracteres= sinEspacios.length();
        return cuentaCaracteres;
    }
    private static int cuentaVocales(String frase, String vocal){
        char stringAchar=vocal.charAt(0);
        int contadorVocales=0;

        for(int i=0; i<frase.length(); i++){
            if(stringAchar==frase.charAt(i)){
                contadorVocales++;
            }
        }
        return contadorVocales;
    }


    public static void ejercicio2(){
        System.out.println("El objetivo es llegar a la salida (ubicada en la celda 3,3) desde la posición inicial (ubicada en la celda 0,0).\n" +
                "El jugador puede moverse arriba, abajo, izquierda o derecha introduciendo comandos (w, s, a, d). Por lo que habrá que preguntarle al jugador qué movimiento quiere hacer.\n" +
                "Cada vez que se mueve hay que darle una pista para guiarlo hacia la salida. Los mensajes serán (puedes añadir/modificar):\n" +
                "Pista: La salida está hacia arriba y a la derecha.\n" +
                "Pista: La salida está hacia arriba.\n" +
                "Pista: La salida está hacia la derecha.\n" +
                "Pista: Te estás alejando.\n" +
                "El jugador tiene un número limitado de movimientos (10). Si no llega a la salida, pierde.\n" +
                "Haz uso de la función darPista.\n" +
                "// Método para mostrar las pistas según la posición\n" +
                "\n" +
                "public static void darPista(int fila, int columna) {...");

        Scanner sc = new Scanner(System.in);

        //Posición inicial
        int jugadorFila = 0;
        int jugadorColumna = 0;

        //Posición final
        Final int final_fila = 3;
        Final int final_columna = 3;

        int movimientosRestantes = 10;

        System.out.println("¡Bienvenido al juego 'Escapa del Laberinto'!\n" + "Tu objetivo es llegar a la salida en la posición (3,3).\n");
        System.out.println("Usa las teclas 'w' (arriba), 's' (abajo), 'a' (izquierda), 'd' (derecha) para moverte.");

        while(jugadorFila!=final_fila || jugadorColumna!=final_columna && movimientosRestantes>0){
            System.out.print("Introduce un comando: ");
            char comando= sc.next().charAt(0);

            if (comando=='w'){
                jugadorFila++;
                darPista(jugadorFila,jugadorColumna);
            }else if (comando=='s'){
                jugadorFila--;
                darPista(jugadorFila,jugadorColumna);
            }else if (comando=='a'){
                jugadorColumna--;
                darPista(jugadorFila,jugadorColumna);
            }else if (comando=='d'){
                jugadorColumna++;
                darPista(jugadorFila,jugadorColumna);
            }

            movimientosRestantes--;
            System.out.println("Te quedan " + movimientosRestantes + " movimientos.");

        }

        if(jugadorFila==3 && jugadorColumna==3){
            System.out.println("Has ganado! :D");
        }else if(movimientosRestantes==0 && jugadorFila!=3 || jugadorColumna!=3){
            System.out.println("Has perdido :(");
        }

    }


    public static void darPista(int fila, int columna) {
        String pistaFila="";
        String pistaColumna="";

        if (fila>3){
            pistaFila="hacia abajo";
        } else if (fila<3) {
            pistaFila="hacia arriba";
        }

        if (columna>3){
            pistaColumna=" a la izquierda";
        }else if (columna<3) {
            pistaColumna=" a la derecha";
        }

        if (fila==3 && columna==3){
            pistaFila= "aqui";
            pistaColumna="";
        }

        System.out.println("La salida esta " + pistaFila + pistaColumna);
    }

}
