package RCC.test;
import java.util.Arrays;

public class Sorting {

    public static void main(String args[])
    {
        int array[]={1,0,3,40,12,0,7};
        int temp;
        for (int i = 1; i < array.length; i++) {
            //System.out.println(array[i]);
            for (int j = i; j > 0; j--) {
                if (array[j] <array [j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
