import java.util.Collections;
import java.util.PriorityQueue;

class Student {
    int rollno = 10;
}
public class LearnJava {
    public static void main(String[] args) {

        int[] ar = {1,1,1};
        int m = 10, n = 3;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i : ar) {
            pQueue.add(i);
        }

        while(m > 0) {
            int top = pQueue.poll();
            //System.out.print(top + " ");
            top /= 2;
            //System.out.println(top);
            pQueue.add(top);
            m --;
        }


        int total = 0;

        while (pQueue.size() > 0)
            total += pQueue.poll();
         System.out.println(total);
    }

}
