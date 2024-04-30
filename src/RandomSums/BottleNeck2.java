package RandomSums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BottleNeck2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line[] = bf.readLine().split("\\s");
        int n = Integer.parseInt(line[0]);
        line = bf.readLine().split("\\s");
        ;
        Long ar[] = new Long[n];
        Long maxi = 0L;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ar[i] = Long.parseLong(line[i]);
            if(map.containsKey(ar[i])) {
                map.put(ar[i], map.get(ar[i]) + 1);
            } else {
                map.put(ar[i] , 1);
            }
        }
        for(Long l : map.keySet()) {
            maxi = Math.max(maxi, map.get(l));
        }
        System.out.println(maxi);
    }
}
