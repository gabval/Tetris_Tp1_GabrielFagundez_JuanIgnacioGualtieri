package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


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
    void voidPieceT_Test(){

       PieceT ps = new PieceT();
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

        for (int[] fila : tabla) {
            assertEquals(20, fila.length);
        }
    }

    @Test
    void descender_pieceScuare_con_clock_test(){

        Board board = new Board();
        PieceScuare pS = new PieceScuare();

        board.colocarPiece(pS,0,0);
        assertEquals (1,board.getBoard()[0][0]);

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

        board.colocarPiece(pT,0,0);

        assertEquals (1,board.getBoard()[0][1]);

        reloj1.tic();
        reloj1.tic();
        assert reloj1.getTic() == 2;

        board.descenderPiece(pT,0,0);
        assertEquals (0,board.getBoard()[0][1]);

    }
    @Test
    void descender_pieceDog_con_clock_test(){

        Board board = new Board();
        PieceDog pD = new PieceDog();
        PieceDog pD2 = new PieceDog();
        Reloj reloj1 = new Reloj();

        pD.elegirLadoRandom(pD); 
        assert pD.getPiece() != pD2.getPiece();

        board.colocarPiece(pD,0,0);

        assertEquals (1,board.getBoard()[0][1]);

        reloj1.tic();
        reloj1.tic();
        assert reloj1.getTic() == 2;

        board.descenderPiece(pD,0,0);
        assertEquals (0,board.getBoard()[0][1]);

    }

    @Test
    void descender_pieceL_con_clock_test(){

        Board board = new Board();
        PieceL pL = new PieceL();
        PieceL pL2 = new PieceL();

        Reloj reloj1 = new Reloj();

        pL.elegirLadoRandom(pL); 
        assert pL.getPiece() != pL2.getPiece();

        board.colocarPiece(pL,0,0);

        assertEquals (1,board.getBoard()[0][1]);

        reloj1.tic();
        reloj1.tic();
        assert reloj1.getTic() == 2;

        board.descenderPiece(pL,0,0);
        assertEquals (0,board.getBoard()[0][1]);

    }
    @Test
    void descender_pieceStick_con_clock_test(){

        Board board = new Board();
        PieceStick pStick = new PieceStick();
        PieceStick pStick2 = new PieceStick();
        

        Reloj reloj1 = new Reloj();

        pStick.elegirLadoRandom(pStick); 
        assert pStick.getPiece() != pStick2.getPiece();
       
        board.colocarPiece(pStick,0,0);

        assertEquals (1,board.getBoard()[0][1]);

        reloj1.tic();
        reloj1.tic();
        
        assert reloj1.getTic() == 2;

        board.descenderPiece(pStick,0,0);
        assertEquals (0,board.getBoard()[0][1]);

    }
    
}
   