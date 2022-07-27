
// kadane's algorithm

// intialize
// max_so_far = 0;
// max_ending_here = 0

// loop for each element of the array
// a) max_ending_here = max_ending_here + a[i]
// b) if (max_ending_here < 0)
    // max_ending_here = 0
// c) if (max_so_far < max_ending_here)
    // max_so_far = max_ending_here
// return max_so_far
public class LargestSumSubarray {
    static int findMaxSumSubArray(int[] A) {
        if (A.length < 1) {
            return 0;
        }

        int currMax = A[0];
        int globalMax = A[0];
        for (int i = 1; i < A.length; ++i) {

            if (currMax < 0) {
                currMax = A[i];
            } else {
                currMax += A[i];
            }

            if (globalMax < currMax) {
                globalMax = currMax;
            }
        }

        return globalMax;
    }
    public static void main(String[] args) {
        int[] v = new int[]{1, -3, 2, 1, -1};
        System.out.println("Sum of largest subarray: " + findMaxSumSubArray(v));
    }
}