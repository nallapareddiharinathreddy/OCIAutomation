package RCC.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Hacker
        {

public static void main(String args[])
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            Scanner sc = new Scanner((System.in));
        System.out.println("Enter input as street number in first line then in second line number of buildings and in third line building heights");

        try{

            int k;
            int y;


                String firstline= sc.nextLine();
                 String secondline=sc.nextLine();
                 k=Integer.parseInt(firstline);
                 y=Integer.parseInt(secondline);
            String heights=sc.nextLine();
            String h[]=heights.split(" ");
            int a[]=new int[y];
            for(int i=0;i<a.length;i++)
            {
                a[i]=Integer.parseInt(h[i]);
            }
            int max;
            int count=0;
            max=a[0];
          for(int i=0;i<a.length;i++)
          {

              if(max<=a[i])
              {
                  max = a[i];
                  count++;
              }


          }
          System.out.println(count);

        }
        catch (NumberFormatException e)
        {
        System.out.println("hello");
        }
        catch (Exception e)
        {
            System.out.println("enter number properly");
        }
        }
        }




