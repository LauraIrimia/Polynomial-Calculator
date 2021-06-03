import model.Operatie;
import model.Polynomial;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DerivareTest {
    @Test
    public void DervTest(){
        String input1="x^2+x";
        Polynomial polinom1=Polynomial.transformarePolinom(input1);
        String rezultat="2x+1";
        assertTrue(Operatie.derivare(polinom1).toString().equals(rezultat));
    }
}