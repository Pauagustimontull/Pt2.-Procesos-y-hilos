class PowerOfTwoCalculator extends Thread {
    private int exponent;

    public PowerOfTwoCalculator(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public void run() {
        long result = calculatePowerOfTwo(exponent);
        System.out.println("2^" + exponent + ": " + result);
    }

    private long calculatePowerOfTwo(int exp) {
        return (long) Math.pow(2, exp);
    }
}
