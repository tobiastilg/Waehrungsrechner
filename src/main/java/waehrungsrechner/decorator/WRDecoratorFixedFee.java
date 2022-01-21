package waehrungsrechner.decorator;

import waehrungsrechner.IUmrechnen;
import waehrungsrechner.WR;

/**
 * Konkreter Decorator
 */
public class WRDecoratorFixedFee extends WRDecorator {

    public WRDecoratorFixedFee(WR nextWR) {
        super(nextWR);
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        double gebuehren = 5;
        if (variante.toUpperCase().startsWith("EUROTO")) {
            double betragMitFee = betrag+gebuehren;
            return super.umrechnen(variante, betragMitFee);
        } else {
            System.out.println("Fixe Gebühren nur bei Umrechnungen ausgehend von Euro möglich! Anfallende Gebühr: " + gebuehren + "€");
            System.out.print("Folgender Betrag konnte nicht umgerechnet werden: ");
            return betrag;
        }
    }
}
