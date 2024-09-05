package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

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

        pd1.rotarDerecha(pd1);

        assert pd1.getPiece() != pd2.getPiece();
        
    }
    @Test
    void Rotar_Izquieda_PieceDog_test(){

        PieceDog pd1 = new PieceDog();
        PieceDog pd2 = new PieceDog();

        pd1.rotarIzquierda(pd1);

        assert pd1.getPiece() != pd2.getPiece();
        
    }
}
   