package waehrungsrechner.adapter;

import waehrungsrechner.ISammelumrechnung;
import waehrungsrechner.IUmrechnen;
import waehrungsrechner.WR;

/**
 * Adapter
 */
public class WRAdapter implements ISammelumrechnung {

    private IUmrechnen wr;

    public WRAdapter(IUmrechnen wr) {
        this.wr = wr;
    }

    @Override
    public double sammelumrechnen(double[] betraege, String variante) {
        double summe = 0;
        for (double betrag: betraege) {
            summe += wr.berechnen(variante, betrag);
        }
        return summe;
    }
}
