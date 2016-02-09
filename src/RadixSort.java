import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {

        int arr[] = {52, 46, 34, 22, 11};
        System.out.println("Radix Sort starts" + Arrays.toString(arr));
        doRadixSorting(arr);
        System.out.println("Radix Sort Ends" + Arrays.toString(arr));
    }

    public static void doRadixSorting(int[] src) {
        int n = src.length;
        int max = getMax(src, n);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(src, max, exp);
        }
    }

    /**
     * Radix sort internally uses count sort to sort the values
     * @param src
     * @param totNum
     * @param exp
     */
    public static void countingSort(int[] src, int totNum, int exp) {

        System.out.println("Before the count sort:" + Arrays.toString(src));
        int c[] = new int[totNum];
        //Fill the count array
        for (int i = 0; i < src.length; i++)
            c[(src[i] / exp) % 10]++;
        //Then sum up with previous array element
        for (int i = 1; i < totNum; i++)
            c[i] += c[i - 1];
        //Initialize the output array
        int output[] = new int[src.length];
        for (int i = src.length - 1; i >= 0; i--)
            output[--c[(src[i] / exp) % 10]] = src[i];

        for (int i = 0; i < output.length; i++) {
            src[i] = output[i];
        }
        System.out.println("After the count Sort:" + Arrays.toString(src));

    }


    /**
     * Get the max element
     * @param array
     * @param n
     * @return
     */
    private static int getMax(int[] array, int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

}