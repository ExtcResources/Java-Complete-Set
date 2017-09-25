import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int getBiggestRegion(int[][] matrix) {
        int maxRegion =0;
        
       for(int row=0;row<matrix.length;row++){
           for(int col=0;col<matrix[row].length;col++){
               if(matrix[row][col]==1){
                   int size=getRegion(matrix, row, col);
                   maxRegion=Math.max(size,maxRegion);
               }
           }
       } 
        return maxRegion;
    }
    
    public static int getRegion(int [][]matrix, int row, int col){
        int size=1;
        if(row<0||col<0||row>=matrix.length|| col>=matrix[row].length || matrix[row][col]==0){
            return 0;
        }
        matrix[row][col]=0;
        for(int r=row-1;r<=row+1;r++){
            for(int c=col-1;c<=col+1;c++){
                if(r!=row || c!=col){
                    size+=getRegion(matrix,r,c);
                }
            }
        }
        return size;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
