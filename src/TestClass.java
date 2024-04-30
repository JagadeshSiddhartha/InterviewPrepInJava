import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int q = Integer.parseInt(br.readLine().trim());
            int[][] queries = new int[q][3];
            for(int i_queries = 0; i_queries < q; i_queries++)
            {
                String[] arr_queries = br.readLine().split(" ");
                for(int j_queries = 0; j_queries < arr_queries.length; j_queries++)
                {
                    queries[i_queries][j_queries] = Integer.parseInt(arr_queries[j_queries]);
                }
            }

            int out_ = findSum(N, q, queries);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static int findSum(int n, int q, int[][] queries){
        // Write your code here
        int result = 0;
        int[][] row = new int[n][2];
        int[][] column = new int[n][2];

        for(int i = 0; i < n; i++) {
            if(queries[i][0] == 1) {
                row[queries[i][1] - 1][0] = queries[i][2];
                row[queries[i][1] - 1][1] = i + 1;
            } else {
                column[queries[i][1] - 1][0] = queries[i][2];
                column[queries[i][1] - 1][1] = i + 1;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(row[i][0] + "_" + row[i][1] + "  " );
        }
        System.out.print( "\n" );

        for(int i = 0; i < n; i++) {
            System.out.print(column[i][0] + "_" + column[i][1] + "  " );
        }
        System.out.print( "\n" );

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(row[i][1] == 0) {
                    if(column[i][1] == 0) {
                        System.out.print( "skipping for " );
                        continue;
                    } else {
                        result += column[i][0];
                    }
                } else if( column[i][1] == 0) {
                    result += row[i][0];
                } else {
                    result += row[i][1] >  column[j][1] ? row[i][0] : column[j][0];
                }
            }
        }

        return result;

    }
}


