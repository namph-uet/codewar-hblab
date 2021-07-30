import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get number of testcase (first line)
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            // read testcase
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int count = in.nextInt();

            if(divisionBy41(a,b,c, count)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            // PROCESS CODE HERE
        }
        System.out.println();
    }

    static boolean divisionBy41(int a0, int a1, int c, int count) {
        if(count == 1 && a0 == 0) return true;
        if(count < 2) return false;
        int []digit = new int[count];
        digit[0] = a0;
        digit[1] = a1;

        for(int i = 2; i < count; i++) {
            digit[i] = (digit[i-1] * c + digit[i-2]) % 10;
        }
        StringBuilder numStr = new StringBuilder();
        for(int i = 0; i < count; i++) {
            numStr.append(Integer.toString(digit[i]));
        }
        int num = Integer.parseInt(numStr.toString());
        if(num % 41 == 0) return true;
        return false;
    }
}
