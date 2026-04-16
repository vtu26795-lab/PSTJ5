public class UserMainCode {
    public static int NthPrime(int input1) {
        int count = 0;  // how many primes found
   
 int number = 2; // candidate number to test

        while (true) {
            if (isPrime(number)) {
                count++;
                if (count == input1) {
                    return number; // found nth prime
                }
            }
            number++;
        }
    }
    // helper to check if num is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
