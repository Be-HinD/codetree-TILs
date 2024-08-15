import java.io.*;
import java.util.*;

//CodeTree
public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        long res = 0;
        for(int i=0; i<N; i++) {
            long t = target - arr[i];
            int candidateValue = lowerbound(t);

            if(arr[candidateValue] != t) continue;

            int cnt = 1;
            for(int j=candidateValue+1; j<N; j++) {
                if(arr[j] != t) break;
                cnt++;
            }
            res += cnt;
        }

        System.out.println(res/2);
    }

    static int lowerbound(long t) {
        int low = 0;
        int high = arr.length-1;

        while(low<high) {
            final int mid = low + (high-low)/2;

            if(arr[mid] >= t) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}