package com.example.tetrisjavafx;

import java.util.Arrays;

public class Grille {

    private final int[] limites = new int[4]; // gauche , bas, droite, haut
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

    public void setLimit_Y(int[] limit_Y) {
        this.limit_Y = limit_Y;
    }

    public int getTaille_case() {
        return taille_case;
    }

    public boolean check_in_grille_left_right(Piece piece){
        return limites[0] <= piece.getminX() && limites[2] <= piece.getmaxX();
    }

    public boolean reach_bottom(Piece piece){
        for(int i = piece.getminX()/taille_case; i <= piece.getmaxX()/taille_case; i++){
            if(limit_Y[i] < piece.getY_bottom()[i]){
                return false;
            }
        }
        return true;
    }
}
