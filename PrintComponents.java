import java.io.File;
import java.util.Scanner;

public class PrintComponents {

    public static void dfs(boolean[][] matrix, boolean[] visited, int curr) {
        if(!visited[curr]) {
            visited[curr] = true;
            System.out.print(curr + " ");
            for(int col=1; col<matrix[curr].length; col++) {
                if(matrix[curr][col]) dfs(matrix, visited, col);
            }
        }
    }

    public static void main(String[] args) {
        File file;
        Scanner sc;
        try {
            file = new File(args[0]);
            sc = new Scanner(file);
        }
        catch(Exception e) {
            System.out.println("Invalid file");
            return;
        }
        // Edges
        sc.nextInt();
        // Vertices
        int n = sc.nextInt()+1;
        // Adjacency matrix and visited array
        boolean[][] matrix = new boolean[n][n];
        boolean[] visited = new boolean[n];
        // Populating adjacency matrix
        while(sc.hasNextLine() && sc.hasNextInt()) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            matrix[left][right] = matrix[right][left] = true;
        }
        
        // Run depth first search on every vertex that hasn't
        // been visited yet
        int ctr = 1;
        for(int curr=1; curr<n; curr++) {
            if(!visited[curr]) {
                System.out.println(String.format("Connected Component %d:", ctr++));
                dfs(matrix, visited, curr);
                System.out.println("\n");
            }
        }
    }
}