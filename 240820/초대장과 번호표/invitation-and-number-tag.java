import java.io.*;
import java.util.*;

//CodeTree
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //사람 수
        int G = Integer.parseInt(st.nextToken());   //그룹 수

        Set<Integer> set = new HashSet<>();

        set.add(1);

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<=G; i++) list.add(new ArrayList<>());

        for(int i=0; i<G; i++) {    //인접 리스트 생성
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());  //i번째 그룹 인원 수
            for(int j=0; j<people; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.get(i+1).add(num);
            }
        }

        while(true) {
            boolean flag = true;
            for (int i = 1; i <= G; i++) {
                int cnt = 0;
                int temp = -1;
                for(int idx : list.get(i)) {
                    if(set.contains(idx)) {
                        cnt++;
                    }
                    else {
                        temp = idx;
                    }
                }
                if(cnt == list.get(i).size()-1) {
                    set.add(temp);
                    flag = false;
                }
            }
            if(flag) break;
        }

        System.out.println(set.size());




    }
}