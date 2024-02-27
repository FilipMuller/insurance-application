package ProjektKeZkousce;

import java.util.Scanner;
public class Pojistovna {

    private final Scanner scanner;
    private final PojistenyManazer pojistenyManazer;

    public static final String ZADEJTE_JMENO_POJISTENEHO = "Zadejte jméno pojištěného: ";
    public static final String ZADEJTE_PRIJMENI_POJISTENEHO = "Zadejte příjmení pojištěného: ";

    public Pojistovna() {
        this.pojistenyManazer = new PojistenyManazer();
        this.scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Vytvořit nového pojištěného");
            System.out.println("2. Zobrazit seznam všech pojištěných");
            System.out.println("3. Vyhledat pojištěného podle jména a příjmení");
            System.out.println("4. Konec");
            if (pojistenyManazer.existujePojisteny()) {
                System.out.println("5. Přidej pojištění");
            }


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
                    break;
                case 5:
                    if (!pojistenyManazer.existujePojisteny()) {
                        System.out.println("Nejdříve přidej pojištěného");
                    }
                    else {
                        pridejPojisteni();
                    }
                    break;
                default:
                    System.out.println("Neplatná volba. Zvolte možnost znovu.");
            }
        }
    }
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
    private void zobrazPojistene() {
        pojistenyManazer.zobrazVsechnyPojistene();
    }
    private void vyhledejPojisteneho() {
        System.out.print(ZADEJTE_JMENO_POJISTENEHO);
        String najdiPodleJmena = scanner.nextLine();
        System.out.print(ZADEJTE_PRIJMENI_POJISTENEHO);
        String najdiPodlePrijmeni = scanner.nextLine();
        pojistenyManazer.zobrazPojistenehoPodleJmena(najdiPodleJmena, najdiPodlePrijmeni);
    }
    private void ukonciAplikaci() {
        System.out.println("Ukončení aplikace.");
        scanner.close();
        System.exit(0);
    }
    private void pridejPojisteni() {
        System.out.println("Zadej částku pro případ pojištění smrti");
        int smrt = Integer.parseInt(scanner.nextLine());

        System.out.println("Zadej částku pro případ pojištění velmi vážných onemocnění");
        int vvo = Integer.parseInt(scanner.nextLine());

        System.out.println("Zadej částku pro případ pojištění trvalých následků úrazu");
        int tn = Integer.parseInt(scanner.nextLine());

        Castky castky = new Castky(smrt, vvo, tn);

        System.out.printf("Pojištění smrti:%d, Pojištění VVO:%d, Pojištění trvalých následků:%d%n", smrt, vvo, tn);
        System.out.println("Zadej příjmení pojištěné, kterému chceš pojištění přiřadit");
        zobrazPojistene();

        String prijmeniPojisteneho = scanner.nextLine();
        Pojisteny pojisteny = pojistenyManazer.vyhledejPojisteneheDlePrijmeni(prijmeniPojisteneho);
        if (pojisteny == null) {
            System.out.println("Pojištěná osoba nenalezena.");
        }
        pojisteny.setCastky(castky);
    }
}

//TODO otrimovat častky ve tvorbě pojištění // v zadávaní telefonu to máš
