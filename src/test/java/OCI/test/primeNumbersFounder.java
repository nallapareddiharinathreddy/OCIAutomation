package OCI.test;

public class primeNumbersFounder {

    public static void main(String[] args) {

        int i;
        int num = 0;
        int maxCheck = 100; // maxCheck limit till which you want to find prime numbers
        boolean isPrime = true;

        //Empty String
        String primeNumbersFound = "";
        String NOnprimeNumbersFound = "";

        //Start loop 1 to maxCheck
        for (i = 1; i <= maxCheck; i++) {
            isPrime = CheckPrime(i);
            if (isPrime) {
                primeNumbersFound = primeNumbersFound + i + " ";
            }
            else {
                NOnprimeNumbersFound = NOnprimeNumbersFound + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to " + maxCheck + " are:");
        // Print prime numbers from 1 to maxCheck
        System.out.println(primeNumbersFound);
        System.out.println("NOn Prime numbers from 1 to " + maxCheck + " are:");
        // Print prime numbers from 1 to maxCheck
        System.out.println(NOnprimeNumbersFound);

    }
    public static boolean CheckPrime(int numberToCheck) {
        int remainder;
        for (int i = 2; i <= numberToCheck / 2; i++) {
            remainder = numberToCheck % i;
            //if remainder is 0 than numberToCheckber is not prime and break loop. Elese continue loop
            if (remainder == 0) {
                return false;
            }
        }
        return true;

    }

}