package RCC.test;

import java.util.Scanner;

public class valid {

    public static void main(String args[])
    {
        String s;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter address");
        s=sc.next();
        String st[]=s.split(":");
        boolean flag=false;
        if(st.length!=4)
        {
            System.out.println("given address is not valid");

        }
        else
        {
            for(String in:st)
            {
                if(isdigit(in))
                {
                    int i=Integer.parseInt(in);
                    if(i>=0&&i<=255)
                    {
                      flag=true;
                    }


                    else
                    {
                        System.out.println("given address is not valid");
                        flag=false;
                        break;
                    }



                }
                else
                {
                    System.out.println("given address is not valid");
                    flag=false;
                break;
                }

            }


        }
        if(flag){
            System.out.println("given address is  valid");
        }

    }
    public static boolean isdigit(String st){
        for (int i = 0; i < st.length(); i++)
            if (Character.isDigit(st.charAt(i))
                    == false)
                return false;

        return true;
    }
}
