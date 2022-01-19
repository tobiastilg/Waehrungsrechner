package waehrungsrechner.chainofresponsibility;

import waehrungsrechner.WR;

public class EuroToUsDollar extends WR {

    public EuroToUsDollar(WR nextWR) {
        super(nextWR);
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        if (variante.equalsIgnoreCase("eurotousdollar")) {
            double umgerechneterBetrag = betrag/0.8827;
            return Math.floor(umgerechneterBetrag * 100)/100;
        } else {
            return super.umrechnen(variante, betrag);
        }
    }
}
