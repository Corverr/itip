public class ArraySumMultiThread {
    private static long firstHalfSum;
    private static long secondHalfSum;

    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            Thread firstThread = new Thread(() -> {
                for (int i = 0; i < numbers.length / 2; i++) {
                    firstHalfSum += numbers[i];
                }
            });

            Thread secondThread = new Thread(() -> {
                for (int i = numbers.length / 2; i < numbers.length; i++) {
                    secondHalfSum += numbers[i];
                }
            });

            firstThread.start();
            secondThread.start();

            firstThread.join();
            secondThread.join();

            long totalSum = firstHalfSum + secondHalfSum;

            System.out.println("Сумма первой половины: " + firstHalfSum);
            System.out.println("Сумма второй половины: " + secondHalfSum);
            System.out.println("Общая сумма массива: " + totalSum);

        } catch (InterruptedException e) {
            System.out.println("Поток был прерван!");
            e.printStackTrace();
        }
    }
}