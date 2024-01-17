import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of powers of 2 to calculate: ");
        int count = scanner.nextInt();

        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter exponent for 2^" + i + ": ");
            int exponent = scanner.nextInt();
            PowerOfTwoCalculator calculator = new PowerOfTwoCalculator(exponent);
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