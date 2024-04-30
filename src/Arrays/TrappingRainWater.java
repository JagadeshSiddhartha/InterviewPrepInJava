package Arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        int arr[] = {3,2,1,5};
        System.out.println(getMaxRainwaterBetweenTowers(arr));
    }

    public static int getMaxRainwaterBetweenTowers(int[] towerHeight) {

        int[] maxSeenSoFarFromRight = new int[towerHeight.length];

        //Populate maxSeenSoFarFromRight array.
        maxSeenSoFarFromRight[towerHeight.length-1] = towerHeight[towerHeight.length-1];
        for (int i = towerHeight.length-2; i >= 0; i--) {
            maxSeenSoFarFromRight[i] = Math.max(maxSeenSoFarFromRight[i+1], towerHeight[i]);
        }

        int totalWaterCollection = 0;

        int maxSeenSoFarFromLeft = 0;
        for (int i = 0; i < towerHeight.length; i++) {
            if(maxSeenSoFarFromLeft < towerHeight[i]){
                maxSeenSoFarFromLeft = towerHeight[i];
            }
            int minFromLeftRight = Math.min(maxSeenSoFarFromLeft, maxSeenSoFarFromRight[i]);
            totalWaterCollection += (minFromLeftRight - towerHeight[i]);
        }
        return totalWaterCollection;
    }
}