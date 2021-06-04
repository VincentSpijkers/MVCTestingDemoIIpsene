package services;

import controllers.BoardController;
import models.Player;

public class FirebaseService {
    static FirebaseService firebaseService;

    public static FirebaseService getInstance(){
        if (firebaseService == null){
            firebaseService = new FirebaseService();
        }
        return firebaseService;
    }

    public Player fetchCurrentPlayer(){
        return new Player();
    }

}
