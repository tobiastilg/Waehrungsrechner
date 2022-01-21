package waehrungsrechner.decorator;

import waehrungsrechner.IUmrechnen;
import waehrungsrechner.WR;

/**
 * Konkreter Decorator
 */
public class WRDecoratorVariableFee extends WRDecorator {

    public WRDecoratorVariableFee(IUmrechnen nextWR) {
        super(nextWR);
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        double betragMitFee = betrag*1.05;
        return super.umrechnen(variante, betragMitFee);
    }
}
