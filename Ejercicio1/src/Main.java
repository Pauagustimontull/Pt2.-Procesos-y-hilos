import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of factorials to calculate: ");
        int count = scanner.nextInt();

        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int number = scanner.nextInt();
            FactorialCalculator calculator = new FactorialCalculator(number);
            threads[i] = calculator;
            calculator.start();
            try {
                calculator.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All calculations completed.");

        scanner.close();
    }
}