package com.example;
import java.util.Random;

public class Piece {

    public int[][] piece; 
    private Random generadorAleatorios = new Random();

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
    public void rotarDerecha() {

        int n = piece.length;
        int m = piece[0].length;
        int[][] nuevaForma = new int [n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nuevaForma[j][n - 1 - i] = nuevaForma[i][j];  // Rotación a la derecha
            }
        }

        setPiece(getPiece());
    }

    // Método para rotar a la izquierda
    public void rotarIzquierda() {
        
        int n = piece.length;
        int m = piece[0].length;
        int[][] nuevaForma = new int [n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                piece[m - 1 - j][i] = piece[i][j];  // Rotación a la izquierda
            }
        }

        setPiece(getPiece());

        }
        //elegir lado random
    public void elegirLadoRandom(Piece piece){
        int numeroAleatorio = generadorAleatorios.nextInt(3);
            
        if (numeroAleatorio == 0){
            rotarDerecha();
        }

        if (numeroAleatorio == 1){
            rotarIzquierda();
        }

        else{
        }
    }
}

