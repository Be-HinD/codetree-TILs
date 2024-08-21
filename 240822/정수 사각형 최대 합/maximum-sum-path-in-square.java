import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

//CodeTree
public class Main {
    static int[][] arr, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        //초기조건
        dp[0][0] = arr[0][0];
        for(int i=1; i<N; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }

        for(int i=1; i<N; i++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }

        //격자 채우기
        for(int i=1; i<N; i++) {
            for(int j=1; j<N; j++) {
                dp[i][j] = Math.max(dp[i-1][j] + arr[i][j], dp[i][j-1] + arr[i][j]);
            }
        }

        int res = 0;
        for(int i=0; i<N; i++) {
            res = Math.max(res, dp[N-1][i]);
        }

        System.out.println(res);

    }
}