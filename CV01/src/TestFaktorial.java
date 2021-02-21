import static org.junit.Assert.*;

import LISTTestScoring.LISTTestScoring;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFaktorial {

    private static LISTTestScoring scoring = null;

    @BeforeClass
    public static void initScoring() {
        scoring = new LISTTestScoring();
        scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
    }

    @Test
    public void basicTest() {
        for (int i = 1; i < 20; i++) {
            assertEquals("faktorial "+ i,
                    sucin(1,i),
                    Faktorial.faktorial(i));
        }
        scoring.updateScore("lang:common_list_test_scoring_name",100);
    }
    public static long sucin(int from, int to) {
        long res = 1L;
        while (from <= to) {
            res *= from;
            from++;
        }
        return res;
    }
}