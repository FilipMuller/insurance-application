package ProjektKeZkousce;

import java.util.Scanner;

public class Main {
    public static final String ZADEJTE_JMENO_POJISTENEHO = "Zadejte jméno pojištěného: ";
    public static final String ZADEJTE_PRIJMENI_POJISTENEHO = "Zadejte příjmení pojištěného: ";

    public static void main(String[] args) {
        PojistenyManazer pojistenyManazer = new PojistenyManazer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Vytvořit nového pojištěného");
            System.out.println("2. Zobrazit seznam všech pojištěných");
            System.out.println("3. Vyhledat pojištěného podle jména a příjmení");
            System.out.println("4. Konec");

            System.out.print("\nVyberte možnost: ");
            int volba = scanner.nextInt();
            scanner.nextLine();

            switch (volba) {
                case 1:
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
                    break;
                case 2:
                    pojistenyManazer.zobrazVsechnyPojistene();
                    break;
                case 3:
                    System.out.print(ZADEJTE_JMENO_POJISTENEHO);
                    String najdiPodleJmena = scanner.nextLine();
                    System.out.print(ZADEJTE_PRIJMENI_POJISTENEHO);
                    String najdiPodlePrijmeni = scanner.nextLine();
                    pojistenyManazer.zobrazPojistenehoPodleJmena(najdiPodleJmena, najdiPodlePrijmeni);
                    break;
                case 4:
                    System.out.println("Ukončení aplikace.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Neplatná volba. Zvolte možnost znovu.");
            }
        }
    }
}

