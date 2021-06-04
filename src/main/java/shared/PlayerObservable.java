package shared;

import views.PlayerObserver;

public interface PlayerObservable {
    void registerObserver(PlayerObserver observer);

    void unregisterObserver(PlayerObserver observer);

    void notifyObservers();
}
