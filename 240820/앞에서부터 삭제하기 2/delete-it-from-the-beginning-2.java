import java.io.*;
import java.util.*;

//CodeTree
public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        double sum = arr[N-1] + arr[N-2];

        pq.offer(arr[N-1]);
        pq.offer(arr[N-2]);

        //현재 평균값
        double res = (sum - pq.peek()) / (pq.size()-1);

        for(int i=N-3; i>0; i--) {
            pq.offer(arr[i]);
            sum += arr[i];

            res = Math.max(res, (sum - pq.peek()) / (pq.size()-1));
        }

        String ans = String.format("%.2f", res);

        System.out.println(ans);



    }
}