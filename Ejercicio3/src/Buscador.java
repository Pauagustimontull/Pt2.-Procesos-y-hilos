import java.util.Random;
import java.util.Scanner;
public class Buscador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del vector: ");
        int tamañoVector = scanner.nextInt();

        System.out.print("Ingrese el valor a buscar: ");
        int valorABuscar = scanner.nextInt();

        System.out.print("Ingrese el número de hilos: ");
        int numeroHilos = scanner.nextInt();

        if (tamañoVector <= 0 || numeroHilos <= 0 || tamañoVector < numeroHilos) {
            System.out.println("Por favor, introduzca valores válidos para los argumentos.");
            return;
        }

        int[] vector = new int[tamañoVector];

        for (int i = 1; i < tamañoVector; i++) {
            vector[i] = i; 
        }

        int elementosPorHilo = tamañoVector / numeroHilos;
        System.out.println(elementosPorHilo);
        // Crear hilos
        BuscadorThread[] hilos = new BuscadorThread[numeroHilos];
        for (int i = 0; i < numeroHilos - 1; i++) {
            hilos[i] = new BuscadorThread(vector, i * elementosPorHilo, (i + 1) * elementosPorHilo - 1, valorABuscar, i);
            hilos[i].start();
        }

        // Último hilo
        hilos[numeroHilos - 1] = new BuscadorThread(vector, (numeroHilos - 1) * elementosPorHilo, tamañoVector - 1, valorABuscar, numeroHilos);
        hilos[numeroHilos - 1].start();

        // Proceso padre
        for (int i = (numeroHilos - 1) * elementosPorHilo; i < tamañoVector; i++) {
            if (vector[i] == valorABuscar) {
                System.out.println("Proceso padre encontró el valor " + valorABuscar + " en la posición " + i);
                return;
            }
        }

        // Esperar a que todos los hilos terminen
        for (BuscadorThread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostrar mensaje si el valor no fue encontrado
        
    }
}