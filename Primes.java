public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int confirmedMultiple = p * p; confirmedMultiple <= n; confirmedMultiple += p) {
                    isPrime[confirmedMultiple] = false;
                }
            }
        }

        System.out.println("Prime numbers up to " + n + ":");
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }

        int percentage = (int) ((count * 100.0) / (n - 1));
        System.out.println("There are " + count + " primes between 2 and " + n + " (" + percentage + "% are primes)");
    }
}