package com.example;

public class PieceDog extends Piece {

    public PieceDog(){

        int[][] PieceDog = {
    
            {1,1,0},
            {0,1,1},
            {0,0,0}
        
        };

        setPiece(PieceDog);
    }

    public PieceDog(int[][] piece ){

        super(piece);

    }
}