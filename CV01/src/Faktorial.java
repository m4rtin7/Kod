public class Faktorial {
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

    public static void main(String[] args) {
        System.out.println(faktorial(5));
    }
}
