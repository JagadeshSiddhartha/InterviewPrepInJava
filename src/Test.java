import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
public class Test {


    ArrayList<Integer> findRightInterval(ArrayList<ArrayList<Integer>> intervals, int index) {
        int left = index, right = intervals.size();
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(-1);
//        resultList.add(-1);
        while(left < right) {
            int mid = (left + right) / 2;
            if(intervals.get(mid).get(0) > intervals.get(index).get(1)) {
                resultList = intervals.get(mid);
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return resultList;
    }

    ArrayList<Integer> findRightIntervals(ArrayList<ArrayList<Integer>> intervals) {
        HashMap<ArrayList<Integer>, Integer> intervalIndexMap = new HashMap<>();
        int index = 0;

        for(ArrayList<Integer> interval : intervals) {
            intervalIndexMap.put(interval, index);
            index ++;
        }

        Collections.sort(intervals, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        ArrayList<Integer> rightIntervals = new ArrayList<>(intervals.size());
        for(int i = 0; i < intervals.size(); i++) {
            ArrayList<Integer> rightInterval = findRightInterval(intervals, i);
            rightIntervals.set(i, intervalIndexMap.getOrDefault(rightInterval, -1));
        }

        return rightIntervals;

    }





}
