package com.example.tetrisjavafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class sceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switch_to_game(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("src/main/resources/com/example/tetrisjavafx/view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switch_to_menu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("src/main/resources/com/example/tetrisjavafx/start.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow(); // cette ligne
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switch_to_gameover(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("src/main/resources/com/example/tetrisjavafx/game_over.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

