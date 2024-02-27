package ProjektKeZkousce;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída Pojisteny představuje jednu pojištěnou osobu v rámci pojistovny.
 */
public class Pojisteny {
    private final String jmeno; // Jméno pojištěného
    private final String prijmeni; // Příjmení pojištěného
    private final int vek; // Věk pojištěného
    private final String telefon; // Telefonní číslo pojištěného
    private final List<String> udalosti; // Seznam událostí spojených s pojištěným

    /**
     * Konstruktor třídy Pojisteny inicializuje atributy pojištěné osoby.
     *
     * @param jmeno    Jméno pojištěného
     * @param prijmeni Příjmení pojištěného
     * @param vek      Věk pojištěného
     * @param telefon  Telefonní číslo pojištěného
     */
    public Pojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
        this.udalosti = new ArrayList<>(); // Inicializace seznamu událostí
    }

    /**
     * Metoda pro získání jména pojištěného.
     *
     * @return Jméno pojištěného
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Metoda pro získání příjmení pojištěného.
     *
     * @return Příjmení pojištěného
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Metoda pro získání věku pojištěného.
     *
     * @return Věk pojištěného
     */
    public int getVek() {
        return vek;
    }

    /**
     * Metoda pro získání telefonního čísla pojištěného.
     *
     * @return Telefonní číslo pojištěného
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Metoda pro získání seznamu událostí spojených s pojištěným.
     *
     * @return Seznam událostí
     */
    public List<String> getUdalosti() {
        return udalosti;
    }

    /**
     * Metoda pro přidání záznamu o události spojené s pojištěným.
     *
     * @param udalost Záznam o události
     */
    public void pridejZaznamOUdalosti(String udalost) {
        udalosti.add(udalost);
    }

    /**
     * Přepisuje metodu toString pro zobrazení informací o pojištěném.
     *
     * @return Textová reprezentace pojištěného
     */
    @Override
    public String toString() {
        StringBuilder udalostiText = new StringBuilder();
        for (String udalost : udalosti) {
            udalostiText.append("\n- ").append(udalost);
        }
        return "Jméno: " + jmeno + ", Příjmení: " + prijmeni + ", Věk: " + vek + ", Telefonní číslo: " + telefon
                + "\nUdálosti:" + udalostiText.toString();
    }
}

