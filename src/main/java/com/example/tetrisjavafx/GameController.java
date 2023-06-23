package com.example.tetrisjavafx;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class GameController{
    private final int taille_case = 50;
    private Piece piece;
    private AnimationTimer gameLoop;

    public void init(Scene scene) {
        piece = new Piece();
        //Grille grille = new Grille();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()) {
                    // case SPACE -> controller.rushDown(); essayer de l'implementer plus tard
                    case D -> piece.moveRight(taille_case);
                    case Q -> piece.moveLeft(taille_case);
                    // case RIGHT -> controller.rotateRight(); voir si on peut mettre les rotations plus tard
                    // case LEFT -> controller.rotateLeft();
                    default -> {
                    }
                }
            }
        });

    }


    public void startGameLoop() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };
        gameLoop.start();
    }

    public void stopGameLoop() {
        gameLoop.stop();
    }


}