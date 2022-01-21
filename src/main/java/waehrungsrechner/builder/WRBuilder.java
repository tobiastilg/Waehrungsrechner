package waehrungsrechner.builder;

import waehrungsrechner.WR;

/**
 * Builder (nicht besonders sinnvoll in diesem Beispiel, da nur ein Datenfeld und abstrakte Klasse)
 */
public class WRBuilder {

    private WR nextWR;

    public WRBuilder setNextWR(WR wr) {
        this.nextWR = wr;
        return this;
    }

    public WR build() {
        return nextWR;
    }
}
