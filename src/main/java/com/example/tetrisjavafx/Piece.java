package com.example.tetrisjavafx;

import javafx.scene.shape.Polygon;

import java.util.Random;

public class Piece {
    private final Polygon polygon;
    private int min_x;
    private int max_x;
    private int[] y;

    public Piece() {
        Polygon[] list_polygon = new Polygon[4];
        initializePolygons(list_polygon);
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        polygon = list_polygon[randomNumber];
        int[] min_max_coordinates = getMinMaxCoordinates();
        min_x = min_max_coordinates[0];
        max_x = min_max_coordinates[2];
        y = new int[max_x - min_x];
     }

    private void initializePolygons(Polygon[] list_polygon) {
        Polygon polygon1 = new Polygon();
        polygon1.getPoints().addAll(
                0.0, 0.0,
                0.0, 100.0,
                50.0, 100.0,
                50.0, 50.0,
                100.0, 50.0,
                100.0, 0.0
        );
        list_polygon[0] = polygon1;

        Polygon polygon2 = new Polygon();
        polygon2.getPoints().addAll(
                0.0, 0.0,
                0.0, 100.0,
                100.0, 100.0,
                100.0, 0.0
        );
        list_polygon[1] = polygon2;

        Polygon polygon3 = new Polygon();
        polygon3.getPoints().addAll(
                0.0, 0.0,
                0.0, 100.0,
                50.0, 100.0,
                50.0, 50.0,
                100.0, 50.0,
                100.0, 0.0
        );
        list_polygon[2] = polygon3;

        Polygon polygon4 = new Polygon();
        polygon4.getPoints().addAll(
                0.0, 0.0,
                0.0, 100.0,
                50.0, 100.0,
                50.0, 50.0,
                -50.0, 50.0,
                -50.0, 0.0
        );
        list_polygon[3] = polygon4;
    }

    public int[] getMinMaxCoordinates() {
        int minX = Integer.MIN_VALUE;
        int maxX = Integer.MAX_VALUE;

        for (int i = 0; i < polygon.getPoints().size(); i += 2) {
            int x = (int) Math.round(polygon.getPoints().get(i));
            int y = (int) Math.round(polygon.getPoints().get(i + 1));

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
        }
    }

    public void moveRight(int taille_case){
        min_x += taille_case;
        max_x += taille_case;
    }

    public void moveLeft(int taille_case){
        min_x -= taille_case;
        max_x -= taille_case;
    }

    public void moveDown(int distance){
        for(x in y){

        }
    }

    public int getMin_x() {
        return min_x;
    }

    public int getMax_x() {
        return max_x;
    }

    public int[] getY() {
        return y;
    }

    public Polygon getPolygon() {
        return polygon;
    }
}
