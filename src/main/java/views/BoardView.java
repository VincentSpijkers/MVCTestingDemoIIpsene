package views;

import controllers.BoardController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import models.Player;

public class BoardView implements PlayerObserver, DiceObserver {

    private final Circle playerIcon = new Circle(10, Color.RED);
    BoardController boardController;
    @FXML
    private GridPane boardGrid;
    @FXML
    private Label diceRollLabel;

    @FXML
    protected void initialize(){
        this.boardController = BoardController.getInstance();
        this.boardController.registerDiceObserver(this);
        this.boardController.registerPlayerObserver(this);
        this.buildPlayingBoard();
        this.boardController.drawPlayer();
    }

    @FXML
    public void rollDice(){
        this.boardController.rollDice();
    }

    public void buildPlayingBoard(){
        for (int i = 0; i < 10; i++){
            this.boardGrid.addRow(i);
            for (int j = 0; j < 10; j++){
                HBox box = new HBox();
                box.setMinWidth(40);
                box.setMinHeight(40);
                box.setStyle("-fx-border-color: black; -fx-border-width: 1");
                this.boardGrid.addColumn(j, box);
            }
        }
    }

    public void drawPlayer(Player player){
        this.boardGrid.getChildren().remove(this.playerIcon);
        this.boardGrid.add(this.playerIcon, player.getX(), player.getY());
    }

    public void displayDiceRoll(int diceRollResult){
        this.diceRollLabel.setText(String.valueOf(diceRollResult));
    }

    @Override
    public void update(Player player) {
        this.drawPlayer(player);
    }

    @Override
    public void update(int rolledNumber) {
        this.displayDiceRoll(rolledNumber);
        this.boardController.updatePlayerPosition(rolledNumber);
    }
}
