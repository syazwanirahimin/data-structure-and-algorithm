public class CheckIfItsStraightLine {

    /**
     * you are given an array coordinates, coordinates[i] = [x,y], where [x,y] represents the coordinate of a point
     * check if these points make a straight line in the XY plane
     */
    /**
     * approach
     * gradient of a straight line
     * change in y / change in x= y2-y1 / x2 -x1 = gradient
     * @return
     */
    /**
     * point1
     * point2
     * point3 = (x3,y3)
     *
     * slope = k1(p1, p2) = (y2-y1) / (x2-x1)
     * slope = k2(p1, p3) =
     * check whether k1 equals to k2
     *
     * (1,2) (2,3), (3,4)
     * k1 = (3-2) / (2-1) = 1
     * k2 = 1
     *
     * denominator = 0 invalid value
     * 5 / 0  ArithmeticException
     * 
     * use multiplication to avoid denominator
     * 
     * 
     * @param coordinates
     * @return
     */
    
    public boolean checkStraightLine(int[][] coordinates){
        for (int i = 2; i < coordinates.length; i++) {
            if((coordinates[1][1]) - coordinates[0][1] * (coordinates[i][0] - coordinates[0][0]) != (coordinates[1][0]) - coordinates[0][0] * (coordinates[i][1] - coordinates[0][1])) {
                return false;
            }
        }
        return true;
    }

    public boolean solution(int[][] coordinates){
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        for (int[] c : coordinates){
            int x = c[0];
            int y = c[1];

            if (dx * (y-y0) != dy * (x - x0))
                return false;
        }
        return true;
    }
}
