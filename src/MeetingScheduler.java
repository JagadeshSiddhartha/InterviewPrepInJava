import java.util.List;

public class MeetingScheduler {

    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
        boolean[] taken = new boolean[1000000];
        return countMeetings(firstDay, lastDay, 0, taken);
    }

    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay, int index, boolean[] taken) {
        if (index >= firstDay.size())
            return 0;

        int without = countMeetings(firstDay, lastDay, index + 1, taken);

        int withPresent = 0;

        // Check if the current meeting can be attended
        boolean canAttend = true;
        for (int i = firstDay.get(index); i <= lastDay.get(index); i++) {
            if (taken[i]) {
                canAttend = false;
                break;
            }
        }

        // If the current meeting can be attended, mark its days as taken
        if (canAttend) {
            for (int i = firstDay.get(index); i <= lastDay.get(index); i++) {
                taken[i] = true;
            }
            // Recursively find the maximum number of meetings that can be attended
            withPresent = 1 + countMeetings(firstDay, lastDay, index + 1, taken);

            // Undo the marking for backtracking
            for (int i = firstDay.get(index); i <= lastDay.get(index); i++) {
                taken[i] = false;
            }
        }

        // Return the maximum count of meetings
        return Math.max(without, withPresent);
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> firstDay = List.of(1, 2, 3, 3, 3);
        List<Integer> lastDay = List.of(3, 2, 3, 4, 4);
        System.out.println(countMeetings(firstDay, lastDay)); // Output: 4
    }
}
