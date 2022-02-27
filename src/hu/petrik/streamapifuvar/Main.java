package hu.petrik.streamapifuvar;

public class Main {

    public static void main(String[] args) {
        Fuvarok fuvarok = new Fuvarok("fuvar.csv");

        System.out.println("1. Feladat: Utazások száma: " + fuvarok.getFuvarokSzama());
        System.out.println("2. Feladat: A 6185-ös taxis útjainak száma: " + fuvarok.getFuvarokSzamaById(6185));
        System.out.println("2. Feladat: A 6185-ös taxis összes bevétele: " + fuvarok.getOsszesBevetelById(6185));
        System.out.println("3. Feladat: Taxisok által megtett mérdföldek: " + fuvarok.getOsszesMerfold());
        System.out.println("4. Feladat: Leghosszabb idő: " + fuvarok.getLeghosszabbIdo().getIdotartam());
        System.out.println("5. Feladat: Legbőkezűbb borravaló: " + fuvarok.getLegbokezubbBorravalo().getBorravalo());
        System.out.println("6. Feladat: A 4261-es taxis összesen megtett távolsága km-ben: " + fuvarok.getOsszesKmById(4261));
        System.out.println("7. Feladat: A hibásak száma: " + fuvarok.getHibasakSzama());
        System.out.println("7. Feladat: A hibásak összes időtartama: " + fuvarok.getHibasakOsszesIdo());
        System.out.println("7. Feladat: A hibásak összes bevétele: " + fuvarok.getHibasakTeljesBevetel());
        System.out.println("8. Feladat: A 1452-es taxis létezik-e: " + fuvarok.getLetezikEById(1452));
        System.out.print("9. Feladat: 3 legrövidebb utazás (ami nem nulla): ");
        for (Fuvar fuvar : fuvarok.getHaromLegrovidebbUtazasNemNulla()) {
            System.out.print(fuvar.getIdotartam() + ", ");
        }
        System.out.println();
        System.out.println("10. Feladat: Fuvarok száma december 24.-én: " + fuvarok.getFuvarokSzamaByDate(12, 24));
        System.out.println("11. Feladat: A borravalók aránya december 31.-én: " + fuvarok.getBorravalokByDate(12, 31));
    }
}
