import java.io.*;
import java.util.*;

public class Main {
    static int N, M, tempCnt, res;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //완전탐색
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                //map[i][j]를 왼쪽 상단 모서리 지점으로 고정
                // i = i ~ N , j = (j+1) ~ M 까지를 우측 하단 모서리 지점으로 변경하면서
                // 양수로의 집합이 되는지 체크
                if(map[i][j] < 0) continue;
                res = Math.max(res, 1);
                for(int k=i; k<N; k++) {
                    for(int l=j; l<M; l++) {
                        tempCnt = 0;
                        if(validateCheck(i,j,k,l)) res = Math.max(res, tempCnt);
                    }
                }
            }
        }

        System.out.println(res == 0 ? -1 : res);

    }

    private static boolean validateCheck(int li, int lj, int ri, int rj) {
        // 양수로의 집합인지 체크
        for(int i=li; i<=ri; i++) {
            for(int j=lj; j<=rj; j++) {
                tempCnt++;
                if(map[i][j] < 0) return false;
            }
        }


        return true;
    }
}