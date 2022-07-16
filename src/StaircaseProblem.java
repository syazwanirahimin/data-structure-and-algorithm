public class StaircaseProblem {
    /**
     * Question:
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps.
     * In how many distinct ways can you climb to the top?
     * n = 2, output = 2. there are two ways to climb to the top
     * 1. 1 + 1 steps
     * 2. 2 steps
     * constraints 1 < = n < = 45
     * @param args
     */
    public static void main(String[] args) {
        StaircaseProblem test = new StaircaseProblem();
        System.out.println(test.climbStairs(4));
        System.out.println(test.fib(4));

    }

    /**
     * Solution 1: Brute Force (recursive) approach O(2n)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n < 2) // termination condition for the function
            return 1;
        else
            return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * Solution 2: Fibonacci Sequence
     * intialise two variable first = 1 and second = 2
     * iterate a loop from i = 3 till i = N and for each step
     * initialise a variable third = first and second
     * first = second
     * second = third
     * return second after the iteration ends
     */

    public static int fib(int n){
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++){
            int third = first + second; // sum of previous two elements
            first = second;
            second = third;
        }
        return second;
    }
}

/**
 * if can take a number of steps from the set X = {1, 3, 5}, then algorithm should be f(n) = f(n-1) + f(n-3) + f(n-5)
 */
