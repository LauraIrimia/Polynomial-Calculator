import model.Operatie;
import model.Polynomial;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InmultireTest {
    @Test
    public void InmlTest(){
        String input1="x^2+x";
        String input2="x^2+1";
        Polynomial polinom1=Polynomial.transformarePolinom(input1);
        Polynomial polinom2=Polynomial.transformarePolinom(input2);
        String rezultat="x^4+x^3+x^2+x";
        assertTrue(Operatie.inmultire(polinom1, polinom2).toString().equals(rezultat));
    }
}