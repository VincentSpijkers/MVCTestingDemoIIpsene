package shared;

import views.DiceObserver;

public interface DiceObservable {
    void registerObserver(DiceObserver observer);

    void unregisterObserver(DiceObserver observer);

    void notifyObservers();
}
