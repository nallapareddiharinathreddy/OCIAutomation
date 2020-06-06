package OCI.test;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateFinder {



    public static void findch(String s) {
        Map<Character, Integer> baseMap = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();
        for (Character ch : charArray) {
            if (baseMap.containsKey(ch)) {
                baseMap.put(ch, baseMap.get(ch) + 1);
            } else {
                baseMap.put(ch, 1);
            }

        }
        Set<Character> keys = baseMap.keySet();
        for (Character ch : keys) {
            if (baseMap.get(ch) > 1) {
                System.out.println(ch + "  is " + baseMap.get(ch) + " times");
            }
        }

    }
    public static void main(String args[]) {
        String s = "india is my county";
        findch(s);


    }
}

