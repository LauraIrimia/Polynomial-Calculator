import model.Operatie;
import model.Polynomial;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IntegrareTest {
    @Test
    public void IntgTest(){
        String input1="x^2+2";
        Polynomial polinom1=Polynomial.transformarePolinom(input1);
        String rezultat="0.33x^3+2x";
        assertTrue(Operatie.integrare(polinom1).toString().equals(rezultat));
    }
}