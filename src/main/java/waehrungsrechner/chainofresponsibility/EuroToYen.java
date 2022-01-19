package waehrungsrechner.chainofresponsibility;

import waehrungsrechner.WR;

public class EuroToYen extends WR {

    public EuroToYen(WR nextWR) {
        super(nextWR);
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        if (variante.equalsIgnoreCase("eurotoyen")) {
            double umgerechneterBetrag = betrag/0.0077;
            return Math.floor(umgerechneterBetrag * 100)/100;
        } else {
            return super.umrechnen(variante, betrag);
        }
    }
}
