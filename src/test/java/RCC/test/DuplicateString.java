package RCC.test;

import java.util.*;

public class DuplicateString {

    public  static void findDuplicate(String str)
    {

        String arry[]=str.split(" ");


        //System.out.println(Arrays.toString(arry));
        Map<String,Integer> mp=new HashMap<String, Integer>();
        for(String s:arry)
        {
            if(mp.containsKey(s))
            mp.put(s,mp.get(s)+1);
            else {
                mp.put(s,1);
            }
        }
        Set<String> s=mp.keySet();
        System.out.println(mp.entrySet());
        for(String st:s)
        {
            if(mp.get(st)>1) {
                System.out.println(st +"  is "  + " value is " + mp.get(st) +" times");
            }

        }

        mp.remove("cd",1);
        System.out.println("After clearning"+ mp.entrySet());


    }
    public static void main (String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String ");
        String str=sc.nextLine();
        findDuplicate(str);
    }
}
