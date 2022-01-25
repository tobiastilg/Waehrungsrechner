package waehrungsrechner.observer;

public interface WRSubject {

    void registrieren(WRObserver observer);
    void entfernen(WRObserver observer);
    //void benachrichtigen();
}
