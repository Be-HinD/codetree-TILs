import java.io.*;
import java.util.*;

//Code Tree
public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];

        for (int i = 1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        heapSort(N);
        
        for(int i=1; i<=N; i++) sb.append(arr[i]).append(" "); 

        System.out.println(sb);

    }

    static void heapify(int n, int i) {
        int largest = i;
        int l = i*2;
        int r = i*2+1;

        //case 1. 가장 큰 노드 탐색
        if(l<=n && arr[l] > arr[largest]) {
            largest = l;
        }

        if(r<=n && arr[r] > arr[largest]) {
            largest = r;
        }

        //case 2. 가장 큰 노드가 현재 노드가 아닐 경우 재귀 진행
        if(largest != i) {
            swap(i, largest);
            heapify(n, largest);
        }
    }

    static void heapSort(int n) {
        //1. Max-heap 만들기
        for (int i = n / 2; i >= 1; i--) {
            heapify(n, i);
        }

        //2. 정렬
        for(int i=n; i>1; i--) {
            swap(1, i);
            heapify(i-1, 1);
        }
    }

    static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}