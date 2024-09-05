package com.example;

public class PieceL extends Piece{

    public PieceL(){

        int[][] PieceL = {
        
            {0,1,0},
            {0,1,0},
            {0,1,1}
            
        };

        setPiece(PieceL);
    }

    public PieceL(int[][] piece ){
    
        super(piece);
    
    }

    
}