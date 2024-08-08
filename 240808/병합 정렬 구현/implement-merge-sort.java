import java.io.*;
import java.util.*;

//Code Tree
public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length-1);

        for(int i=0; i<N; i++) sb.append(arr[i]).append(" ");

        System.out.println(sb);

    }

    static void mergeSort(int arr[], int low, int high) {
        if(low < high) {
            final int mid = low + (high-low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int k = low;

        int[] merged = new int[N];

        while(i<=mid && j<=high) {
            if(arr[i] <= arr[j]) {
                merged[k++] = arr[i++];
            }
            else {
                merged[k++] = arr[j++];
            }
        }

        while(i <= mid) {
            merged[k++] = arr[i++];
        }

        while(j <= high) {
            merged[k++] = arr[j++];
        }

        for(int l=low; l<=high; l++) {
            arr[l] = merged[l];
        }
    }
}