import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxSubArraySumModulo {
  public static int maxSubArrModulo(int[]a, int mod){
    int curr_tot = a[0]%mod;
    int tot_now = a[0]%mod;
    for(int i=1;i< a.length;i++){
      curr_tot = Math.max(a[i]%mod,(curr_tot+a[i])%mod);
      tot_now = Math.max(curr_tot,tot_now);
    }
    return tot_now;
  }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner s = new Scanner(System.in);
      int t_case = Integer.parseInt(s.nextLine());
      String[] line1;
      String[] line2;
      int [] a;
      for(int i=0;i<t_case;i++){
        line1 = s.nextLine().split(" ");
        int mod = Integer.parseInt(line1[1]);
        line2 = s.nextLine().split(" ");
        a = new int[line2.length];
        for(int j = 0;j< line2.length;j++){
          a[j] = Integer.parseInt(line2[j]);
        }
        System.out.println(MaxSubArraySumModulo.maxSubArrModulo(a,mod));
      }
    }
}