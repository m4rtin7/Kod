public class Trpaslici {
    public static int pocetMoznosti(int n) {
        int count = 0;
        for(int a=1;a <= n; a++) {
            if (n % a > 0) continue;
            for(int b=a;b <= n; b++) { // b >= a
                if (n % b > 0) continue;
                int c = n/(a*b);
                if (c < b) continue;
           //     for(int c=b;c <= n; c++) { // c >= b
           //         if (n % c > 0) continue;
                    if (a*b*c == n) {
                        System.out.println(a + "x" + b + "x" + c);
                      count++;
                    }
               // }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(pocetMoznosti(30));
        //System.out.println(pocetMoznosti(2027));
//        System.out.println(pocetMoznosti(1024 * 1024));

    }


}
