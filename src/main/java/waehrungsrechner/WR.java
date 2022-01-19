package waehrungsrechner;

public abstract class WR implements IUmrechnen {

    //next Element in ChainOfResponsibility
    private WR nextWR;

    public WR(WR nextWR) {
        this.nextWR = nextWR;
    }

    public double umrechnen(String variante, double betrag) {
        if (nextWR != null) {
            return nextWR.umrechnen(variante, betrag);
        } else {
            printError();
            return betrag;
        }
    }

    private void printError() {
        System.out.print("Keine Variante gefunden! Folgender Betrag konnte nicht umgerechnet werden: ");
    }
}