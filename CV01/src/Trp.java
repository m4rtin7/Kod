public class Trp {

    public static int pocetMoznosti(int n) {
        int count = 0;
        for(int a=1; a <=n; a++)  {
            if (n % a > 0) continue;
            for(int b=a; b <=n; b++) {
                if ((n/a) % b > 0) continue;
                for (int c = b; c <= n; c++) {
                    if ((n/(a*b)) % c > 0) continue;
                    if (a*b*c == n) {
                        System.out.println(a + " x " + b + " x " + c + " x ");
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(pocetMoznosti(36));
        System.out.println(pocetMoznosti(1024*1024));
    }
}
