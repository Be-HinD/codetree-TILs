import java.io.*;
import java.util.*;

//Code Tree
public class Main {
    static int N, res;
    static int[][] train;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        train = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());   //위치
            int speed = Integer.parseInt(st.nextToken());   //속도
            train[i][0] = point;
            train[i][1] = speed;
        }

        //만약 위치가 무조건 다르게 주어진다고 생각하면
        //뒤에서부터 탐색해서 현재 열차보다 앞 열차가 속도가 빠르다면 합치고, 현재 속도를 갱신
        //느리다면 느린 열차부터 다시 카운트

        int currentSpeed = train[N-1][1];
        for(int i=N-2; i>0; i--) {
            if(currentSpeed < train[i-1][1]) {
                currentSpeed = Math.min(currentSpeed, train[i-1][1]);
            }
            else {
                res++;
                currentSpeed = train[i-1][1];
            }
        }

        System.out.println(res+1);
    }
}