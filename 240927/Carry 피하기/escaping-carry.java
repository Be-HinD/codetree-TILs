import java.io.*;
import java.util.*;

//CodeTree
public class Main {
    static int N, res;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=1; i<10; i++) map.put(i, 0);

        DFS(0, map, 0);

        System.out.println(res);
    }

    private static void DFS(int p, Map<Integer,Integer> list, int cnt) {
        //현재 선택된 원소에서 p원소를 추가 가능한지
        res = Math.max(res, cnt);
        if(p >= N) return;
        String idx = String.valueOf(arr[p]);
        boolean flag = true;
        int num = 1;
        for(int i=idx.length()-1; i>=0; i--) {
            int temp = list.getOrDefault(num++, 0) + (idx.charAt(i) - '0');
            if(temp >= 10) {
                flag = false;
                break;
            }
        }

        //p원소 선택한 Case 및 선택하지 않은 Case 모두 재귀호출
        if(flag) {
            Map<Integer, Integer> chMap = new HashMap<>();
            List<Integer> chList = new ArrayList<>();
            num = 1;
            for(int i=idx.length()-1; i>=0; i--) {
                chMap.put(num, chMap.getOrDefault(num, 0) + (idx.charAt(i) - '0'));
                num++;
            }
            DFS(p+1, chMap, cnt+1);
        }

        DFS(p+1, list, cnt);

    }
}