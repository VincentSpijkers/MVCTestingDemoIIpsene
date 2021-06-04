package controllers;

import models.Dice;
import models.Player;
import services.FirebaseService;
import views.DiceObserver;
import views.PlayerObserver;

public class BoardController {
    private final int boardLimit = 10;
    FirebaseService firebaseService;
    static BoardController boardController;
    private Dice dice;
    private Player player;

   public BoardController(){
       this.firebaseService = FirebaseService.getInstance();
       this.player = this.firebaseService.fetchCurrentPlayer();
       this.dice = new Dice();
   }

    public static BoardController getInstance(){
        if (boardController == null){
            boardController = new BoardController();
        }
        return boardController;
    }

    public void rollDice(){
        this.dice.rollDice();
    }

    public void drawPlayer(){
       this.player.notifyObservers();
    }

    public void updatePlayerPosition(int places){
        player.updatePosition(places, this.boardLimit);
    }

    public void registerDiceObserver(DiceObserver boardView) {
        this.dice.registerObserver(boardView);
    }

    public void registerPlayerObserver(PlayerObserver boardView) {
        this.player.registerObserver(boardView);
    }
}
