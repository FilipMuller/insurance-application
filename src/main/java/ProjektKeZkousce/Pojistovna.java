package ProjektKeZkousce;

import java.util.Scanner;

/**
 * Třída Pojistovna slouží k interakci s uživatelem.
 * Umožňuje vytvářet, zobrazovat a vyhledávat pojištěné osoby.
 */

public class Pojistovna {

    private final Scanner scanner; // Scanner pro načítání vstupu od uživatele
    private final PojistenyManazer pojistenyManazer; // Správce pojištěných osob

    // Konstantní řetězce pro výzvy uživatele.
    public static final String ZADEJTE_JMENO_POJISTENEHO = "Zadejte jméno pojištěného: ";
    public static final String ZADEJTE_PRIJMENI_POJISTENEHO = "Zadejte příjmení pojištěného: ";

    /**
     * Konstruktor třídy Pojistovna inicializuje scanner pro vstup od uživatele
     * a správce pojištěných osob. Následně spouští hlavní smyčku interakce s uživatelem.
     */
    public Pojistovna() {
        this.pojistenyManazer = new PojistenyManazer();
        this.scanner = new Scanner(System.in);

        while (true) { // Hlavní smyčka interakce s uživatelem s konstrukcí switch, kde se volají pouze metody.
            System.out.println("\n1. Vytvořit nového pojištěného");
            System.out.println("2. Zobrazit seznam všech pojištěných");
            System.out.println("3. Vyhledat pojištěného podle jména a příjmení");
            System.out.println("4. Konec");

            System.out.print("\nVyberte možnost: ");
            int volba = scanner.nextInt();
            scanner.nextLine();

            switch (volba) {
                case 1:
                    pridejPojisteneho();
                    break;
                case 2:
                    zobrazPojistene();
                    break;
                case 3:
                    vyhledejPojisteneho();
                    break;
                case 4:
                    ukonciAplikaci();
                default:
                    System.out.println("Neplatná volba. Zvolte možnost znovu.");
            }
        }
    }
    // Metoda pro přidání nového pojištěného
    private void pridejPojisteneho() {
        System.out.print(ZADEJTE_JMENO_POJISTENEHO);
        String jmeno = scanner.nextLine();
        System.out.print(ZADEJTE_PRIJMENI_POJISTENEHO);
        String prijmeni = scanner.nextLine();
        System.out.print("Zadejte věk pojištěného: ");
        int vek = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Zadejte telefonní číslo pojištěného: ");
        String telefon = scanner.nextLine();
        pojistenyManazer.vytvorPojisteny(jmeno, prijmeni, vek, telefon);
    }
    // Metoda pro zobrazení všech pojištěných osob
    private void zobrazPojistene() {
        System.out.println(pojistenyManazer.zobrazVsechnyPojistene());
    }
    // Metoda pro vyhledání pojištěného podle jména a příjmení
    private void vyhledejPojisteneho() {
        System.out.print(ZADEJTE_JMENO_POJISTENEHO);
        String najdiPodleJmena = scanner.nextLine();
        System.out.print(ZADEJTE_PRIJMENI_POJISTENEHO);
        String najdiPodlePrijmeni = scanner.nextLine();
        pojistenyManazer.zobrazPojistenehoPodleJmena(najdiPodleJmena, najdiPodlePrijmeni);
    }
    // Metoda pro ukončení aplikace
    private void ukonciAplikaci() {
        System.out.println("Ukončení aplikace.");
        scanner.close();
        System.exit(0);
    }
}

