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
    
}
