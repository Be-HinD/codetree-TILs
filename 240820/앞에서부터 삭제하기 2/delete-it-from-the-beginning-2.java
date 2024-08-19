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
        for(int i=0; i<N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        while(pq.size() != 2) {
            pq.poll();
        }

        int sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        double res = (double) sum / 2;
        String formattedNumber = String.format("%.2f", res);

        System.out.println(formattedNumber);
    }
}