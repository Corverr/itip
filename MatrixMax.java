public class MatrixMax {
    private static int[] maxValues;

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {1, 5, 3, 8},
                {9, 2, 7, 4},
                {6, 11, 35, 2},
                {3, 4, 6, 10}
        };

        maxValues = new int[matrix.length];
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                int max = matrix[row][0];
                for (int value : matrix[row]) {
                    if (value > max) max = value;
                }
                maxValues[row] = max;
            });
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        int globalMax = maxValues[0];
        for (int value : maxValues) {
            if (value > globalMax) globalMax = value;
        }

        System.out.println("Максимальный элемент: " + globalMax);
    }
}