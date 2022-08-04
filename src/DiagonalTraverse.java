public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[] {};
        // the column length
        if (matrix[0].length == 0) return new int[] {};
        int row = matrix.length, col = matrix[0].length;
        int y = 0, x = 0;
        // to return this array at the end
        int[] arr = new int[row * col];

        // even number go to top right
        // odd number go to bottom left
        int index = 0;
        while (index < arr.length) {
            arr[index++] = matrix[y][x];
            int sum = y + x;
            boolean isEven = sum % 2 == 0;
            if (isEven) {
                if (x < col-1 && y > 0) {
                    x++;
                    y--;
                } else if ( x < col - 1) {
                    x++;
                } else {
                    y++;
                }
            } else {
                // make sure have space
                if (y < row - 1 && x > 0) {
                    x--;
                    y++;
                } else if (y < row -1) {
                    y++;
                } else {
                    x++;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        DiagonalTraverse test = new DiagonalTraverse();
        int[][] input = new int[3][3];
        System.out.println(test.findDiagonalOrder(input));
    }
}
