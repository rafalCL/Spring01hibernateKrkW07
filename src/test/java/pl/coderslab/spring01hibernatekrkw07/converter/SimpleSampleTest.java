package pl.coderslab.spring01hibernatekrkw07.converter;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class SimpleSampleTest {
    @Test
    public void checkPi(){
        System.out.println("Test checkPi");
        assertEquals(3.142, Math.PI, .001);
    }

    @Test
    public void checkString(){
        System.out.println("Test checkString");
        // given
        String input = "ala ma kota";
        // when
        String[] actual = input.split(" ");
        // then
        assertEquals(3, actual.length);
        assertEquals("ala", actual[0]);
        assertEquals("ma", actual[1]);
        assertEquals("kota", actual[2]);
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Executed before all tests in this class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Executed after all tests in this class");
    }

    @Before
    public void beforeEach(){
        System.out.println("Executed before each test");
    }

    @After
    public void afterEach(){
        System.out.println("Executed after each test");
    }
}
