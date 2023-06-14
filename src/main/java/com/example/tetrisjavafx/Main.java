package com.example.tetrisjavafx;

import java.io.IOException;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;



public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {


        Piece piece = new Piece();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Group rootGroup = new Group(root, piece.getPolygon());
        Scene scene = new Scene(rootGroup);


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

                switch(event.getCode()) {

                    case SPACE:
                        controller.rushDown();
                        break;
                    case D:
                        controller.moveRight();
                        break;
                    case Q:
                        controller.moveLeft();
                        break;
                    case RIGHT:
                        controller.rotateRight();
                        break;
                    case LEFT:
                        controller.rotateLeft();
                        break;
                    default:
                        break;
                }
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}