package waehrungsrechner.chainofresponsibility;

import waehrungsrechner.WR;

/**
 * Konkreter Bearbeiter (Kettenmitglied)
 */
public class EuroToYen extends WR {

    public EuroToYen(WR nextWR) {
        super(nextWR);
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        if (variante.equalsIgnoreCase("eurotoyen")) {
            return betrag/0.0077;
        } else {
            return super.umrechnen(variante, betrag);
        }
    }
}
