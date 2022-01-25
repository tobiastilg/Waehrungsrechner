package waehrungsrechner.observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Konkreter Observer
 */
public class LogObserver extends WRObserver {

    /**
     * Erstellen eines Logs (in einer Textdatei)
     * @param ausgangsWaehrung
     * @param zielWaehrung
     * @param betrag
     * @param umgerechneterBetrag
     */
    @Override
    public void update(String ausgangsWaehrung, String zielWaehrung, double betrag, double umgerechneterBetrag) {

        /*String[] dateStampArray = dateTime.toString().split("T");
        String[] timeStampArray = dateStampArray[1].split("\\."); --> ohne Millisekunden
        String timeStampForPath = dateStampArray[1].replace(':', '-');*/

        try {
            /*BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("./logs/log_"+dateStampArray[0]+"_"+timeStampForPath+".txt"));*/

            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("./logs/log.txt", true));
            bufferedWriter.write("~~~ Umrechnung am " + getDateFormatted() + " ~~~\n");
            bufferedWriter.write("Umrechnung von " + betrag + " " + ausgangsWaehrung + " in " + umgerechneterBetrag + " " + zielWaehrung + " (ggf. abzgl. Gebühren)");
            bufferedWriter.write("\n~~~~~~~~~\n\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}