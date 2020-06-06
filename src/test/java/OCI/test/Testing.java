package OCI.test;

public class Testing {
    public static void main(String args[]) {
        String str = "This is a very basic example of strings in java using selenium";
        String array[] = str.split(" ");

        String output = "";
        String substring, k, s;
        for (int i = 0; i < array.length; i++) {
            s = array[i];
            substring = s.substring(1);


            k = s.substring(0, 1);
            output = output + k.toUpperCase() + substring;

        }
        System.out.println(output);
    }
}
