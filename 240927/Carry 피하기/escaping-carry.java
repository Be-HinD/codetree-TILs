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

        DFS(0, map, 0);

        System.out.println(res);
    }

    private static void DFS(int p, Map<Integer,Integer> list, int cnt) {
        // 현재 인덱스가 범위를 벗어나면 종료
        if (p >= N) {
            res = Math.max(res, cnt);  // 선택한 숫자의 최대 개수를 갱신
            return;
        }

        // 현재 숫자를 선택하지 않는 경우
        DFS(p + 1, list, cnt);

        // 현재 숫자를 선택할 수 있는지 체크
        String idx = String.valueOf(arr[p]);
        boolean flag = true;
        Map<Integer, Integer> newMap = new HashMap<>(list);  // 새로운 Map 복사
        int num = 1;

        // 자릿수별로 carry가 발생하는지 확인
        for (int i = idx.length() - 1; i >= 0; i--) {
            int temp = newMap.getOrDefault(num, 0) + (idx.charAt(i) - '0');
            if (temp >= 10) {  // carry가 발생하면 flag를 false로 설정
                flag = false;
                break;
            }
            newMap.put(num, temp);  // 자릿수별로 업데이트
            num++;
        }

        // carry가 발생하지 않으면 해당 숫자를 선택한 경우로 DFS 호출
        if (flag) {
            DFS(p + 1, newMap, cnt + 1);
        }


    }
}