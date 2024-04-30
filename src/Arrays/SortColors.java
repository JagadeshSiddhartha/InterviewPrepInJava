package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortColors {

    public static void sortColors(int[] nums) {
        if(nums.length < 2 )return;

        int z = 0, one = -1, two = nums.length - 1;
        while(two >=0 && nums[two] == 2)
            two--;
        for(int i = 0; i <= two; i++) {

            System.out.println(i +"_" + z+ "_" +one + "_" + two + "_");

            if(nums[i] == 0){
                if(one != -1 && one <= z) {
                    nums[one] = 0;
                    nums[i] = 1;
                    while(nums[one] != 1)one++;
                }
                z++;
            }
            if(nums[i] == 1) {
                if(one == -1) {
                    one = i;
                }
            }
            if(nums[i] == 2) {
                nums[i] = nums[two];
                nums[two] = 2;
                two--;
                i--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T-->0) {
//            int target = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split("\\s");
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(line[i]);
            }
            sortColors(ar);
        }
    }
}
/*
1
6
2 0 2 1 1 0
 */