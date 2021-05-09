package pl.coderslab.spring01hibernatekrkw07.ut.zad2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FactorsTest {

    @Test
    public void shouldReturnPrimeFactors() {
        // given
        final int input = 12;
        // when
        List<Integer> factors = Factors.generatePrimeFactors(input);
        // then
        assertEquals(6, factors.size());
        for(int factor : factors){
            if(input % factor != 0){
                fail(String.format("%s is not prime factor of %s", factor, input));
            }
        }
    }
}