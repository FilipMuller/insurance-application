package ProjektKeZkousce;

import java.util.ArrayList;
import java.util.List;

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
                return;
            }
        }
        System.out.println("Pojištěný s tímto jménem a příjmením nebyl nalezen.");
    }
}
