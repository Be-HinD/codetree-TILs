import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {return o2[0] - o1[0];});
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{x,i,0});
            pq.offer(new int[]{y,i,1});
        }

        Set<Integer> set = new HashSet<>();
        int res = 0;
        int cnt = 0;
        int left = 0;
        int right = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(set.contains(cur[1])) continue;
            if(cur[2] == 0 && left > 15) continue;
            if(cur[2] == 1 && right > 15) continue;

            if(cur[2] == 0) left++;
            if(cur[2] == 1) right++;
            res += cur[0];
            set.add(cur[1]);
            cnt++;
            if(cnt == 30) break;
        }

        System.out.println(res);
    }
}