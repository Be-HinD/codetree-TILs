import java.io.*;
import java.util.*;
public class Main {
    static int N, M, sx, sy, res;
    static int[][] map;
    static boolean[][] target;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
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

        target = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    sx = i;
                    sy = j;
                    target[i][j] = true;
                    continue;
                }
                target[i][j] = false;
            }
        }

        /**
        D값으로 조건이 만족되는지 체크
        
        **/
        binarySearch();

        System.out.println(res);

    }

    private static void binarySearch() {
        int low = 0;
        int high = Integer.MAX_VALUE;

        while(low < high) {
            final int mid = low + (high-low)/2;

            //Logic 추가
            if(bfs(mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        res = high;
    }

    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    private static boolean bfs(int D) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        boolean[][] v = new boolean[N][M];
        v[sx][sy] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(!isRange(nx,ny) || v[nx][ny]) continue;

                int dist = Math.abs(map[nx][ny] - map[cur[0]][cur[1]]);
            
                if(dist > D) continue;

                q.offer(new int[]{nx,ny});
                v[nx][ny] = true;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // if(v[i][j]) System.out.print(1 + " ");
                // else System.out.print(0 + " ");
                if(target[i][j] && !v[i][j]) return false;
            }
            // System.out.println();
        }

        return true;
    }
    private static boolean isRange(int nx, int ny) {
        if(nx<0 || ny<0 || nx>=N || ny>=M) return false;
        return true;
    }
}