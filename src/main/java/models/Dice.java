package models;

import shared.DiceObservable;
import views.DiceObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dice implements DiceObservable {
    private int rolledNumber;
    private int diceSize = 6;
    private List<DiceObserver> observers = new ArrayList<DiceObserver>();

    public Dice(){}

    public Dice(int diceSize){
        this.diceSize = diceSize;
    }

    public void rollDice(){
        int diceRoll = ThreadLocalRandom.current().nextInt(1, this.diceSize + 1);
        this.rolledNumber = diceRoll;
        this.notifyObservers();
    }

    @Override
    public void registerObserver(DiceObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregisterObserver(DiceObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (DiceObserver observer: this.observers){
            observer.update(this.rolledNumber);
        }
    }
}
