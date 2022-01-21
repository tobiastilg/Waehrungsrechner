package waehrungsrechner.decorator;

import waehrungsrechner.WR;

/**
 * Konkreter Decorator
 */
public class WRDecoratorVariableFee extends WRDecorator {

    public WRDecoratorVariableFee(WR nextWR) {
        super(nextWR);
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        double betragMitFee = betrag*1.05;
        return super.umrechnen(variante, betragMitFee);
    }
}
