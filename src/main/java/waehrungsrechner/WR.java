package waehrungsrechner;

/**
 * Schnittstelle auf die der Client zugreift
 */
public abstract class WR implements IUmrechnen {

    //next Element in ChainOfResponsibility
    private WR nextWR;

    public WR(WR nextWR) {
        this.nextWR = nextWR;
    }

    /**
     * Weitergeben an nächstes Kettenglied
     */
    public double umrechnen(String variante, double betrag) {
        if (nextWR != null) {
            return nextWR.umrechnen(variante, betrag);
        } else {
            printError();
            return betrag;
        }
    }

    private void printError() {
        System.out.println("Keine Variante gefunden!");
        System.out.print("Folgender Betrag konnte nicht umgerechnet werden: ");
    }

    private double calculateTwoDecimals(double umgerechneterBetrag) {
        return Math.floor(umgerechneterBetrag * 100)/100;
    }

    //TemplateHook - Schablonenmethode
    public final double berechnen(String variante, double betrag) {
        double umgerechneterBetrag = umrechnen(variante, betrag);
        umgerechneterBetrag = calculateTwoDecimals(umgerechneterBetrag);
        return umgerechneterBetrag;
    }
}