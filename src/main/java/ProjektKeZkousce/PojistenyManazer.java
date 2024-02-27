package ProjektKeZkousce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Třída PojistenyManazer poskytuje metody pro správu a manipulaci s pojištěnými osobami.
 */

public class PojistenyManazer {
    private final List<Pojisteny> pojistenyList; // Seznam pojištěných osob

    /**
     * Konstruktor třídy PojistenyManazer inicializuje seznam pojištěných osob.
     */
    public PojistenyManazer() {
        this.pojistenyList = new ArrayList<>();
    }

    /**
     * Metoda pro vytvoření nového pojištěného a přidání jej do seznamu.
     *
     * @param jmeno    Jméno pojištěného
     * @param prijmeni Příjmení pojištěného
     * @param vek      Věk pojištěného
     * @param telefon  Telefonní číslo pojištěného
     */
    public void vytvorPojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        if (jmeno.isEmpty()) {
            System.out.println("Chyba: Jméno nesmí být prázdné.");
            return;
        }
        Pojisteny newPojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
        pojistenyList.add(newPojisteny);
    }

    /**
     * Metoda pro zobrazení všech pojištěných osob.
     */
    public String zobrazVsechnyPojistene() {
        String output = "";
        System.out.println("Seznam pojištěných:");
        for (Pojisteny pojisteny : pojistenyList) {
            output += pojisteny + "\n ";
        }
        return output;
    }

    /**
     * Metoda pro vyhledání a zobrazení pojištěné osoby podle jména a příjmení.
     *
     * @param jmeno    Jméno pojištěného
     * @param prijmeni Příjmení pojištěného
     */
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

    /**
     * Metoda pro přidání záznamu o události spojené s pojištěným.
     *
     * @param pojisteny Pojištěná osoba
     */
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
}

//TODO rozdělení uživatelského vstupu a výstupui práce s daty - předělat do třídy PojistenyManazer
//TODO validace vstupních dat zároveň s uživatelským rozhráním upravit aby tam