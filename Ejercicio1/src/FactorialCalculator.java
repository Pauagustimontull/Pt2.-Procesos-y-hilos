class FactorialCalculator extends Thread {
    private int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        long factorial = calculateFactorial(number);
        System.out.println("Factorial of " + number + ": " + factorial);
    }

    private long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}