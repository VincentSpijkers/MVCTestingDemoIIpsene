package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;

public class StartMenuView {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void startGame(MouseEvent event) throws IOException {
        this.root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/board.fxml"));
        this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }
}
