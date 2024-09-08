package com.example;

public class Board {

    public int[][] board;
    public int fila = 10;
    public int columna = 20;

    // Constructor por defecto
    public Board() {
        board = new int[fila][columna];
    }

    // Constructor con board personalizado
    public Board(int[][] board, int fila, int columna) {
        
        this.board = board;
        this.fila = fila;
        this.columna = columna;
    }

    // Método para asignar una forma en el board en una posición específica
    public void setBoard(int fila, int columna, int formaPieza) {
        board[fila][columna] = formaPieza;
    }

    // Obtener el estado del board
    public int[][] getBoard() {
        return board;
    }

    // Método para colocar una pieza en una posición específica del board
    public void colocarPiece(Piece piece, int fila, int columna) {
        for (int i = 0; i < piece.getPiece().length; i++) {
            for (int j = 0; j < piece.getPiece()[i].length; j++) {
                if (piece.getPiece()[i][j] != 0) {
                    setBoard(fila + i, columna + j, piece.getPiece()[i][j]);
                }
            }
        }
    }

    // Método para descender una pieza en el tablero
    public void descenderPiece(Piece piece, int filaInicial, int columnaInicial) {
        // Primero, limpia la posición original de la pieza
        for (int i = 0; i < piece.getPiece().length; i++) {
            for (int j = 0; j < piece.getPiece()[i].length; j++) {
                if (piece.getPiece()[i][j] != 0) {
                    setBoard(filaInicial + i, columnaInicial + j, 0);
                }
            }
        }

        int fila = filaInicial;

        // Mueve la pieza hacia abajo mientras sea válido
        while (esValido(piece, fila + piece.getPiece().length, columnaInicial)) {
            fila++;  // Incrementa la fila para bajar la pieza
        }

        // Coloca la pieza en la nueva posición (última posición válida)
        colocarPiece(piece, fila, columnaInicial);
    }

    // Verifica si la pieza puede moverse a una posición específica
    private boolean esValido(Piece piece, int fila, int columna) {
        for (int i = 0; i < piece.getPiece().length; i++) {
            for (int j = 0; j < piece.getPiece()[i].length; j++) {
                if (piece.getPiece()[i][j] != 0) {
                    if (fila + i >= board.length || columna + j >= board[0].length || board[fila + i][columna + j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}