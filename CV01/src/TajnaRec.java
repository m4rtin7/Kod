public class TajnaRec {

    public static String zakoduj(String vstup, String spoluhlasky) {
        String samohlasky = "aeiouy";
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : vstup.toCharArray()) {
            sb.append(ch);
            if (samohlasky.contains(""+Character.toLowerCase(ch))) {
                sb.append(spoluhlasky.charAt(i));
                i = (i + 1) % spoluhlasky.length();
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(zakoduj("Mama ma Emu.", "p")); // Mapamapa mapa Epemupu.
        System.out.println(zakoduj("Mama ma Emu.", "bcd")); // Mabamaca mada Ebemucu.
        System.out.println(zakoduj("Kobyla ma maly bok.","p")); // Kopobypylapa mapa mapalypy bopok.
        System.out.println(zakoduj("Kobyla ma maly bok.", "bcd")); // Kobobycylada maba macalydy bobok.
        System.out.println(zakoduj("Kobyla ma maly bok.", "xyz")); // Koxobyyylaza maxa mayalyzy boxok.
        System.out.println(zakoduj("Povedali nasi vasim, aby prisli vasi k nasim, ak nepridu vasi k nasim, tak nepridu nasi k vasim.", "p"));
//Popovepedapalipi napasipi vapasipim, apabypy pripislipi vapasipi k napasipim, apak nepepripidupu vapasipi k napasipim, tapak nepepripidupu napasipi k vapasipim.

        System.out.println(zakoduj("Povedali nasi vasim, aby prisli vasi k nasim, ak nepridu vasi k nasim, tak nepridu nasi k vasim.", "hjb"));
//Pohovejedabalihi najasibi vahasijim, ababyhy prijislibi vahasiji k nabasihim, ajak nebeprihiduju vabasihi k najasibim, tahak nejepribiduhu najasibi k vahasijim.
    }

}
