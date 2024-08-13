import java.io.*;
import java.util.*;

//Code Tree
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> st = new Stack<>();

        boolean flag = true;
        for(int i=0; i<input.length(); i++) {
            char idx = input.charAt(i);

            if(idx == '(') {
                st.push(idx);
            }
            else {
                if(st.isEmpty()) {
                    flag = !flag;
                    break;
                }
                st.pop();
            }
        }

        if(!flag || !st.isEmpty()) {
            System.out.println("No");
        }
        else {
            System.out.println("Yes");
        }

    }
}