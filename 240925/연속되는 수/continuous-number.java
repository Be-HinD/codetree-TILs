import java.io.*;
import java.util.*;
public class Main {
    static int N, res;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        Set<Integer> set = new HashSet<>();

        arr = new int[N];
        for(int i=0; i<N; i++) {
            int idx = Integer.parseInt(br.readLine());
            set.add(idx);
            arr[i] = idx;
        }

        for(int idx : set) {
            int prev = arr[0];
            int temp = 1;
            for(int i=0; i<N; i++) {
                if(arr[i] == idx) {
                    continue;
                }
                if(arr[i] == prev) temp++;
                else {
                    res = Math.max(res, temp);
                    temp = 1;
                }
                prev = arr[i];
            }
        }

        System.out.println(res);
    }
}