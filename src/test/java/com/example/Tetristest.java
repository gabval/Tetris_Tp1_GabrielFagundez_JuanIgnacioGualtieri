package com.example;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;;

//import java.util.Random;

@SpringBootConfiguration
@SpringBootTest

public class TetrisTest {

    @Test
    void PieceDog_Test(){

        PieceDog pd = new PieceDog();
        assert pd.getPiece() != null;

    }
    
    @Test
    void PieceL_Test(){

        PieceL pl = new PieceL();
        assert pl.getPiece() != null;
    }

    @Test
    void PieceScuare_Test(){

       PieceScuare ps = new PieceScuare();
        assert ps.getPiece() != null;
    }

    @Test
    void PieceT_Test(){

        PieceT pt = new PieceT();
        assert pt.getPiece() != null;
    }

    @Test
    void PieceStick_Test(){

        PieceStick pstick = new PieceStick();
        assert pstick.getPiece() != null;
    } 

    @Test
    void Rotar_Derecha_PieceDog_test(){

        PieceDog pd1 = new PieceDog();
        PieceDog pd2 = new PieceDog();

        pd1.rotarDerecha();

        assert pd1.getPiece() != pd2.getPiece();
        
    }

    @Test
    void Rotar_Izquieda_PieceDog_test(){

        PieceDog pd1 = new PieceDog();
        PieceDog pd2 = new PieceDog();

        pd1.rotarIzquierda();

        assert pd1.getPiece() != pd2.getPiece();
        
    }

    @Test
    void Rotar_Derecha_PieceL_test(){

        PieceL pl1 = new PieceL();
        PieceL pl2 = new PieceL();

        pl1.rotarDerecha();

        assert pl1.getPiece() != pl2.getPiece();
        
    }

    @Test
    void Rotar_Izquieda_PieceL_test(){

        PieceL pl1 = new PieceL();
        PieceL pl2 = new PieceL();

        pl1.rotarIzquierda();

        assert pl1.getPiece() != pl2.getPiece();
        
    }

    @Test
    void Rotar_Derecha_PieceTPieceT_test(){

       PieceT ps1 = new PieceT();
       PieceT ps2 = new PieceT();

        ps1.rotarDerecha();

        assert ps1.getPiece() != ps2.getPiece();
        
    }

    @Test
    void Rotar_Izquieda_PieceTPieceT_test(){

       PieceT ps1 = new PieceT();
       PieceT ps2 = new PieceT();

        ps1.rotarIzquierda();

        assert ps1.getPiece() != ps2.getPiece();
        
    }

    @Test
    void Rotar_Derecha_PieceT_test(){

        PieceT pt1 = new PieceT();
        PieceT pt2 = new PieceT();

        pt1.rotarDerecha();

        assert pt1.getPiece() != pt2.getPiece();
        
    }

    @Test
    void Rotar_Izquierda_PieceT_test(){

        PieceT pt1 = new PieceT();
        PieceT pt2 = new PieceT();

        pt1.rotarIzquierda();

        assert pt1.getPiece() != pt2.getPiece();
        
    }
   
    @Test
    void Rotar_Derecha_PieceStick_test(){

        PieceStick pStick1 = new PieceStick();
        PieceStick pStick2 = new PieceStick();

        pStick1.rotarDerecha();

        assert pStick1.getPiece() != pStick2.getPiece();
        
    }

    @Test
    void Rotar_Izquieda_PieceStick_test(){

        PieceStick pStick1 = new PieceStick();
        PieceStick pStick2 = new PieceStick();

        pStick1.rotarIzquierda();

        assert pStick1.getPiece() != pStick2.getPiece();
        
    }
    
    
    @Test
    void Existencia_del_board_test(){

        Board board = new Board();

        assertNotNull(board.getBoard());

    }
    
    @Test
    void Board10x20_Test() {
        
        Board board = new Board();

        int[][] tabla = board.getBoard();

        assertEquals(10, tabla.length); 

        }
    
    @Test
    void comprobar_el_ingreso_de_una_pieza_al_board_test(){

        Board board = new Board();
        PieceDog pD = new PieceDog();

        board.colocarPiece(pD);

        assert board.getBoard()[0][0] == 0;

    }


    @Test
    void descender_pieceScuare_con_clock_test(){

        Board board = new Board();
        PieceScuare pS = new PieceScuare();
        PieceScuare pS2 = new PieceScuare();
        Reloj reloj1 = new Reloj();

        pS.elegirLadoRandom(pS);
        assert pS.getPiece() != pS2.getPiece();

        int columnaAleatoria = board.colocarPiece(pS);
        board.colocarPiece(pS);

        assertEquals (1,board.getBoard()[0][columnaAleatoria]);

        reloj1.tic();
        reloj1.tic();
        assert reloj1.getTic() == 2;

        board.descenderPiece(pS,0,0);
        assertEquals (0,board.getBoard()[0][0]);

    }
    @Test
    void descender_pieceT_con_clock_test(){

        Board board = new Board();
        PieceT pT = new PieceT();
        PieceT pT2 = new PieceT();
        Reloj reloj1 = new Reloj();

        pT.elegirLadoRandom(pT); 
        assert pT.getPiece() != pT2.getPiece();

        int columnaAleatoria = board.colocarPiece(pT);

        board.colocarPiece(pT);

        assertEquals (1,board.getBoard()[0][columnaAleatoria + 1]); 

        reloj1.tic();
        reloj1.tic();
        assert reloj1.getTic() == 2;

        board.descenderPiece(pT,0,0);
        assertEquals (0,board.getBoard()[0][0]);

    }
    @Test
    void descender_pieceDog_con_clock_test(){

        Board board = new Board();
        PieceDog pD = new PieceDog();
        PieceDog pD2 = new PieceDog();
        Reloj reloj1 = new Reloj();

        pD.elegirLadoRandom(pD); 
        assert pD.getPiece() != pD2.getPiece();

        int columnaAleatoria = board.colocarPiece(pD);

        board.colocarPiece(pD);

        assertEquals (1,board.getBoard()[0][columnaAleatoria + 1]);

        reloj1.tic();
        reloj1.tic();
        assert reloj1.getTic() == 2;

        board.descenderPiece(pD,0,0);
        assertEquals (0,board.getBoard()[0][0]);

    }

    @Test
    void descender_pieceL_con_clock_test(){

        Board board = new Board();
        PieceL pL = new PieceL();
        PieceL pL2 = new PieceL();

        Reloj reloj1 = new Reloj();

        //pL.elegirLadoRandom(pL); 
        assert pL.getPiece() != pL2.getPiece();

        int columnaAleatoria = board.colocarPiece(pL);
        board.colocarPiece(pL);

        assertEquals (1,board.getBoard()[0][columnaAleatoria + 1]);

        reloj1.tic();
        reloj1.tic();
        assert reloj1.getTic() == 2;

        board.descenderPiece(pL,0,0);

    }
    @Test
    void descender_pieceStick_con_clock_test(){

        Board board = new Board();
        PieceStick pStick = new PieceStick();
        PieceStick pStick2 = new PieceStick();
        

        Reloj reloj1 = new Reloj();

        pStick.elegirLadoRandom(pStick); 
        assert pStick.getPiece() != pStick2.getPiece();
       
        int columnaAleatoria = board.colocarPiece(pStick);
        board.colocarPiece(pStick);

        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);
        reloj1.tic();
        reloj1.tic();

        assert reloj1.getTic() == 2;

        board.descenderPiece(pStick,0,0);
        assertEquals (0,board.getBoard()[0][1]);

    }
    @Test
    void colocar_pieceStick_en_primera_fila_aleatoria_test() {

        Board board = new Board();
        PieceStick pS = new PieceStick(); 
        
        pS.elegirLadoRandom(pS);

        int columnaAleatoria = board.colocarPiece(pS);
    
        board.colocarPiece(pS);

        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[2][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[3][columnaAleatoria + 1]);
    
    }
        @Test
        void colocar_pieceSquare_en_primera_fila_y_columna_aleatoria_test() {
        Board board = new Board();
        PieceScuare pS = new PieceScuare(); 

        pS.elegirLadoRandom(pS);

        int columnaAleatoria = board.colocarPiece(pS);
    
        board.colocarPiece(pS);

        assertEquals(1, board.getBoard()[0][columnaAleatoria]);
        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
    }

    @Test
        void colocar_pieceDog_en_primera_fila_y_columna_aleatoria_test() {
        Board board = new Board();
        PieceDog pD = new PieceDog(); 

        pD.elegirLadoRandom(pD);

        int columnaAleatoria = board.colocarPiece(pD);
    
        board.colocarPiece(pD);

        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
    }
    @Test
        void colocar_pieceL_en_primera_fila_y_columna_aleatoria_test() {
        Board board = new Board();
        PieceL pL = new PieceL(); 

        pL.elegirLadoRandom(pL);

        int columnaAleatoria = board.colocarPiece(pL);
    
        board.colocarPiece(pL);

        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
    }
    @Test
        void colocar_pieceT_en_primera_fila_y_columna_aleatoria_test() {
        Board board = new Board();
        PieceT pT = new PieceT(); 

        pT.elegirLadoRandom(pT);

        int columnaAleatoria = board.colocarPiece(pT);
    
        board.colocarPiece(pT);

        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
        assertEquals(1, board.getBoard()[1][columnaAleatoria + 1]);
    }  
    
    @Test
    void no_puede_colocar_pieceDog_en_primera_fila_llena(){

        Board board = new Board();
        PieceDog pD = new PieceDog();

        pD.elegirLadoRandom(pD);
        // Llenar la primera fila
        for (int j = 0; j < board.columna; j++) {
            board.setBoard(0, j, 1);  // Llena la primera fila con valores no nulos
        }
         // Intentar colocar una nueva pieza en el tablero
         int result = board.colocarPiece(pD);
        
         // Verificar que el juego detecte que ya no se pueden colocar más piezas
         assertEquals(-1, result);
     }
     @Test
    void no_puede_colocar_pieceL_en_primera_fila_llena(){

        Board board = new Board();
        PieceL pL = new PieceL();

        pL.elegirLadoRandom(pL);
        // Llenar la primera fila
        for (int j = 0; j < board.columna; j++) {
            board.setBoard(0, j, 1);  // Llena la primera fila con valores no nulos
        }
         // Intentar colocar una nueva pieza en el tablero
         int result = board.colocarPiece(pL);
        
         // Verificar que el juego detecte que ya no se pueden colocar más piezas
         assertEquals(-1, result);
     }
     @Test
    void no_puede_colocar_pieceT_en_primera_fila_llena(){

        Board board = new Board();
        PieceT pT = new PieceT();

        pT.elegirLadoRandom(pT);
        // Llenar la primera fila
        for (int j = 0; j < board.columna; j++) {
            board.setBoard(0, j, 1);  // Llena la primera fila con valores no nulos
        }
         // Intentar colocar una nueva pieza en el tablero
         int result = board.colocarPiece(pT);
        
         // Verificar que el juego detecte que ya no se pueden colocar más piezas
         assertEquals(-1, result);
     }
     @Test
    void no_puede_colocar_pieceScuare_en_primera_fila_llena(){

        Board board = new Board();
        PieceScuare pS = new PieceScuare();

        pS.elegirLadoRandom(pS);
        // Llenar la primera fila
        for (int j = 0; j < board.columna; j++) {
            board.setBoard(0, j, 1);  // Llena la primera fila con valores no nulos
        }
         // Intentar colocar una nueva pieza en el tablero
         int result = board.colocarPiece(pS);
        
         // Verificar que el juego detecte que ya no se pueden colocar más piezas
         assertEquals(-1, result);
     }
     @Test
    void no_puede_colocar_pieceStick_en_primera_fila_llena(){

        Board board = new Board();
        PieceStick pStick = new PieceStick();

        pStick.elegirLadoRandom(pStick);
        // Llenar la primera fila
        for (int j = 0; j < board.columna; j++) {
            board.setBoard(0, j, 1);  // Llena la primera fila con valores no nulos
        }
         // Intentar colocar una nueva pieza en el tablero
         int result = board.colocarPiece(pStick);
        
         // Verificar que el juego detecte que ya no se pueden colocar más piezas
         assertEquals(-1, result);
     }
    @Test
    void verificar_mover_pieceScuare_derecha_test(){

        Board board = new Board();
        PieceScuare pS = new PieceScuare();

        int columnaAleatoria = board.colocarPiece(pS);
        board.colocarPiece(pS);

        assertEquals(1, board.getBoard()[0][columnaAleatoria]);

        board.moverDerecha(pS, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 1]);


    }
    
    @Test
    void verificar_mover_pieceScuare_izquierda_test(){

        Board board = new Board();
        PieceScuare pS = new PieceScuare();

        int columnaAleatoria = board.colocarPiece(pS);
        board.colocarPiece(pS);

        assertEquals(1, board.getBoard()[0][columnaAleatoria]);

        board.moverIzquierda(pS, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 1]);

    }
    @Test
    void verificar_mover_pieceDog_derecha_test(){

        Board board = new Board();
        PieceDog pD = new PieceDog();

        int columnaAleatoria = board.colocarPiece(pD);
        board.colocarPiece(pD);

        assertEquals(1, board.getBoard()[0][columnaAleatoria]);

        board.moverDerecha(pD, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 1]);


    }
    
    @Test
    void verificar_mover_pieceDog_izquierda_test(){

        Board board = new Board();
        PieceScuare pD = new PieceScuare();

        int columnaAleatoria = board.colocarPiece(pD);
        board.colocarPiece(pD);

        assertEquals(1, board.getBoard()[0][columnaAleatoria]);

        board.moverIzquierda(pD, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 1]);

    }
    @Test
    void verificar_mover_pieceT_derecha_test(){

        Board board = new Board();
        PieceT pT = new PieceT();

        int columnaAleatoria = board.colocarPiece(pT);
        board.colocarPiece(pT);

        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);

        board.moverDerecha(pT, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 1]);


    }
    
    @Test
    void verificar_mover_pieceT_izquierda_test(){

        Board board = new Board();
        PieceT pT = new PieceT();

        int columnaAleatoria = board.colocarPiece(pT);
        board.colocarPiece(pT);

        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);

        board.moverIzquierda(pT, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 1]);

    }
    @Test
    void verificar_mover_pieceL_derecha_test(){

        Board board = new Board();
        PieceL pL = new PieceL();

        int columnaAleatoria = board.colocarPiece(pL);
        board.colocarPiece(pL);

        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);

        board.moverDerecha(pL, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 1]);


    }
    
    @Test
    void verificar_mover_pieceL_izquierda_test(){

        Board board = new Board();
        PieceL pL = new PieceL();

        int columnaAleatoria = board.colocarPiece(pL);
        board.colocarPiece(pL);

        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);

        board.moverIzquierda(pL, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 2]);

    }
    @Test
    void verificar_mover_pieceStick_derecha_test(){

        Board board = new Board();
        PieceStick pStick = new PieceStick();

        int columnaAleatoria = board.colocarPiece(pStick);
        board.colocarPiece(pStick);

        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);

        board.moverDerecha(pStick, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 1]);


    }
    
    @Test
    void verificar_mover_pieceStick_izquierda_test(){

        Board board = new Board();
        PieceStick pStick = new PieceStick();

        int columnaAleatoria = board.colocarPiece(pStick);
        board.colocarPiece(pStick);

        assertEquals(1, board.getBoard()[0][columnaAleatoria + 1]);

        board.moverIzquierda(pStick, 0, columnaAleatoria);

        assertEquals(0, board.getBoard()[0][columnaAleatoria - 1]);

    }

    @Test
    public void corroborar_que_se_elimina_fila_llena_test() {

        Board board = new Board();
        PieceStick pStick = new PieceStick();
    
        pStick.rotarDerecha();
        board.colocarPiece(pStick);
        
        for (int i = 0; i < 10; i++) {
            board.moverDerecha(pStick, 0, i);
        }
    ///
        PieceStick pStick1 = new PieceStick();

        pStick1.rotarDerecha();
        board.colocarPiece(pStick1);
        
        for (int i = 0; i < 10; i++) {
            board.moverDerecha(pStick1, 0, i);
        }
    
        PieceStick pStick2 = new PieceStick();
        pStick2.rotarDerecha();
        board.colocarPiece(pStick2);
        
        for (int i = 0; i < 10; i++) {
            board.moverDerecha(pStick2, 0, i);
        }

        ///
        PieceStick pStick3 = new PieceStick();
        pStick3.rotarDerecha();
        board.colocarPiece(pStick3);
        
        for (int i = 0; i < 10; i++) {
            board.moverDerecha(pStick3, 0, i);
        }

        ///
        
        PieceStick pStick4 = new PieceStick();
        pStick4.rotarDerecha();
        board.colocarPiece(pStick4);
        
        for (int i = 0; i < 10; i++) {
            board.moverDerecha(pStick4, 0, i);
        }

        // Ahora eliminamos las filas que están llenas
        board.eliminarFila(1);

        // Verificamos que las dos primeras filas ahora estén vacías
        for (int i = 0; i < 20; i++) {
            assertEquals(0, board.getBoard()[1][i]);
        }
    }

    @Test
    public void corroborarFinDelJuegoDespuesDeVariasPiezasTest() {
        Board board = new Board();

        // Colocar varias piezas en el tablero sin llenar la primera fila aún
        PieceStick pStick1 = new PieceStick();

        pStick1.rotarDerecha();
        board.colocarPiece(pStick1);

        for (int i = 0; i < 10; i++) {
            board.moverDerecha(pStick1, 0, i);
        }

        // Colocar más piezas que llenen más filas
        PieceStick pStick2 = new PieceStick();

        pStick2.rotarDerecha();
        board.colocarPiece(pStick2);

        for (int i = 0; i < 10; i++) {
            board.moverDerecha(pStick2, 1, i);
        }

        PieceStick pStick3 = new PieceStick();

        pStick3.rotarDerecha();
        board.colocarPiece(pStick3);

        for (int i = 0; i < 10; i++) {
            board.moverDerecha(pStick3, 2, i);
        }

        // Llenar la primera fila

        PieceStick pStick4 = new PieceStick();

        pStick4.rotarDerecha();
        board.colocarPiece(pStick4);

        for (int i = 0; i < 10; i++) {
            board.moverDerecha(pStick4, 0, i);
        }

        // Verificar si el juego ha terminado, debido a que no se pueden ingresar mas piezas
        //Porque ya no hay lugar en la primera fila
        assertTrue(board.esFinDelJuego());
    }

    
        @Test
        public void corroborarNoGanarJuegoConMenosDe5FilasLlenasTest() {
            Board board = new Board();
    
            // Colocar piezas para llenar 4 filas
            for (int fila = 0; fila < 4; fila++) {
                PieceStick pStick = new PieceStick();
                pStick.rotarDerecha();
                board.colocarPiece(pStick);
                for (int i = 0; i < 20; i++) {  // Asegúrate de cubrir toda la fila
                    board.moverDerecha(pStick, fila, i);
                }
            }
    
            // Verificar que no se ha ganado el juego con menos de 5 filas llenas
            assertFalse(board.ganarJuego());
        }
    
    @Test
    public void testGanarJuegoCuandoSeLlenan5Filas() {
        Board board = new Board(); 

        // Llenamos las primeras 5 filas completamente
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                board.setBoard(i, j, 1); 
            }
        }

        // Verificamos si el juego se ha ganado
        assertTrue(board.ganarJuego());
    }
    
}
    




   