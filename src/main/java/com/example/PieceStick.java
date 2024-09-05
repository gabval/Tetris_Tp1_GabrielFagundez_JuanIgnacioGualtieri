package com.example;

public class PieceStick extends Piece{

    public PieceStick(){

        int[][] PieceStick = {
    
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0}

        
        };

        setPiece(PieceStick);
    }

    public PieceStick(int[][] piece ){

        super(piece);
        

    }
    
}
