import java.io.*;
import java.util.*;

//CodeTree 삼성 기출
public class Main {
    static class GOLEM {
        int x;
        int y;
        int exit;

        public GOLEM(int x, int y, int exit) {
            this.x = x;
            this.y = y;
            this.exit = exit;
        }
    }
    static int R, C, K, P, res;
    static int[][] map;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 골렘의 크기 마스킹과 동시에 출구를 별도로 마스킹
         * 만약 현재 위치하고 있는 골렘의 출구가 다른 골렘과 인접하고 있다면 해당 출구를 통해 다른 골렘으로 이동
         * 0,1,2,3은 북, 동, 남, 서쪽
         * **/

        R = Integer.parseInt(st.nextToken());   //숲의 크기
        C = Integer.parseInt(st.nextToken());   //숲의 크기
        K = Integer.parseInt(st.nextToken());   //정령의 수

        map = new int[R][C];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            GOLEM cur = new GOLEM(0, c, d);
            P++;
            if(!move(cur)) continue;
//            System.out.println("Step2. 이동이 끝난 후 : ");
//            for (int j = 0; j < R; j++) {
//                System.out.println(Arrays.toString(map[j]));
//            }
//            System.out.println();

            res += goToDown(cur);
        }

        System.out.println(res);

    }

    private static boolean move(GOLEM cur) {
        for(int i=0; i<4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
            if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
            if(map[nx][ny] != 0) {
//                System.out.println("초기화");
                map = new int[R][C];
                return false;
            }
        }

        //Step1. 아래로 떨어지기 d = 2
        while(true) {
            int cx = cur.x + 1;
            if(cx > R-2) break;
            boolean flag = true;
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cur.y + dy[i];
                if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
                if(map[nx][ny] != 0) flag = false;
            }
            if(!flag) break;
            cur.x++;
        }

//        System.out.println("Step1. 떨어지는 로직 : " + cur.x + " : " + cur.y);

        //Step2. 서쪽 or 동쪽 판단 및 이동
        while(true) {
            if(cur.x == R-2) break;    //맨 아래로 떨어진 시점.
            if(isWest(cur)) {
                cur.x++;
                cur.y--;
                cur.exit--;
                if(cur.exit < 0) cur.exit = 3;
            }
            else if(isEest(cur)) {
                cur.x++;
                cur.y++;
                cur.exit++;
                if(cur.exit > 3) cur.exit = 0;
            }
            else break;
        }

        //Step3. 중심 기준 맵 마스킹
        map[cur.x][cur.y] = -2;
        for(int i=0; i<4; i++) {
            if(i == cur.exit) {
                map[cur.x+dx[i]][cur.y+dy[i]] = -1;
                continue;
            }
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
            map[nx][ny] = P;
        }

        return true;
    }

    private static boolean isWest(GOLEM idx) {
        if(idx.y < 2) return false;

        if(idx.x != 0) {
            if (map[idx.x - 1][idx.y - 1] != 0)
                return false;
        }
        if(map[idx.x][idx.y-2] != 0) return false;
        if(map[idx.x+1][idx.y+1] != 0) return false;
        if(map[idx.x+1][idx.y-2] != 0) return false;
        if(map[idx.x+2][idx.y-1] != 0) return false;

        return true;
    }

    private static boolean isEest(GOLEM idx) {
        if(idx.y >= C-2) return false;

        if(idx.x != 0) {
            if (map[idx.x - 1][idx.y + 1] != 0)
                return false;
        }
        if(map[idx.x][idx.y+2] != 0) return false;
        if(map[idx.x+1][idx.y+1] != 0) return false;
        if(map[idx.x+1][idx.y+2] != 0) return false;
        if(map[idx.x+2][idx.y+1] != 0) return false;

        return true;
    }

    private static int goToDown(GOLEM cur) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{cur.x, cur.y, map[cur.x][cur.y]});
        boolean[][] v = new boolean[R][C];
        v[cur.x][cur.y] = true;

        int max = cur.x + 1;
        while(!q.isEmpty()) {
            int[] idx = q.poll();
            max = Math.max(max, idx[0]);

//            System.out.println(Arrays.toString(idx));
            //중심지인 경우 사방탐색 결과 모두 q 추가
            if(idx[2] == -2) {
                for (int i = 0; i < 4; i++) {
                    int nx = idx[0] + dx[i];
                    int ny = idx[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                    if(v[nx][ny]) continue;
                    q.offer(new int[]{nx, ny, map[nx][ny]});
                    v[nx][ny] = true;
                }
            }
            else {
                for(int i=0; i<4; i++) {
                    int nx = idx[0] + dx[i];
                    int ny = idx[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                    if(idx[2] == -1) {
                        if(map[nx][ny] == 0 || v[nx][ny]) continue;
                        q.offer(new int[]{nx,ny,map[nx][ny]});
                        v[nx][ny] = true;
                    }
                    else {
                        if(map[nx][ny] == -2) {
                            q.offer(new int[]{nx,ny,map[nx][ny]});
                            v[nx][ny] = true;
                        }
                        if(map[nx][ny] != idx[2] || v[nx][ny]) continue;
                        q.offer(new int[]{nx,ny,map[nx][ny]});
                        v[nx][ny] = true;
                    }

                }
            }
        }
//        System.out.println("정령 이동 값 : " + (max+1));
        return max+1;
    }
}