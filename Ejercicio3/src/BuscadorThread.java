import java.util.Random;
import java.util.Scanner;
class BuscadorThread extends Thread {
    private final int[] vector;
    private final int start;
    private final int end;
    private final int target;
    private int numhilo = 0;

    public BuscadorThread(int[] vector, int start, int end, int target, int numhilo) {
        this.vector = vector;
        this.start = start;
        this.end = end;
        this.target = target;
        this.numhilo = numhilo;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (vector[i] == target) {
                System.out.println("Hilo " + numhilo + " encontró el valor " + target + " en la posición " + Thread.currentThread().getId());
                return;
            }
        }
    }
}