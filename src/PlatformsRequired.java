import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PlatformsRequired {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        String[] line = bf.readLine().split("\\s");
        int N = sc.nextInt();
        Long[] ar = new Long[N];
        Long[] de = new Long[N];
        int[] arr = new int[20];
        int[] dep = new int[20];
        int a, b;
        for (int i = 0; i < N; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            b += a;
            arr[a] += 1;
            dep[b] += 1;
        }
        int max = 0, cur = 0;
        for(int i = 0; i <= 19; i++) {
            cur += arr[i];
            cur -= dep[i];
            max = Math.max(max, cur);
        }
        for(int i = 0; i < 20; i++) {
            System.out.print(i+"_"+arr[i]+" ");
        }
        System.out.println();
        for(int i = 0; i < 20; i++) {
            System.out.print(i+"_"+ dep[i]+" ");
        }
        System.out.println(max);


    }
}
/*
3
10 2
5 10
13 5
 */