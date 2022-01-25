package waehrungsrechner.observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Observer Interface (abstrakte Klasse)
 */
public abstract class WRObserver {

    public abstract void update(String ausgangsWaehrung, String zielWaehrung, double betrag, double umgerechneterBetrag);

    protected String getDateFormatted() {
        LocalDateTime dateTime = LocalDateTime.now();
        String timeStamp = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").format(dateTime);
        return timeStamp;
    }
}
