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

    private double calculateTwoDecimals(double umgerechneterBetrag) {
        return Math.floor(umgerechneterBetrag * 100)/100;
    }

    //TemplateHook - Schablonenmethode
    public final double berechnung(String variante, double betrag) {
        double umgerechneterBetrag = umrechnen(variante, betrag);
        umgerechneterBetrag = calculateTwoDecimals(umgerechneterBetrag);
        return umgerechneterBetrag;
    }
}