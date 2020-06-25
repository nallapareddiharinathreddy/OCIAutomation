package RCC.test;

// Java program to print matrix in diagonal order
class Naistam {
    static final int MAX = 100;

    static void printMatrixDiagonal(int mat[][], int n)
    {
        // Initialize indexes of element to be printed next
        int i = 0, j = 0;

        // Direction is initially from down to up
        boolean isUp = true;

        // Traverse the matrix till all elements get traversed
        for (int k = 0; k < n * n;) {
            if (isUp) {
                for (; i >= 0 && j < n; j++, i--) {
                    System.out.print(mat[i][j] + " ");
                    k++;
                }
                // Set i and j according to direction
                if (i < 0 && j <= n - 1)
                    i = 0;
                if (j == n) {
                    i = i + 2;
                    j--;
                }
            }
            else {
                for (; j >= 0 && i < n; i++, j--) {
                    System.out.print(mat[i][j] + " ");
                    k++;
                }
                // Set i and j according to direction
                if (j < 0 && i <= n - 1)
                    j = 0;
                if (i == n) {
                    j = j + 2;
                    i--;
                }
            }// Revert the isUp to change the direction
            isUp = !isUp;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        int n = 3;
        printMatrixDiagonal(mat, n);
    }
}


