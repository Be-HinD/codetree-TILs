import java.io.*;
import java.util.*;

//CodeTree
public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //사람 수
        int G = Integer.parseInt(st.nextToken());   //그룹 수

        Set<Integer> set = new HashSet<>();

        set.add(1);

        for(int i=0; i<G; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());  //i번째 그룹 인원 수
            int cnt = 0;
            int temp = -1;
            for(int j=0; j<people; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)) {
                    cnt++;
                }
                else {
                    temp = num;
                }
            }
            if(cnt == people-1) {
                set.add(temp);
            }
        }

        System.out.println(set.size());



    }
}