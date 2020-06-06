package OCI.test;

import java.lang.Character;
import java.util.Scanner;
public class Practise
{
    public static void main(String[] args)throws Exception
    {

    String s="sreekumar";
    Scanner sc=new Scanner(System.in);

    char c1=sc.next().charAt(0);
    char c2=sc.next().charAt(0);
    if(s.contains("c1") &&s.contains("c2")) {
        System.out.println("Distance between char's " + (s.indexOf(c1) - s.indexOf(c2)));
        System.out.println(Math.abs(Character.toLowerCase(c1) - Character.toLowerCase(c2)));
    }
    else{
        System.out.println("Enter characters available in given string ");
    }
}
}
/*&
import java.lang.Character;
        import java.util.Scanner;
public class Main
{
    public static void main(String[] args)throws Exception
    {
        Scanner in=new Scanner(System.in);
        char a=in.next().charAt(0);
        char d=in.next().charAt(0);
        System.out.println(Math.abs(Character.toLowerCase(a)-Character.toLowerCase(d)));
    }
}
*/