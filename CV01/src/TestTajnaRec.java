import static org.junit.Assert.*;

import LISTTestScoring.LISTTestScoring;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTajnaRec {

    private static LISTTestScoring scoring = null;

    @BeforeClass
    public static void initScoring() {
        scoring = new LISTTestScoring();
        scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
    }

    String testStrings1[] = {
            "Mama ma Emu.",
            "Kobyla ma maly bok.",
    };
    String testCodingChars1[] = {
            "p",
            "bcd",
    };
    String testResults1[][] = {
            {"Mapamapa mapa Epemupu.", "Mabamaca mada Ebemucu."},
            {"Kopobypylapa mapa mapalypy bopok.","Kobobycylada maba macalydy bobok.",}
    };
    @Test
    public void testZakoduj1() {
        for (int i = 0; i < testStrings1.length; i++) {
            for (int j = 0; j < testCodingChars1.length; j++) {
                assertEquals("Kodovanie správy "+testStrings1[i]+" pomocou znakov "+testCodingChars1[j],
                        testResults1[i][j],
                        TajnaRec.zakoduj(testStrings1[i],testCodingChars1[j]));
            }
        }
        TestTajnaRec.scoring.updateScore("lang:common_list_test_scoring_name",50);
    }

    public static String zakoduj(String vstup, String spoluhlasky) {
        String vystup = "";
        int indexSpoluhlasky = 0;
        for (int i = 0; i < vstup.length(); i++) {
            char znak = vstup.charAt(i);
            vystup += znak;
            if (znak=='a' || znak=='A' || znak=='e' || znak=='E' || znak=='i' || znak=='I'
                    || znak=='o' || znak=='O' || znak=='u' || znak=='U' || znak=='y' || znak=='Y') {
                vystup += "" + spoluhlasky.charAt(indexSpoluhlasky) + Character.toLowerCase(znak);
                if (indexSpoluhlasky < spoluhlasky.length()-1) {
                    indexSpoluhlasky++;
                } else {
                    indexSpoluhlasky = 0;
                }
            }
        }
        return vystup;
    }

    String testStrings2[] = {
            "Povedali nasi vasim, aby prisli vasi k nasim, ak nepridu vasi k nasim, tak nepridu nasi k vasim.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus id odio vel eros dignissim finibus id in odio. In facilisis nisi id felis mollis facilisis. Sed metus magna, consectetur nec lacus ut, vestibulum ultrices felis. Donec porta tortor sed finibus rhoncus. Aenean ac turpis sit amet dolor finibus ultricies sit amet ac tellus. Praesent nec cursus leo. Nullam scelerisque mi eu commodo interdum. In maximus porta sapien, vitae vulputate dolor condimentum ut."
    };
    String testCodingChars2[] = {
            "p",
            "bcd",
            "prbcdswtrthrblj",
            "abc"
    };
    @Test
    public void testZakoduj2() {
        for (int i = 0; i < testStrings2.length; i++) {
            for (int j = 0; j < testCodingChars2.length; j++) {
                assertEquals("Kodovanie správy "+testStrings2[i]+" pomocou znakov "+testCodingChars2[j],
                        zakoduj(testStrings2[i],testCodingChars2[j]),
                        TajnaRec.zakoduj(testStrings2[i],testCodingChars2[j]));
            }
        }
        TestTajnaRec.scoring.updateScore("lang:common_list_test_scoring_name",50);
    }
}