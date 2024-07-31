import java.io.*;
import java.util.*;

//CodeTree
public class Main {
    static int N, T;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());   //한 층의 컨베이어 개수
        T = Integer.parseInt(st.nextToken());   //시간

        arr = new int[N*2];

        int p = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[p++] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[p++] = Integer.parseInt(st.nextToken());
        }

        while(T-- > 0) {
            int temp = arr[arr.length-1];

            for(int i=arr.length-1; i>=1; i--) {
                arr[i] = arr[i-1];
            }
            arr[0] = temp;
        }

        p = 0;
        for(int i=0; i<N; i++) sb.append(arr[p++]).append(" ");
        sb.append("\n");
        for(int i=0; i<N; i++) sb.append(arr[p++]).append(" ");

        System.out.println(sb);

    }
}