package com.example.tetrisjavafx;

import java.util.Arrays;

public class Grille {

    private int[] limites = new int[4]; // gauche , haut, droite, bas
    private final int taille_case;
    private int[] limit_Y;

    public Grille(int largeur, int hauteur, int taille_case){
        limit_Y = new int[largeur/taille_case];
        Arrays.fill(limit_Y, hauteur);
        this.taille_case = taille_case;
        limites[0] = 0;
        limites[1] = hauteur;
        limites[2] = largeur;
        limites[3] = 0;
    }

    public int getTaille_case() {
        return taille_case;
    }

    public boolean check_in_grille_left_right(Piece piece){
        if(limites[0] > piece.getMin_x() || limites[2] > piece.getMax_x()){
            return false;
        }
        return true;
    }

    public boolean reach_bottom(Piece piece){
        if(piece.getMax_y() > )
    }
}
