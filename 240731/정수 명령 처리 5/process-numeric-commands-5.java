import java.util.*;
import java.io.*;
public class Main {
    static int Q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Q = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch(order) {
                case "push_back":
                idx = Integer.parseInt(st.nextToken());
                list.add(idx);
                break;
                case "get":
                idx = Integer.parseInt(st.nextToken())-1;
                if(list.size() > idx) {
                    sb.append(list.get(idx)).append("\n");
                }
                break;
                case "pop_back":
                if(!list.isEmpty()) {
                    list.remove(list.size()-1);
                }
                break;
                case "size":
                sb.append(list.size()).append("\n");
                break;
            }
        }
        
        System.out.println(sb);

    }
}