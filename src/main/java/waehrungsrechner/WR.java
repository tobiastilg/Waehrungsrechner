package waehrungsrechner;

import waehrungsrechner.builder.WRBuilder;
import waehrungsrechner.observer.WRObserver;
import waehrungsrechner.observer.WRSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * Schnittstelle auf die der Client zugreift
 */
public abstract class WR implements IUmrechnen, WRSubject {

    //next Element in ChainOfResponsibility
    private WR nextWR;

    public WR(IUmrechnen nextWR) {
        this.nextWR = (WR)nextWR;
        this.observers = new ArrayList<>();
    }

    /**
     * Weitergeben an nächstes Kettenglied
     */
    protected double umrechnen(String variante, double betrag) {
        if (nextWR != null) {
            return nextWR.umrechnen(variante, betrag);
        } else {
            printError();
            return betrag;
        }
    }

    private void printError() {
        System.out.println("Keine Variante gefunden!");
        System.out.print("Folgender Betrag konnte nicht umgerechnet werden: ");
    }

    private double calculateTwoDecimals(double umgerechneterBetrag) {
        return Math.floor(umgerechneterBetrag * 100)/100;
    }

    //TemplateHook - Schablonenmethode
    public final double berechnen(String variante, double betrag) {
        double umgerechneterBetrag = umrechnen(variante, betrag);
        umgerechneterBetrag = calculateTwoDecimals(umgerechneterBetrag);
        benachrichtigen(variante, betrag, umgerechneterBetrag);
        return umgerechneterBetrag;
    }

    //Builder
    public static WRBuilder builder() {
        WRBuilder builder = new WRBuilder();
        return builder;
    }

    //Observer
    private List<WRObserver> observers;

    @Override
    public void registrieren(WRObserver observer) {
        observers.add(observer);
    }

    @Override
    public void entfernen(WRObserver observer) {
        observers.remove(observers.indexOf(observer));
    }

    private void benachrichtigen(String variante, double betrag, double umgerechneterBetrag) {
        String[] waehrungen = variante.split("to");
        for (WRObserver observer : observers) {
            observer.update(waehrungen[0].toUpperCase(), waehrungen[1].toUpperCase(), betrag, umgerechneterBetrag);
        }
    }
}