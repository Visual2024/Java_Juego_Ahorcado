import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Juego del ahorcado

        Scanner scanner = new Scanner(System.in);

        String palabraOculta = "Transformacion";
        char[] letrasAdivinadas = new char[palabraOculta.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        int intentos = 0;
        int maxIntentos = 10;
        boolean palabraEncontrada = false;

        System.out.println("¡Bienvenido al juego del ahorcado!");

        while (intentos < maxIntentos && !palabraEncontrada) {
            System.out.println("\nIntento " + (intentos + 1) + " de " + maxIntentos);
            System.out.print("Palabra: ");
            System.out.println(letrasAdivinadas);
            System.out.print("Ingresa una letra: ");
            String entrada = scanner.nextLine();

            if (entrada.length() != 1) {
                System.out.println("Por favor, ingresa solo una letra.");
                continue;
            }

            char letra = entrada.charAt(0);

            boolean letraEncontrada = false;
            for (int i = 0; i < palabraOculta.length(); i++) {
                if (palabraOculta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraEncontrada = true;
                }
            }

            if (letraEncontrada) {
                System.out.println("¡Letra encontrada!");
            } else {
                System.out.println("Letra no encontrada.");
                intentos++;
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraOculta)) {
                palabraEncontrada = true;
            }
        }

        if (palabraEncontrada) {
            System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraOculta);
        } else {
            System.out.println("\nLo siento, has agotado todos los intentos. La palabra era: " + palabraOculta);
        }

        scanner.close();
    }
}