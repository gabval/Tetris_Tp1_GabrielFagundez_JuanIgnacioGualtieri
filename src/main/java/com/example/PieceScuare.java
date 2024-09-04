package com.example;

public class PieceScuare extends Piece {

    public PieceScuare(){

        int[][] PieceScuare = {
    
            {1,1,0},
            {1,1,0},
            {0,0,0}
        
        };

        setPiece(PieceScuare);
    }

    public PieceScuare(int[][] piece ){

        super(piece);

    }
}