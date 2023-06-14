package com.example.tetrisjavafx;

import javafx.scene.shape.Polygon;

import java.util.Random;

public class Piece {
    private final Polygon polygon;
    private int min_x;
    private int max_x;
    private int[] y_top;
    private int[] y_bottom;

    public Piece() {
        Polygon[] list_polygon = new Polygon[4];
        initializePolygons(list_polygon);
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        polygon = list_polygon[randomNumber];
        getMinMaxCoordinates();
        y_bottom = new int[max_x - min_x];
        y_top = new int[max_x - min_x];
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

    public void getMinMaxCoordinates() {

        for (int i = 0; i < polygon.getPoints().size(); i += 2) {
            int x = (int) Math.round(polygon.getPoints().get(i));
            int y = (int) Math.round(polygon.getPoints().get(i + 1));

            min_x = Math.min(min_x, x);
            max_x= Math.max(max_x, x);
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
        for(int i = 0; i < y_bottom.length; i++){
            y_bottom[i] += distance;
            y_top[i] += distance;
        }
    }

    public int getMin_x() {
        return min_x;
    }

    public int getMax_x() {
        return max_x;
    }

    public int[] getY_top() {
        return y_top;
    }

    public int[] getY_bottom() {
        return y_bottom;
    }

    public Polygon getPolygon() {
        return polygon;
    }
}
