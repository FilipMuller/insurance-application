package ProjektKeZkousce;

import java.util.ArrayList;
import java.util.List;
public class Pojisteny {
    private final String jmeno;
    private final String prijmeni;
    private final int vek;
    private final String telefon;
    private final List<String> udalosti;

    public Pojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
        this.udalosti = new ArrayList<>();
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getVek() {
        return vek;
    }

    public String getTelefon() {
        return telefon;
    }

    public List<String> getUdalosti() {
        return udalosti;
    }

    public void pridejZaznamOUdalosti(String udalost) {
        udalosti.add(udalost);
    }

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
