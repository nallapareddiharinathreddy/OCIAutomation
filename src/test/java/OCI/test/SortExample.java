package OCI.test;

import java.util.Arrays;
import java.util.Collections;

public class SortExample
{
    public static void main(String[] args)
    {
        // Our arr contains 8 elements

        int[] oldArray={-13,-7,0,13, 7, 6, 45, 21, 9, 101, 102};



        Integer[] newArray = new Integer[oldArray.length];
        Integer[] result = new Integer[oldArray.length];
        for (int i = 0; i < oldArray.length; i++) {
            result[i] = Integer.valueOf(oldArray[i]);
        }


        Arrays.sort(result, Collections.reverseOrder());

        System.out.printf("Modified arr[] : %s",
                Arrays.toString(result));
    }
}