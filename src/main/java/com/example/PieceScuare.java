package com.example;

public class PieceScuare extends Piece {

    public PieceScuare(){

        int[][] PieceScuare = {
    
            {1,1},
            {1,1}
        
        };

        setPiece(PieceScuare);
    }

    public PieceScuare(int[][] piece ){

        super(piece);

    }
}