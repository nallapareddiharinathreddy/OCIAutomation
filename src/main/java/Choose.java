public class Choose {


    public static void main(String []args)
    {
        String []S=new String[3];
        String s4[] = new String[3];
        String high[] = new String[3];
        String Num[]=new String[3];


        S[0]= "enterprise.2020.DEV.1.402.37.3.0.tgz";
        S[1]="enterprise.2020.DEV.1.402.27.3.0.tgz";
        S[2]="enterprise.2020.DEV.1.402.103.3.0.tgz";

            for(int i=0;i<3;i++) {
                int n = S[i].length();

                s4[i] = S[i].substring(26, n);
                System.out.println(s4[i]);
                int k=s4[i].length();

                Num[i]= s4[i].substring(0,k-8);
                System.out.println(Num[i]);
            }

        // Initialize maximum element
        int max = Integer.parseInt(Num[0]);

        // Traverse array elements from second and
        // compare every element with current max
        for (int l = 1; l < Num.length; l++) {
            if (Integer.parseInt(Num[l]) > max)
                max = Integer.parseInt(Num[l]);
              System.out.println(max);
        }


        //






        //for (int j = 0; j < Num.length; j++) {
           // String Num[] = s4[i].split(".");
            //high[j] = Num[0];
           // System.out.println(Num[j]);

            }

}

