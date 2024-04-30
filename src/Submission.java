import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Submission {
    static class Pair{
        Integer first, second;
        Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    };
    static HashSet<String> set;
    static int power(int a,int n, int p)
    {
        int res = 1;
        a = a % p;
        while (n > 0)
        {
            if ((n & 1) == 1)
                res = (res * a) % p;
            n = n >> 1;
            a = (a * a) % p;
        }
        return res;
    }
    static boolean isPrime(int n, int k)
    {
        if (n <= 1 || n == 4) return false;
        if (n <= 3) return true;
        while (k > 0)
        {
            int a = 2 + (int)(Math.random() % (n - 4));
            if (power(a, n - 1, n) != 1)
                return false;

            k--;
        }

        return true;
    }

    public static void main(String[] args) {
        findAngle(3, 2, 0);

    }

    static void findAngle(double hours, double minutes, double seconds) {


        double hourHandAngle = (hours  + (minutes/60) + (seconds)/720) * 30;
        double minutesHandAngle = (minutes + seconds / 60) * 6;
        double angle = Math.abs(hourHandAngle - minutesHandAngle);
        if(angle > 180) {
            System.out.println("Major angle is:" + (angle));
            System.out.println("Minor angle is:" + (360.0 - angle));
        } else {
            System.out.println("Major angle is:" + (360.0 - angle));
            System.out.println("Minor angle is:" + angle);
        }
        //return angle;
    }

    private static void factors(int n) {
        int primes = 0;
        int factors = 0;
        for(int i = 1; i  <= n; i++) {
            if(n % i == 0) {
                factors++;
                if(isPrime(i, 7)) {
                    primes ++;
                }
            }
        }
        if(!set.contains(new Pair(factors, primes))) {
            set.add(factors + "_" + primes);
        }
//        System.out.println(n + " " + factors + " " + primes);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
