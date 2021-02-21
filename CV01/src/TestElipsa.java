import LISTTestScoring.LISTTestScoring;
import org.junit.BeforeClass;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TestElipsa {

    private static LISTTestScoring scoring = null;

    @BeforeClass
    public static void initScoring() {
        scoring = new LISTTestScoring();
        scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
    }
    public static int mojemrezoveBody(double sx, double sy, double rx, double ry) {
        int count = 0;
        for (long i = Math.round(sx - rx); i <= Math.round(sx + rx); i++) {
            for (long j = Math.round(sy - ry); j <= Math.round(sy + ry); j++) {
                if (((i - sx)*(i - sx)/(rx*rx) + (j - sy)*(j - sy)/(ry*ry)) <= 1)
                    count++;
            }
        }
        return count;
    }
    @org.junit.Test
    public void testElipsa() {
        {
            double sx = 0.5;
            double sy = 0.5;
            double rx = 3;
            double ry = 4;
            assertEquals("pre volanie mrezoveBody(" + sx + "," + sy + "," + rx + ","+ ry + ")" + " sa lisi ocakavany a vas vysledok",
                    mojemrezoveBody(sx, sy, rx, ry),
                    Elipsa.mrezoveBody(sx, sy, rx, ry));
        }
        {
            double sx = 6;
            double sy = 6;
            double rx = 1;
            double ry = 3;
            assertEquals("pre volanie mrezoveBody(" + sx + "," + sy + "," + rx + ","+ ry + ")" + " sa lisi ocakavany a vas vysledok",
                    mojemrezoveBody(sx, sy, rx, ry),
                    Elipsa.mrezoveBody(sx, sy, rx, ry));
        }
        {
            double sx = 6.3;
            double sy = 5.2;
            double rx = 3;
            double ry = 3;
            assertEquals("pre volanie mrezoveBody(" + sx + "," + sy + "," + rx + ","+ ry + ")" + " sa lisi ocakavany a vas vysledok",
                    mojemrezoveBody(sx, sy, rx, ry),
                    Elipsa.mrezoveBody(sx, sy, rx, ry));
        }
        {
            double sx = 4.5;
            double sy = 4.5;
            double rx = 4;
            double ry = 3;
            assertEquals("pre volanie mrezoveBody(" + sx + "," + sy + "," + rx + ","+ ry + ")" + " sa lisi ocakavany a vas vysledok",
                    mojemrezoveBody(sx, sy, rx, ry),
                    Elipsa.mrezoveBody(sx, sy, rx, ry));
        }



        Random rnd = new Random();
        for (int i = 1; i < 100; i++) {
            double sx = rnd.nextInt(100);
            double sy = rnd.nextInt(100);
            double rx = 1+rnd.nextInt(100);
            double ry = 1+rnd.nextInt(100);
            assertEquals("pre volanie mrezoveBody(" + sx + "," + sy + ","+ rx + ","+ ry + ")"+ " sa lisi ocakavany a vas vysledok",
                    mojemrezoveBody(sx,sy,rx, ry),
                    Elipsa.mrezoveBody(sx,sy,rx, ry));
        }
        TestElipsa.scoring.updateScore("lang:common_list_test_scoring_name", 100);
    }
}