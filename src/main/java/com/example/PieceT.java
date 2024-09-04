package com.example;

public class PieceT  extends Piece{
    
    public PieceT(){

        int[][] PieceT = {
    
            {0,1,0},
            {1,1,1},
            {0,0,0}
        
        };

        setPiece(PieceT);
    }

    public PieceT(int[][] piece ){

        super(piece);

    }
}
