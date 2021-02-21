import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import LISTTestScoring.LISTTestScoring;

public class TestTuristika {
    private static LISTTestScoring scoring = null;

    @BeforeClass
    public static void initScoring() {
        scoring = new LISTTestScoring();
        scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
    }

    @Test
    public void test() {
        Entry[] entries = new Entry[]{
                new Entry("10L10L10L10", 0, true),
                new Entry("1234567LL1234567", 0, true),
                new Entry("LLLLLPPPLPLPLPLPLP", 0, true),
                new Entry("10L10", 20, true),
                new Entry("10L10", 0, false),
                new Entry("10PP10", 0, true),
                new Entry("LL12345P300L123P99999999L12", 37, false),
                new Entry("3L4", 5, true),
                new Entry("3L4", 4, false),
                new Entry(String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "LLLLL" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L", 0, true),
                new Entry(String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "P" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L" +
                        String.valueOf(Long.MAX_VALUE) + "L", 0, false)
        };

        for (Entry e : entries) {
            assertEquals(String.format("Cesta: %s\nTolerancia: %d", e.route, e.tolerance),
                    e.answer,
                    Turistika.euklidovska(e.route, e.tolerance));
        }

        scoring.updateScore("lang:common_list_test_scoring_name",100);
    }

    private class Entry {
        String route;
        long tolerance;
        boolean answer;

        public Entry(String route, int tolerance, boolean answer) {
            this.route = route;
            this.tolerance = tolerance;
            this.answer = answer;
        }
    }
}