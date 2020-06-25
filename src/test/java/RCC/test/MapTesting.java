package RCC.test;

import java.util.*;

public class MapTesting {
    int m=4;
    public static void main(String args[]) {
          String s="harinathreddy";
        StringBuffer sb=new StringBuffer();
        StringBuilder sd=new StringBuilder(s);
        sd.reverse();
        int count=0;
        int k=s.length();
        Map<Character, Integer> mp = new LinkedHashMap<>();
        List<Character> ll = new ArrayList<Character>(k);
        for (int i = 0; i < k; i++) {
            ll.add(i, s.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            if (mp.containsKey(s.charAt(i))) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);

            } else {
                mp.put(s.charAt(i), 1);
            }
        }

        for (Map.Entry me : mp.entrySet()) {

        }
        System.out.println(mp.entrySet());
        //m=10;
    }
}
