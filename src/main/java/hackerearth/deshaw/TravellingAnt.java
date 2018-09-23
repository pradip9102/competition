package hackerearth.deshaw;

import java.math.BigInteger;
import java.util.Scanner;

class Pair {
    int x;
    int y;
}

public class TravellingAnt {

    private Pair pair = new Pair();

    int gcdExtended(int a, int b) {
        if (a == 0) {
            pair.x = 0;
            pair.y = 1;
            return b;
        }

        Pair pair1 = new Pair();
        int gcd = gcdExtended(b % a, a, pair1);

        // Update x and y using results of recursive
        // call
        pair.x = pair1.y - (b / a) * pair1.x;
        pair.y = pair1.x;

        return gcd;
    }

    int gcdExtended(int a, int b, Pair p) {
        // Base Case
        if (a == 0) {
            p.x = 0;
            p.y = 1;
            return b;
        }

        Pair pair1 = new Pair();
        int gcd = gcdExtended(b % a, a, pair1);

        // Update x and y using results of recursive
        // call
        p.x = pair1.y - (b / a) * pair1.x;
        p.y = pair1.x;

        return gcd;
    }

    int modInverse(int b, int m) {
        Pair p = new Pair();
        int g = gcdExtended(b, m, p);

        // Return -1 if b and m are not co-prime
        if (g != 1)
            return -1;

        // m is added to handle negative x
        return (p.x % m + m) % m;
    }

    int modDivide(int a, int b, int m) {
        a = a % m;
        int inv = modInverse(b, m);
        if (inv == -1)
            return -1;
        else
            return (inv * a) % m;
    }

    int modFact(int n, int p)
    {
        // n! % p is 0 if n >= p
        if (p <= n)
            return 0;

        // Initialize result as (p-1)! which is -1 or (p-1)
        int res = (p-1);

        // Multiply modulo inverse of all numbers from (n+1)
        // to p
        for (int i=n+1; i<p; i++)
            res  = (res * modInverse(i, p)) % p;
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 15, b = 3, m = 7;
        TravellingAnt prob = new TravellingAnt();
        System.out.println(prob.modDivide(a, b, m));
    }
}
