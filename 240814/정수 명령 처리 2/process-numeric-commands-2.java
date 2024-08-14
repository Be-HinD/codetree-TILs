import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//BOJ_10845 뀨
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            switch(oper) {
                case "push":
                    int idx = Integer.parseInt(st.nextToken());
                    q.offer(idx);
                    break;
                case "front":
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.getFirst()).append("\n");
                    break;
                case "back":
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.getLast()).append("\n");
                    break;
                case "pop":
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.poll()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
            }
        }

        System.out.println(sb);
    }
}