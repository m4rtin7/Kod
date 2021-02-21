import LISTTestScoring.LISTTestScoring;
import org.junit.BeforeClass;

import java.util.Random;

import static org.junit.Assert.*;

public class TestKruh {

    private static LISTTestScoring scoring = null;

    @BeforeClass
    public static void initScoring() {
        scoring = new LISTTestScoring();
        scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
    }
    public static int mojemrezoveBody(double sx, double sy, double r) {
        int count = 0;
        for(long x = Math.round(Math.ceil(sx-r)); x <= Math.round(Math.floor(sx+r)); x++ ) {
            for(long y = Math.round(Math.ceil(sy-r)); y <= Math.round(Math.floor(sy+r)); y++ ) {
                if ((x-sx)*(x-sx)+(y-sy)*(y-sy) <= r*r) count++;
            }

        }
        return count;
    }
    @org.junit.Test
    public void testKruh() {
        {
            double sx = 0.5;
            double sy = 0.5;
            double r = 3;
            assertEquals("pre volanie mrezoveBody(" + sx + "," + sy + "," + r + ")" + " sa lisi ocakavany a vas vysledok",
                    mojemrezoveBody(sx, sy, r), Kruh.mrezoveBody(sx, sy, r));
        }
        Random rnd = new Random();
        for (int i = 1; i < 100; i++) {
            double sx = rnd.nextInt(100);
            double sy = rnd.nextInt(100);
            double r = rnd.nextInt(100);
            assertEquals("pre volanie mrezoveBody(" + sx + "," + sy + ","+ r + ")"+ " sa lisi ocakavany a vas vysledok",
                    mojemrezoveBody(sx,sy,r), Kruh.mrezoveBody(sx,sy,r));
        }
        TestKruh.scoring.updateScore("lang:common_list_test_scoring_name", 100);
    }
}