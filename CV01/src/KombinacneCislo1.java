import java.util.Arrays;

public class KombinacneCislo1 {
    public static void main(String[] args) {
        final int MAX = 100;
        long[] a = new long[MAX];
        a[0] = 1;
        int n = 1;
        finito:
        do {
//           for(int k = n; k >= 0; k--) {
//               a[k] = a[k]+((k==0)?0:a[k-1]);
//               System.out.print(a[k] + "(" + k + ")\t");
//               if (a[k] < 0) {
//                   break finito;
//                   // comb(67,29) = comb(67,38)
//               }
//           }
            long[] b = new long[MAX];
            b[0] = 1;
            System.out.print(b[0] + "(" + 1 + ")\t");
            for(int k = 1; k <= n; k++) {
                b[k] = a[k-1] + a[k];
               System.out.print(b[k] + "(" + k + ")\t");
               if (b[k] < 0) {
                   break finito;
                   // comb(67,29) = comb(67,38)
               }
            }
           System.out.println();
           a = b;
        } while (++n < MAX);
    }
}
