import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        // 주어지는 수 배열에 담기
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        // 백트래킹
        backtracking(0, 0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void backtracking(int count, int depth, int sum) {
        // 이전까지 최대 개수(result)와 현재까지 구한 개수(count) 중 큰 값으로 갱신
        result = Math.max(result, count);

        // 모든 arr을 탐색했다면 종료
        if (depth == n) {
            return;
        }

        // arr 순회
        for (int i = depth; i < n; i++) {
            // carry가 발생하지 않았다면
            if (isNotCarry(sum, arr[i])) {
                // count, index 증가시키고, sum과 arr[i]를 더한 후
                // backtracking 재귀 호출
                backtracking(count + 1, i + 1, sum + arr[i]);
            }
        }
    }

    private static boolean isNotCarry(int sum, int target) {
        // sum 또는 target의 자릿수를 모두 사용할 때까지 반복
        while (sum > 0 || target > 0) {
            // 현재 자릿수 추출
            int num1 = sum % 10;
            int num2 = target % 10;

            // 현재 자릿수들의 합이 carry가 발생하는지 확인
            if (num1 + num2 >= 10) {
                return false;
            }

            // 다음 자릿수 합 비교
            sum /= 10;
            target /= 10;
        }

        // 반복문이 정상으로 종료되면 carry가 발생하지 않음
        return true;
    }
}