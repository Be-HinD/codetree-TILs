import java.io.*;
import java.util.*;

//CodeTree
public class Main {
    static int N, idx;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        LinkedList<Integer> list = new LinkedList<>();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push_front":
                    idx = Integer.parseInt(st.nextToken());
                    list.addFirst(idx);
                    break;
                case "push_back":
                    idx = Integer.parseInt(st.nextToken());
                    list.addLast(idx);
                    break;
                case "pop_front":
                    if(!list.isEmpty()) {
                        sb.append(list.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if(!list.isEmpty()) {
                        sb.append(list.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(list.size()).append("\n");
                    break;
                case "empty":
                    if(list.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(!list.isEmpty()) {
                        sb.append(list.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(!list.isEmpty()) {
                        sb.append(list.peekLast()).append("\n");
                    }
            }
        }

        System.out.println(sb);

    }
}