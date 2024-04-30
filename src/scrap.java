// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3
import java.io.*;

class scrap {

    public static int[] MovementsX = {1, -1, 0, 0};
    public static int[] MovementsY = {0, 0, -1, 1};
    public static void main (String[] args) {
        System.out.println("Hello Java");
        int[][] matrix = {{0,0,0,0,0}, {1,1,0,1,0}, {1,1,1,1,0}, {0,0,1,1,0}};
        System.out.println(findIslands(matrix));
    }

    public static int findIslands(int[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int height = matrix.length;
        int width = matrix[0].length;
        System.out.println(height + " " + width);
        Boolean[][] visited = new Boolean[height][width];

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                visited[i][j] = false;
            }
        }

        int islands = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(matrix[i][j] == 1 && visited[i][j] != true) {
                    islands ++;
                    traverse(i, j, matrix, visited);
                }
            }
        }

        return islands;

    }

    public static void traverse(int i, int j, int[][] matrix, Boolean[][] visited) {
        //System.out.println(i + " " + j);
        int height = matrix.length;
        int width = matrix[0].length;
        if(!isValid(i, j, height, width, visited))
            return;
        if(visited[i][j] || matrix[i][j] == 0)
            return;

        visited[i][j] = true;

        for(int index = 0; index < 4; index++) {
            traverse(i  + MovementsX[index], j + MovementsY[index], matrix, visited);
        }
    }

    public static boolean  isValid(int i, int j, int height, int width, Boolean[][] visited) {
        if(i < 0 || j < 0 || i >= height || j >= width)
            return false;
        return true;
    }
}



// Given a 2d array of 0s and 1s, where 0 is water and 1 is land,
// find the number of islands
// Connection can only be horizontal or vertical

// Test cases

// [0 0 0 0 0]
// [1 1 0 1 0]
// [1 1 1 1 0]
// [0 0 1 1 0]
// Answer: 1



















