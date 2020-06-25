package RCC.test;

public class Spiralform {
    public static void main(String args[])
    {
        int R = 3;
        int C = 4;
        int a[][] = { { 1, 2, 3, 4,  },
                { 5, 6, 7, 8  },
                { 9, 10, 11, 12} };
        spiral(R, C, a);

    }

    public static void spiral(int r,int c,int a[][])
    {
        int i,rn=0,cn=0;

        while(rn<=r&&cn<=c)
        {
            for (i = cn; i < c; ++i) {
                System.out.print(a[rn][i] + " ");
            }
            rn++;

            // Print the last column from the remaining columns
            for (i = rn; i < r; ++i) {
                System.out.print(a[i][c - 1] + " ");
            }
            c--;
            // Print the last row from the remaining rows */
            if (rn< r) {
                for (i = c- 1; i >= cn; --i) {
                    System.out.print(a[r - 1][i] + " ");
                }
                c--;
            }

            // Print the first column from the remaining columns */
            if (cn < c) {
                for (i = r - 1; i >= rn; --i) {
                    System.out.print(a[i][cn] + " ");
                }
                cn++;
            }

        }

    }
}
