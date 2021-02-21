import java.util.ArrayList;
import java.util.Arrays;

public class KombinacneCislo {

    public static long faktorial(int n) {
        long res = 1L;
//        while (n-- > 1) res *= n;
//        do
//            res *= n;
//        while (n-- > 1);
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static long sucin(int from, int to) {
        long res = 1L;
        while (from <= to) {
            res *= from;
            from++;
        }
        return res;
    }

    public static long sucin1(int from, int to) {
        if (from > to) return 1;
        else if (from == to) return from;
        else {
            int mid = (from+to)/2;
            return sucin1(from, mid) * sucin1(mid+1, to);
        }
    }

    public static long nad2(int n, int k) {
        if (k == 0 || k == n) return 1;
        else return nad2(n-1, k-1) + nad2(n-1,k);
    }

    public static long nad1(int n, int k) {
        return sucin(n-k+1, n) / sucin(1,k);
    }
    public static long nad(int n, int k) {
        return (k < n/2)?nad1(n,k):nad1(n,n-k);
    }
    public static void main(String[] args) {
        //String s = acka(1_000_000);
        String s1 = acka1(1_000_000);
        int count = 0;
        for (char ch : s1.toCharArray()) count++;
        for (int i = 0; i < s1.length(); i++) count++;
        System.out.println(count);


        System.out.println(sucin(1,10));
        System.out.println(sucin1(1,10));
        System.out.println(nad2(4,2));
        System.out.println(bindlzka(10));
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        System.out.println(al);
        System.out.println(Arrays.asList(new Integer[]{1,2,3}));
        System.out.println(new Integer[]{1,2,3});
        for (int n = 0; n < 66; n++) {
            for(int k=0; k <= n; k++) {
                System.out.print(nad(n,k) + "\t");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        final int MAX = 100;
//        long[] a = new long[MAX];
//        a[0] = 1;
//        int n = 1;
//        finito:
//        do {
//            for(int k = n; k >= 0; k--) {
//                a[k] = a[k]+((k==0)?0:a[k-1]);
//                System.out.print(a[k] + "(" + k + ")\t");
//                if (a[k] < 0) {
//                    break finito;
//                    // comb(67,29) = comb(67,38)
//                }
//            }
//            System.out.println();
//        } while (++n < MAX);
//    }

    //---
                    //    long[] b = new long[MAX];
                    //    b[0] = 1;
                    //            System.out.print(b[0] + "(" + 1 + ")\t");
                    //            for(int k = 1; k <= n; k++) {
                    //        b[k] = a[k-1] + a[k];
                    //        System.out.print(b[k] + "(" + k + ")\t");
                    //        if (b[k] < 0) {
                    //            break finito;
                    //            // comb(67,29) = comb(67,38)
                    //        }
                    //    }
                    //           System.out.println();
                    //    a = b;

//        } while (++n < MAX);
//    }

    public static int bindlzka(int n) {
        if (n == 0)
            return 0;
        else
            return 1+bindlzka(n>>1);
    }

    public static String acka(int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            res += "a";
        }
        return res;
    }

    public static String acka1(int n) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < n; i++) {
            res.append("a");
        }
        return res.toString();
    }

//    public static String zakoduj(String vstup, String spoluhlasky) {
//        String samohlasky = "aeiouy";
//        int i = 0;
//        StringBuilder sb = new StringBuilder();
//        for (char ch : vstup.toCharArray()) {
//            sb.append(ch);
//            if (samohlasky.contains(""+Character.toLowerCase(ch))) {
//                sb.append(spoluhlasky.charAt(i));
//                i = (i + 1) % spoluhlasky.length();
//                sb.append(Character.toLowerCase(ch));
//            }
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(zakoduj("Mama ma Emu.", "p")); // Mapamapa mapa Epemupu.
//        System.out.println(zakoduj("Mama ma Emu.", "bcd")); // Mabamaca mada Ebemucu.
//        System.out.println(zakoduj("Kobyla ma maly bok.","p")); // Kopobypylapa mapa mapalypy bopok.
//        System.out.println(zakoduj("Kobyla ma maly bok.", "bcd")); // Kobobycylada maba macalydy bobok.
//        System.out.println(zakoduj("Kobyla ma maly bok.", "xyz")); // Koxobyyylaza maxa mayalyzy boxok.
//        System.out.println(zakoduj("Povedali nasi vasim, aby prisli vasi k nasim, ak nepridu vasi k nasim, tak nepridu nasi k vasim.", "p"));
////Popovepedapalipi napasipi vapasipim, apabypy pripislipi vapasipi k napasipim, apak nepepripidupu vapasipi k napasipim, tapak nepepripidupu napasipi k vapasipim.
//
//        System.out.println(zakoduj("Povedali nasi vasim, aby prisli vasi k nasim, ak nepridu vasi k nasim, tak nepridu nasi k vasim.", "hjb"));
////Pohovejedabalihi najasibi vahasijim, ababyhy prijislibi vahasiji k nabasihim, ajak nebeprihiduju vabasihi k najasibim, tahak nejepribiduhu najasibi k vahasijim.
//    }



}
