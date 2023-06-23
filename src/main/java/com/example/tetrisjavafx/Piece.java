package com.example.tetrisjavafx;

import javafx.scene.shape.Polygon;

import java.util.Random;

public class Piece {
    private final Polygon polygon;
    private int[] left_x;
    private int[] right_x;
    private int[] y_top;
    private int[] y_bottom;

    public Piece() {
        Polygon[] list_polygon = new Polygon[4];
        initializePolygons(list_polygon);
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        polygon = list_polygon[randomNumber];
        getMinMaxCoordinates();
     }


    public void getMinMaxCoordinates() {
        int min_x = 0;
        int max_x = 0;
        int min_y = 0;
        int max_y = 0;
        for (int i = 0; i < polygon.getPoints().size(); i += 2) {
            int x = (int) Math.round(polygon.getPoints().get(i));
            int y = (int) Math.round(polygon.getPoints().get(i + 1));
            min_y = Math.min(min_y, y);
            max_y= Math.max(max_y, y);
            min_x = Math.min(min_x, x);
            max_x= Math.max(max_x, x);
        }
        // listes x
        left_x = new int[max_y - min_y];
        right_x = new int[max_y - min_y];
        double iterator = min_y;
        for(int i = 0; i<y_bottom.length; i++){
            double tempo1 = 0;
            double tempo2 = 0;
            boolean loaded = false;
            for (int k = 1; k < polygon.getPoints().size() + 1; k += 2) {
                if(polygon.getPoints().get(k) == iterator & !loaded){
                    tempo1 = polygon.getPoints().get(k-1);
                    loaded = true;
                } else if (polygon.getPoints().get(k) == iterator & loaded) {
                    tempo2 = polygon.getPoints().get(k-1);
                }
            }
            if(tempo1 < tempo2){
                left_x[i] = (int) tempo1;
                right_x[i] = (int) tempo2;
            }else {
                left_x[i] = (int) tempo2;
                right_x[i] = (int) tempo1;
            }
            iterator += 50;
        }
        // listes y
        y_bottom = new int[max_x - min_x];
        y_top = new int[max_x - min_x];
        iterator = min_x;
        for(int i = 0; i<y_bottom.length; i++){
            double tempo1 = 0;
            double tempo2 = 0;
            boolean loaded = false;
            for (int k = 0; k < polygon.getPoints().size(); k += 2) {
                if(polygon.getPoints().get(k) == iterator & !loaded){
                    tempo1 = polygon.getPoints().get(k+1);
                    loaded = true;
                } else if (polygon.getPoints().get(k) == iterator & loaded) {
                    tempo2 = polygon.getPoints().get(k+1);
                }
            }
            if(tempo1 > tempo2){
                y_bottom[i] = (int) tempo1;
                y_top[i] = (int) tempo2;
            }else {
                y_bottom[i] = (int) tempo2;
                y_top[i] = (int) tempo1;
            }
            iterator += 50;
        }
    }

    public void moveRight(int taille_case){
        for(int i = 0; i < y_bottom.length; i++){
            left_x[i] += taille_case;
            right_x[i] += taille_case;
        }
    }

    public void moveLeft(int taille_case){
        for(int i = 0; i < y_bottom.length; i++){
            left_x[i] -= taille_case;
            right_x[i] -= taille_case;
        }
    }

    public void moveDown(int distance){
        for(int i = 0; i < y_bottom.length; i++){
            y_bottom[i] += distance;
            y_top[i] += distance;
        }
    }

    public int getminX(){
        int to_return = 0;
        for(int k: left_x){
            if (k < to_return){
                to_return = k;
            }
        }
        return to_return;
    }

    public int getmaxX(){
        int to_return = 0;
        for(int k: right_x){
            if (k > to_return){
                to_return = k;
            }
        }
        return to_return;
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
}
