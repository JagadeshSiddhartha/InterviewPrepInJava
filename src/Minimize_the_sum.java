import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Minimize_the_sum {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        String[] line = bf.readLine().split("\\s");
        int N = sc.nextInt();
        int K = sc.nextInt();
        Long[] ar = new Long[N];
        PriorityQueue<Long> pq = new PriorityQueue<>((x,y) -> Long.compare(y,x));
        for (int i = 0; i < N; i++) {
            ar[i] = sc.nextLong();
            pq.add(ar[i]);
        }
        while(K > 0) {
            Long top = pq.peek();
//            System.out.print(top+" ");
            top = top/2;
            pq.remove();
            pq.add(top);
            K--;
        }
        Long total  = 0L;
        while(!pq.isEmpty()) {
            total += pq.peek();
            pq.remove();
        }
        System.out.println(total);
    }
}
/*
4 16
20 7 5 4

2 1
19 20

1 1
1
 */


