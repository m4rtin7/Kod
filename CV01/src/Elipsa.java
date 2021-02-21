public class Elipsa {

    public static int mrezoveBody(double sx, double sy, double rx, double ry) {
        int count = 0;
        for (long i = Math.round(sx - rx); i <= Math.round(sx + rx); i++) {
            for (long j = Math.round(sy - ry); j <= Math.round(sy + ry); j++) {
                if (((i - sx)*(i - sx)/(rx*rx) + (j - sy)*(j - sy)/(ry*ry)) <= 1)
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        //System.out.println(mrezoveBody(0,0,2));
        System.out.println(mrezoveBody(4.5,4.5, 4,3));
        System.out.println(mrezoveBody(6.3, 5.2, 3, 3));
        System.out.println(mrezoveBody(6, 6, 1, 3)  );
    }
}
