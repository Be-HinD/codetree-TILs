import java.io.*;
import java.util.*;

public class Main {
    static int N, queryLength, dist, res;
    static int[][] map;
    static int[] dx = new int[]{-1,0,1,0};  //위,왼,아,오
    static int[] dy = new int[]{0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        queryLength = Integer.parseInt(st.nextToken());

        Queue<Character> q = new ArrayDeque<>();
        String query = br.readLine();
        for(int i=0; i<queryLength; i++) q.offer(query.charAt(i));

        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nx = (N-1) / 2;
        int ny = (N-1) / 2;
        res += map[nx][ny];
        while(!q.isEmpty()) {
            char command = q.poll();
            if(command == 'F') {
                //전진
                if(isRangeCheck(nx+dx[dist], ny+dy[dist])) {
                    //전진 가능할 때만
                    nx += dx[dist];
                    ny += dy[dist];
                    res += map[nx][ny];
                }
            }
            else if(command == 'L') {
                //왼쪽
                dist = (dist + 1) % 4;
            }
            else {
                //오른쪽
                if(dist == 0) dist = 3;
                else dist = (dist-1) % 4;
            }

        }

        System.out.println(res);
    }

    static boolean isRangeCheck(int x, int y) {
        if(x>0 && x<N && y>0 && y<N) return true;
        return false;
    }
}