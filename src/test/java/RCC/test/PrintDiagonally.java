package RCC.test;

public class PrintDiagonally {
    public static int R,C;

    public static void main(String[] args) {
        int arr[][] = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21,22,23,24}};

        R=arr.length;
        C=arr[0].length;

        diagonalOrder(arr);
    }
    public static boolean isValid(int i, int j)
    {
        if (i < 0 || i >= R || j >= C || j < 0) return false;
        return true;
    }
    private static void diagonalOrder(int[][] arr) {

			/* through this for loop we choose each element
			of first column as starting point and print
			diagonal starting at it. arr[0][0], arr[1][0]
			....arr[R-1][0] are all starting points */
        for (int k = 0; k < R; k++)
        {

            int i = k - 1; // set row index for next
            // point in diagonal
            int j = 1;	 // set column index for
            // next point in diagonal

            /* Print Diagonally upward */
            while (isValid(i, j))
            {
                System.out.print(arr[i][j] + " ");

                i--;
                j++; // move in upright direction
            }


        }

			/* through this for loop we choose each element
				of last row as starting point (except the
				[0][c-1] it has already been processed in
				previous for loop) and print diagonal
				starting at it. arr[R-1][0], arr[R-1][1]....
				arr[R-1][c-1] are all starting points */

        // Note : we start from k = 1 to C-1;
        for (int k = 1; k < C; k++)
        {
            System.out.print(arr[R-1][k] + " ");

            int i = R - 1; // set row index for next
            // point in diagonal
            int j = k ; // set column index for
            // next point in diagonal

            /* Print Diagonally upward */
            while (isValid(i, j))
            {
                System.out.print(arr[i][j] + " ");

                i--;
                j++; // move in upright direction
            }


        }
    }
    /*public static void main(String args[]) {


        int a[][] = {{1, 2, 3,4}
        ,{5,6,7,8
        },{9,10,11,12},

                {13,14,15,16},


                {17,18,19,20}};
        int k,R,C,i,j;
        R=a.length;
        C=a[0].length;

        for(k=0;k<=R-1;k++)
        {
            i=k;
            j=0;
            while (i>=0)
            {
                System.out.print(a[i][j]+" ");
                i=i-1;
                j=j+1;

            }
        }
        for(k=1;k<=C-1;k++)
        {
            i=R-1;
            j=k;
            while(j<=C-1)
            {
                System.out.print(a[i][j]+" ");
                i=i-1;
                j=j+1;
            }
        }
    }
*/
}
