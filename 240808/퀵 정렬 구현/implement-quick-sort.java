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
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, arr.length - 1);

        for(int idx : arr) sb.append(idx).append(" ");

        System.out.println(sb);
    }

    static int selectPivot(int low, int high) {
        int diff = high - low;
        if (diff <= 2) {
            return high;
        } else {
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            pq.offer(new int[]{low, arr[low]});
            pq.offer(new int[]{high, arr[high]});
            pq.offer(new int[]{low + (high - low) / 2, arr[low + (high - low) / 2]});
            pq.poll();
            return pq.poll()[0]; // 피벗의 인덱스를 반환
        }
    }

    static int partition(int low, int high) {
        int pivotIndex = selectPivot(low, high);
        int pivot = arr[pivotIndex];
        swap(pivotIndex, high); // 피벗을 끝으로 이동
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    static void quickSort(int low, int high) {
        if (low < high) {
            int pos = partition(low, high);
            quickSort(low, pos - 1);
            quickSort(pos + 1, high);
        }
    }

    static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}