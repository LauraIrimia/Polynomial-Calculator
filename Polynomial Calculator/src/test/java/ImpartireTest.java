import model.Operatie;
import model.Polynomial;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ImpartireTest {
    @Test
    public void ImprTest(){
        String input1="x^2+x";
        String input2="x^2";
        Polynomial polinom1=Polynomial.transformarePolinom(input1);
        Polynomial polinom2=Polynomial.transformarePolinom(input2);
        Polynomial c=new Polynomial();
        Polynomial r=new Polynomial();
        String cat="1";
        String rest="x";
        Operatie.impartire(polinom1, polinom2,c,r);
        assertTrue(c.toString().equals(cat));
        assertTrue(r.toString().equals(rest));
    }
}