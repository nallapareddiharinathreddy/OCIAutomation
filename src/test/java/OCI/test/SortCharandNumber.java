package OCI.test;

import java.util.ArrayList;
import java.util.List;

public class SortCharandNumber {
    public static void main(String args[]) {
        String arr[] = {"test", "12", "10", "best"};
        sortedArray(arr);
    }
    public static void sortedArray(String arr[])

    {
        List<String> li=new ArrayList<>();
        for(String sb:arr)
        {


            if(isNumber(sb))
            {
                li.add(sb);

            }
            else
            {
                //System.out.println("string is:"+sb);

            }

        }
     //System.out.println(li));

    }
    static boolean isNumber(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i))
                    == false)
                return false;

        return true;
    }
}
