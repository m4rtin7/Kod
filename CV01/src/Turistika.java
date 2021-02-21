public class Turistika {
    public static boolean euklidovska(String trasa, double tolerancia) {
        return vzdialenost(trasa, tolerancia, true);
    }
    public static boolean manhatanska(String trasa, int tolerancia) {
        return vzdialenost(trasa, tolerancia, false);
    }
    private static boolean vzdialenost(String trasa, double tolerancia,
                                       boolean euklidovska) {
       long x = 0, y = 0, cislo = 0;
       int dx = 1, dy = 0;
       int new_dx, new_dy;
       for (char ch : trasa.toCharArray()) {
           if (Character.isDigit(ch)) {  // netocim sa, len si pocitam novy vzdialenost
               cislo = 10L*cislo+(ch-'0');
           } else if (ch == 'L' || ch == 'P') { // tocim sa
               x += cislo * dx;     // kracam cislo krokov
               y += cislo * dy;
               cislo = 0;
               if (ch == 'L') { // dolava
                   new_dx = -dy;
                   new_dy = dx;
               } else { // doprava
                   new_dx = dy;
                   new_dy = -dx;
               }        // som vytoceny
               dx = new_dx;
               dy = new_dy;
           } else {
               System.out.println("nieco divne sa stalo");
           }
       }
        x += cislo * dx;        // toto neradno zabudnut, poslenda streka...
        y += cislo * dy;
       //System.out.println("x:" + x + ", y:" + y);
       return (euklidovska)?
                Math.sqrt( (x*x) + (y*y)) <= tolerancia:
                Math.abs(x) + Math.abs(y) <= tolerancia;
    }
    public static void main(String[] args) {
        System.out.println(euklidovska("100L50P97", 0)); // true
        System.out.println(euklidovska("10L1L9", 2)); // true
        System.out.println(euklidovska("10P1P9", 1)); // false
    }
}
