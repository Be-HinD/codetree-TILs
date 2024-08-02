import java.io.*;
import java.util.*;

//Code Tree
public class Main {
    static int N, Q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        List<Character> list = new LinkedList<>();

        ListIterator<Character> it;

        String input = br.readLine();
        for(int i=0; i<N; i++) list.add(input.charAt(i));

        it = list.listIterator();



        //it 포인터 맨 뒤로 이동
        while (it.hasNext()) {
            it.next();
        }

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("L")) {
                if(it.hasPrevious()) it.previous();
            }
            else if(order.equals("P")) {
                char idx = st.nextToken().charAt(0);
                it.add(idx);
            }
            else if(order.equals("R")) {
                if(it.hasNext()) it.next();
            }
            else if(order.equals("D")) {
                if(it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
            else {
                it.add('&');
                it.next();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char idx : list) {
            sb.append(idx);
        }

        System.out.println(sb);
    }
}