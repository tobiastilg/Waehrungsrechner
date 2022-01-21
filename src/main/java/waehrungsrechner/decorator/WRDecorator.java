package waehrungsrechner.decorator;

import waehrungsrechner.WR;

/**
 * Decorator (bildet WR ab - gibt sich als solcher aus) - dient nur als Schnittstelle
 */
public abstract class WRDecorator extends WR {

    //kein eigener WR als Datenfeld nötig, da durch die Chain bereits einer definiert wird

    public WRDecorator(WR nextWR) {
        super(nextWR);
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        return super.umrechnen(variante, betrag);
    }
}
