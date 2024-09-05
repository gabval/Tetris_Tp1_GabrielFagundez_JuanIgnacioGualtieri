package com.example;

public class Piece {

    public int[][] piece; 

    public Piece(){
        
    } 

    public Piece (int[][] piece){

        this.piece = piece;
    }

    public void setPiece(int[][] piece){

        this.piece = piece;

    }
    public int[][] getPiece(){
        
        return piece;
    }

   // Método para rotar a la derecha 
   public int[][] rotarDerecha(Piece piece) {

    int n = piece.getPiece().length;
    int m = piece.getPiece()[0].length;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            piece.getPiece()[j][n - 1 - i] = piece.getPiece()[i][j];  // Rotación a la derecha
        }
    }

    return piece.getPiece();
}

// Método para rotar a la izquierda
public int[][] rotarIzquierda(Piece piece) {
    
    int n = piece.getPiece().length;
    int m = piece.getPiece()[0].length;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            piece.getPiece()[m - 1 - j][i] = piece.getPiece()[i][j];  // Rotación a la izquierda
        }
    }

    return piece.getPiece();

    }
}

