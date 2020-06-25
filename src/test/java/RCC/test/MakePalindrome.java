package RCC.test;

import java.util.*;

public class MakePalindrome {


        public static void main(String args[]){
            String s="abababababab";
            StringBuffer sb=new StringBuffer();
            StringBuilder sd=new StringBuilder(s);
            sd.reverse();
            int count=0;
            if(s.equals(sd))
            {
                System.out.println("palindrome string ");
            }

            else {


                int k=s.length();

                    //System.out.println("given number has even lentgh ");
                    Map<Character,Integer>mp=new HashMap<Character,Integer>();
                List<Character> ll=new ArrayList<Character>(k);
                for (int i = 0; i < k; i++) {
                    ll.add(i,s.charAt(i));
                }
                    for(int i=0;i<k;i++)
                    {
                        if(mp.containsKey(s.charAt(i)))
                        {
                            mp.put(s.charAt(i),mp.get(s.charAt(i))+1);

                        }
                        else {
                            mp.put(s.charAt(i), 1);
                        }
                    }

                    for(Map.Entry me:mp.entrySet())
                    {
                        String ki=me.getKey().toString();
                    }

                    //System.out.println(mp);
                Set<Character> se = mp.keySet();
                    if(k%2==0) {
                        int i=0;
                        int j=k-1;
                        for (char ch : se) {
                            if (mp.get(ch) % 2 != 0) {
                                System.out.println("given number not possible: because one or more character repeated only odd times");
                                break;
                            }


                             int h=mp.get(ch);
                            while(h>0&&i<=j) {
                                ll.set(i, ch);
                                ll.set(j, ch);
                                //System.out.println(ch + " is added at" + i + " " + j + " places");

                                h=h-2;
                                i++;
                                j--;

                            }


                        }


                        for (char cb : ll) {
                            sb.append(cb);

                        }
                        String str = sb.toString();
                        System.out.println(str);




                    }
                    else
                    {
                        for (char ch : se) {
                            if (mp.get(ch) % 2 != 0) {

                                count++;

                            }
                            if (count>1)
                            {
                                System.out.println("given number not possible because more than one character repeated odd times ");
                                break;
                            }




                        }
                    }


            }
        }


    }


