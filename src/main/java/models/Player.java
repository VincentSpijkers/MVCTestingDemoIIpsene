package models;

import shared.PlayerObservable;
import views.PlayerObserver;

import java.util.ArrayList;
import java.util.List;

public class Player implements PlayerObservable {

    private int x = 0;
    private int y = 0;
    private List<PlayerObserver> observers = new ArrayList<PlayerObserver>();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void updatePosition(int places, int boardLimit){
        if (this.x + places >= boardLimit){
            int overshot = (this.x + places) % boardLimit;
            this.y = this.y +1;
            this.x = overshot;
        }else {
            this.x = this.x + places;
        }
        this.notifyObservers();
    }

    @Override
    public void registerObserver(PlayerObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregisterObserver(PlayerObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PlayerObserver observer: this.observers){
            observer.update(this);
        }
    }
}
