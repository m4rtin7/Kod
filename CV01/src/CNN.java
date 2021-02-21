public class CNN {
    public static long cnn(){
        long result = 10;
        while(true){
            if (!je_prvoc(result)){
                result++;
                continue;
            }
            String n1 = Long.toString(result,2);
            String n2 = Long.toString(result);
            n2 = otoc(n2);
            long pom = Long.valueOf(n2);
            if (!je_prvoc(pom)){
                result++;
                continue;
            }
            n2 = Long.toString(pom, 2);
            if(je_palindrom(n1) && je_palindrom(n2)){
                return result;
            }
            result++;
        }
    }

    public static boolean je_palindrom(String slovo){
        char [] s = slovo.toCharArray();
        for(int i = 0; i < s.length / 2; i++) {
            if (s[i] != s[s.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
    public static String otoc(String slovo){
        char [] s = slovo.toCharArray();
        String result = "";
        for(int i = s.length - 1; i >= 0; i--) {
            result = result + s[i];
        }
        return result;
    }
    public static boolean je_prvoc(long num){
        for(long i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(cnn());
    }
}