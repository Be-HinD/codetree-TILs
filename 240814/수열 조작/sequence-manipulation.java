import java.io.*;
import java.util.*;

//CodeTree
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        for(int i=1; i<=N; i++) dq.addLast(i);

        while(dq.size() != 1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }

        System.out.println(dq.pollFirst());
    }
}