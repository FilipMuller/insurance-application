package ProjektKeZkousce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PojistenyManazer {
    private final List<Pojisteny> pojistenyList;

    public PojistenyManazer() {
        this.pojistenyList = new ArrayList<>();
    }

    public void vytvorPojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        if (jmeno.isEmpty()) {
            System.out.println("Chyba: Jméno nesmí být prázdné.");
            return;
        }
        Pojisteny newPojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
        pojistenyList.add(newPojisteny);
    }

    public void zobrazVsechnyPojistene() {
        System.out.println("Seznam pojištěných:");
        for (Pojisteny pojisteny : pojistenyList) {
            System.out.println(pojisteny);
        }
    }

    public void zobrazPojistenehoPodleJmena(String jmeno, String prijmeni) {
        System.out.println("Vyhledávání pojištěného podle jména a příjmení:");
        for (Pojisteny pojisteny : pojistenyList) {
            if (pojisteny.getJmeno().equalsIgnoreCase(jmeno) && pojisteny.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                System.out.println(pojisteny);
                pridejZaznamOUdalosti(pojisteny);
                return;
            }
        }
        System.out.println("Pojištěný s tímto jménem a příjmením nebyl nalezen.");
    }

    public void pridejZaznamOUdalosti(Pojisteny pojisteny) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Chcete přidat záznam o pojistné události? (ano/ne): ");
        String odpoved = scanner.nextLine().trim().toLowerCase();
        if (odpoved.equals("ano")) {
            System.out.print("Zadejte záznam o pojistné události: ");
            String udalost = scanner.nextLine();
            pojisteny.pridejZaznamOUdalosti(udalost);
            System.out.println("Záznam o události byl úspěšně přidán.");
        }
    }
    public boolean existujePojisteny() {
        return !pojistenyList.isEmpty();
    }
    public Pojisteny vyhledejPojisteneheDlePrijmeni(String prijmeni) {
        for (Pojisteny pojisteny : pojistenyList) {
            if (pojisteny.getPrijmeni().equals(prijmeni)) {
                return pojisteny;
            }
        }
        return null;
    }
}
