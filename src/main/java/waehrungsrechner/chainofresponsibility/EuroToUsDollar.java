package waehrungsrechner.chainofresponsibility;

import waehrungsrechner.WR;

/**
 * Konkreter Bearbeiter
 */
public class EuroToUsDollar extends WR {

    public EuroToUsDollar(WR nextWR) {
        super(nextWR);
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        if (variante.equalsIgnoreCase("eurotousdollar")) {
            return betrag/0.8827;
        } else {
            return super.umrechnen(variante, betrag);
        }
    }
}
