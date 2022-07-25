import java.util.Arrays;
import java.util.regex.Matcher;

public class LongestIncreasingSubsequence {

    public int solution(int[] array) {
        if (array.length <= 1)
            return array.length;
        int[] dynamicProgramming = new int[array.length];
        int max = -1;
        Arrays.fill(dynamicProgramming, 1);
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]){
                    dynamicProgramming[i] = Math.max(dynamicProgramming[i], dynamicProgramming[j] + 1);
                }
                max = Math.max(max, dynamicProgramming[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        int[] array = {10,9,2,5,3,7,101,18};
        System.out.println(test.solution(array));

    }
}
