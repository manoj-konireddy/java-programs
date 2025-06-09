import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of rows in the image: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns in the image: ");
        int cols = sc.nextInt();

        int[][] image = new int[rows][cols];

        System.out.println("Enter the image matrix row by row (space-separated integers):");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                image[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting row (sr): ");
        int sr = sc.nextInt();

        System.out.print("Enter starting column (sc): ");
        int scCol = sc.nextInt();

        System.out.print("Enter new color: ");
        int newColor = sc.nextInt();

        int[][] result = sol.floodFill(image, sr, scCol, newColor);

        System.out.println("Resulting image:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}}; 
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int change = image[sr][sc];
        fill(image, sr, sc, color, change);
        return image;
    }
    
    public void fill(int[][] image, int sr, int sc, int color, int org) {
        int m = image.length, n = image[0].length;
        if(sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc] == color || image[sr][sc] != org) {
            return;
        }
        if(image[sr][sc] == org) {
            image[sr][sc] = color;
        }
        for(int[] di : dir) {
            int dr = di[0], dc = di[1];    
            fill(image, sr + dr, sc + dc, color, org); 
        }
    }
}
