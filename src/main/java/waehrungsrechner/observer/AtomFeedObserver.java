package waehrungsrechner.observer;

import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Konkreter Observer
 * https://bit.ly/3gdQtmJ
 */
public class AtomFeedObserver extends WRObserver {

    /**
     * Erstellen eines Atom-Feeds
     * Um das sinnvoll zu nutzen, sollte man einem übergeordneten Feed immer neue Entries (jede Umrechnung) hinzufügen
     *  --> dazu Feed einmalig erstellen (über eine Art Singleton Pattern), diesen Einlesen und jeweils Entries hinzufügen
     *      und wieder speichern
     * @param ausgangsWaehrung
     * @param zielWaehrung
     * @param betrag
     * @param umgerechneterBetrag
     */
    @Override
    public void update(String ausgangsWaehrung, String zielWaehrung, double betrag, double umgerechneterBetrag) {

        String timeStamp = getDateFormatted();

        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("atom_0.3");

        feed.setTitle("Atom-Feed-Währungsrechner");
        feed.setLink("https://github.com/tobiastilg/Waehrungsrechner");
        feed.setDescription("Umrechnung");

        List entries = new ArrayList();
        SyndEntry entry;
        SyndContent description;

        entry = new SyndEntryImpl();
        entry.setTitle("Umrechnung am " + timeStamp);
        entry.setLink("https://github.com/tobiastilg/Waehrungsrechner");
        entry.setPublishedDate(new Date());

        description = new SyndContentImpl();
        description.setType("text/html");
        description.setValue("<h3>~~~ Umrechnung am " + timeStamp + " ~~~</h3>" +
                "<p>Umrechnung von " + betrag + " " + ausgangsWaehrung + " in " + umgerechneterBetrag + " " + zielWaehrung + " (ggf. abzgl. Gebühren)</p>" +
                "<p>~~~~~~~~~</p><br>");
        entry.setDescription(description);

        entries.add(entry);
        feed.setEntries(entries);

        try {
            Writer writer = new FileWriter("./logs/atom-feed.xml", true);
            SyndFeedOutput feedOutput = new SyndFeedOutput();
            feedOutput.output(feed,writer);
            writer.close();
        } catch (IOException | FeedException e) {
            e.printStackTrace();
        }
    }
}
