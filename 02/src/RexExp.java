import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexExp {


    public static void main(String[] args) {
        Boolean[] results = new Boolean[]{
                "java".matches("java"),                      // totalna zhoda
                " java ".matches("java"),                    // totalna zhoda
                "python java kotlin".matches(".*java.*"),    // niekde v retazci
                "python ja va kotlin".matches(".*java.*"),   // niekde v retazci
                "java python kotlin".matches("^java.*"),     // na zaciatku riadku
                " java python kotlin".matches("^java.*"),    // na zaciatku riadku
                "java9".matches("[a-z0-9]+"),                // male pismena, cifry
                "".matches("[a-z0-9]+"),                     // male pismena, cifry
                "java9".matches("[^python]+"),               // okrem p,y,t,h,o,n
                "kotlin".matches("[^python]+"),              // okrem p,y,t,h,o,n
                "FF00FF".matches("[A-F[0-9]]+"),             // A-F zjednotenie 0-9
                "ff00ff".matches("[A-F[0-9]]+"),             // A-F zjednotenie 0-9
                "KLM".matches("[A-Q&&[K-Z]]+"),              // A-Q prienik K-Z
                "SWISS".matches("[A-Q&&[K-Z]]+"),            // A-Q prienik K-Z
                "KLM".matches("[A-Z&&[^F-H]]+"),             // A-Q rozdiel K-Z
                "FRANCE".matches("[A-Z&&[^F-H]]+"),          // A-Q rozdiel K-Z
                "158".matches("\\d{3}"),                     // tri cifry
                "1234".matches("\\d{3}"),                    // tri cifry
                "558".matches("(\\d)\\1\\d"),                // xx?
                "123".matches("(\\d)\\1\\d"),                // xx?
                "567567".matches("(\\d\\d\\d)\\1"),          // xyzxyz
                "567576".matches("(\\d\\d\\d)\\1"),          // xyzxyz

                "Peter".matches("[A-Z][a-zA-Z]*"),           // meno zacina velkym pismenom
                "peter".matches("[A-Z][a-zA-Z]*"),           // meno zacina velkym pismenom
                "821 06".matches("\\d{3}\\s\\d{2}"),         // psc
                "82106".matches("\\d{3}\\s\\d{2}"),          // psc
                "0905 819 123".matches("09\\d{2}\\s\\d{3}\\s\\d{3}"),   // mobil
                "4212 777 333".matches("09\\d{2}\\s\\d{3}\\s\\d{3}"),   // mobil
                "02/2517293".matches("[0]\\d+[/-]\\d+"),      // pevna
                "02 2517293".matches("[0]\\d+[/-]\\d+"),      // pevna
                "1982-12-26".matches("(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])"),      // yyyy-mm-dd
                "26.12.1982".matches("(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])"),      // yyyy-mm-dd
                "muz".matches("(muz|zena)"),                  // sex
                "dieta".matches("(muz|zena)"),                // sex
                "jano.mrkva@mazetnet11.com".matches("[a-zA-Z0-9_.]+[@][a-zA-Z0-9_.]+"),  // email
                "jano/mrkva@mazetnet11.com".matches("[a-zA-Z0-9_.]+[@][a-zA-Z0-9_.]+"),  // email
        };
        // kazdy druhy je false...
        for(int i = 0; i < results.length; i++)
            if ((i%2>0)==results[i])
                System.out.println("chyba " +i );
        System.out.println(Arrays.asList(results));

        String regexp = "(\\d{4})(\\d{2})(\\d{2})/(\\d{4}|\\d{3})";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher("20200225/123");
        if (matcher.matches()) {
            if (matcher.groupCount() > 0) {
                for (int g = 0; g <= matcher.groupCount(); g++) {
                    System.out.println("group " + g + " is " + matcher.group(g));
                }
            }
        }
    }

}
