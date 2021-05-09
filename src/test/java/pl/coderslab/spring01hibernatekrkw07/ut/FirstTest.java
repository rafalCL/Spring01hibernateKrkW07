package pl.coderslab.spring01hibernatekrkw07.ut;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstTest {
    private First sut = new First();

    @Test
    public void shouldConcatTwoStrings() {
        // given
        final String first = "first";
        final String second = "second";
        // when
        String actual = sut.concatString(first, second);
        // then
        assertEquals(first+second, actual);
    }

    @Test
    public void shouldConcatTwoNulls() {
        // given
        final String first = null;
        final String second = null;
        // when
        String actual = sut.concatString(first, second);
        // then
        assertEquals("nullnull", actual);
    }

    @Test
    public void shouldConcatWithNull() {
        // given
        final String first = "first";
        final String second = null;
        // when
        String actual = sut.concatString(first, second);
        // then
        assertEquals("firstnull", actual);
    }

    @Test
    public void shouldMultiplyTwoPositives() {
        // given
        final int a = 3;
        final int b = 4;
        // when
        final int actual = sut.multiply(a,b);
        // then
        assertEquals(3*4, actual);
    }

    @Test
    public void shouldMultiplyPositiveByNegative() {
        // given
        final int a = 5;
        final int b = -1;
        // when
        final int actual = sut.multiply(a,b);
        // then
        assertEquals(a*b, actual);
    }
}