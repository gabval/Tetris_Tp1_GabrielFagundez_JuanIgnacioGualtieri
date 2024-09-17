package com.example;
import java.util.Random;

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

    // Método para verificar si el juego ha terminado
    public boolean esFinDelJuego() {
        // Si cualquier celda de la primera fila está ocupada, el juego ha terminado
        for (int j = 0; j < columna; j++) {
            if (board[0][j] != 0) {
                return true;
            }
        }
        return false;
    }

    // Método para colocar una pieza en una posición específica del board
    public int colocarPiece(Piece piece) {
        // Verificar si el juego ha terminado antes de colocar una nueva pieza
        if (esFinDelJuego()) {
            return -1;  // Indicador de que el juego ha terminado
        }

        Random rand = new Random();
        int columnaAleatoria = rand.nextInt(columna - piece.getPiece()[0].length + 1);
        int filaInicial = 0;

        // Aseguramos que la primera fila esté disponible para colocar la pieza
        if (esValido(piece, filaInicial, columnaAleatoria)) {
            colocarPieceEnPosicion(piece, filaInicial, columnaAleatoria);
        }

        return columnaAleatoria;
    }

    // Método para eliminar una fila completa y bajar todas las superiores
    public void eliminarFila(int fila) {
        // Desplazar todas las filas superiores hacia abajo
        for (int i = fila; i > 0; i--) {
            for (int j = 0; j < columna; j++){
                board[i][j] = board[i - 1][j];
            }
        }
        // Vaciar la primera fila (ahora está vacía después del desplazamiento)
        for (int j = 0; j < columna; j++) {
            board[fila][j] = 0;
        }
    }

    // Método para eliminar todas las filas completas
    public void eliminarFilasCompletas() {
        for (int i = 0; i < fila; i++) {
            if (FilaCompleta(i)) {
                eliminarFila(i);
            }
        }
    }

    public void colocarPieceEnPosicion(Piece piece, int fila, int columna) {
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
        while (esValido(piece, fila + 1, columnaInicial)) {
            fila++;  // Incrementa la fila para bajar la pieza
        }

        // Coloca la pieza en la nueva posición (última posición válida)
        colocarPieceEnPosicion(piece, fila, columnaInicial);
    }

    // Verifica si la pieza puede moverse a una posición específica
    public boolean esValido(Piece piece, int fila, int columna) {
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

    // Método para mover la pieza hacia la izquierda
    public boolean moverIzquierda(Piece piece, int filaInicial, int columnaInicial) {
        // Verificamos si se puede mover a la izquierda
        if (columnaInicial > 0 && esValido(piece, filaInicial, columnaInicial - 1)) {
            // Limpiamos la posición original de la pieza
            limpiarPosicion(piece, filaInicial, columnaInicial);
            // Movemos la pieza una columna a la izquierda
            colocarPieceEnPosicion(piece, filaInicial, columnaInicial - 1);
            return true;
        }
        return false;
    }

    // Método para mover la pieza hacia la derecha
    public boolean moverDerecha(Piece piece, int filaInicial, int columnaInicial) {
        // Verificamos si se puede mover a la derecha
        if (columnaInicial + piece.getPiece()[0].length < columna && esValido(piece, filaInicial, columnaInicial + 1)) {
            // Limpiamos la posición original de la pieza
            limpiarPosicion(piece, filaInicial, columnaInicial);
            // Movemos la pieza una columna a la derecha
            colocarPieceEnPosicion(piece, filaInicial, columnaInicial + 1);
            return true;
        }
        return false;
    }

    // Método para limpiar la posición original de la pieza en el tablero
    public void limpiarPosicion(Piece piece, int filaInicial, int columnaInicial) {
        for (int i = 0; i < piece.getPiece().length; i++) {
            for (int j = 0; j < piece.getPiece()[i].length; j++) {
                if (piece.getPiece()[i][j] != 0) {
                    setBoard(filaInicial + i, columnaInicial + j, 0);
                }
            }
        }
    }

        // Método para verificar si se ha ganado el juego
        public boolean ganarJuego() {

            int filasLlenas = 0;

            for (int i = 0; i < fila; i++) {
                if (FilaCompleta(i)) {
                    filasLlenas++;
                }
            }

            if (filasLlenas >= 5){
                return true;

            }else{

                return false;
            }
        }
    
        // Verifica si una fila está completamente llena
        private boolean FilaCompleta(int fila) {

            for (int j = 0; j < columna; j++) {
                if (board[fila][j] == 0) {
                    return false;
                }
            }
            return true;
        }
    
    
}
