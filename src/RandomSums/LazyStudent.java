package RandomSums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LazyStudent {
    public static int modInverse(int a, int m)
    {
        int y = 0, x = 1;
        int m0 = m;
        if (m == 1)
            return 0;
        while (a > 1)
        {
            int q = a / m;
            int t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0)
            x += m0;
        return x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line[] = bf.readLine().split("\\s");
        int down = Integer.parseInt(line[0]);
        int t = Integer.parseInt(line[1]);
        int m = Integer.parseInt(line[2]);
        int top = m*t;
        int gcd = gcd(top, down);
        top /= gcd;
        down /= gcd;
        down = modInverse(down, 1000000007);
        int mod = 1000000007;
        top %= mod;
        down %= mod;
        int mul = top == down ? 1: top * down;
        System.out.println((mul) %mod);

    }

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }
}
