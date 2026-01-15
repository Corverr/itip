public class ArrayAverage {
    public static void main(String[] args) {
        int[] array= {1, 2, 3, 4, 5, 6};
        int sum=0;

        try {
            for (int i=0; i<10; i++) {
                sum+= array[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(sum/ array.length);
    }
}
