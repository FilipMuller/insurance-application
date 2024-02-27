package ProjektKeZkousce;

public class Castky {
    private int smrt;
    private int vvo;
    private int tn;

    public Castky(int smrt, int vvo, int tn) {
        this.smrt = smrt;
        this.vvo = vvo;
        this.tn = tn;
    }

    public int getSmrt() {
        return smrt;
    }

    public void setSmrt(int smrt) {
        this.smrt = smrt;
    }

    public int getVvo() {
        return vvo;
    }

    public void setVvo(int vvo) {
        this.vvo = vvo;
    }

    public int getTn() {
        return tn;
    }

    public void setTn(int tn) {
        this.tn = tn;
    }

    @Override
    public String toString() {
        return "Na život: " + "Smrt = " + smrt + ", Velmi vážná onemocnění = " + vvo + ", Trvalé následky úrazu = " + tn ;
    }
}
