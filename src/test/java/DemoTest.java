import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {

    // POSITIVE TEST CASES
    @Test
    public void test_Is_Triangle_RightAngle_1(){
        assertTrue(Demo.isTriangle(6,8,10));
    }

    @Test
    public void test_Is_Triangle_RightAngle_2(){
        assertTrue(Demo.isTriangle(8,10,6));
    }

    @Test
    public void test_Is_Triangle_RightAngle_3(){
        assertTrue(Demo.isTriangle(10,6,8));
    }

    @Test
    public void test_Is_Triangle_RightAngle_4(){
        assertTrue(Demo.isTriangle(8,6,10));
    }

    @Test
    public void test_Is_Triangle_RightAngle_5(){
        assertTrue(Demo.isTriangle(6,10,8));
    }

    @Test
    public void test_Is_Triangle_RightAngle_6(){
        assertTrue(Demo.isTriangle(10,8,6));
    }

    // NEGATIVE TEST CASES
    @Test
    public void test_Is_NOT_Triangle_1_7(){
        assertFalse(Demo.isTriangle(1,2,3));
    }

    @Test
    public void test_Is_NOT_Triangle_2_8(){
        assertFalse(Demo.isTriangle(2,3,1));
    }

    @Test
    public void test_Is_NOT_Triangle_3_9(){
        assertFalse(Demo.isTriangle(3,1,2));
    }

    @Test
    public void test_Is_NOT_Triangle_4_10(){
        assertFalse(Demo.isTriangle(2,1,3));
    }

    @Test
    public void test_Is_NOT_Triangle_5_11(){
        assertFalse(Demo.isTriangle(1,3,2));
    }

    @Test
    public void test_Is_NOT_Triangle_6_12(){
        assertFalse(Demo.isTriangle(3,2,1));
    }

    @Test
    public void test_Is_NOT_Triangle_CheckZero_7_13(){
        assertFalse(Demo.isTriangle(0,1,2));
    }

    @Test
    public void test_Is_NOT_Triangle_Negative_8_14(){
        assertFalse(Demo.isTriangle(6,-8,10));
    }

    //Is Triangle Negative
    @Test
    public void test_main_Is_NOT_Triangle_Negative_9_15(){
        ByteArrayOutputStream out = callMain(1, 2, 3);
        String consoleOutput = "Enter side 1: \r\n";
        consoleOutput += "Enter side 2: \r\n";
        consoleOutput += "Enter side 3: \r\n";
        consoleOutput += "This is not a triangle.\r\n";

        //String[] args = {"1","2","3"};

        //or
        //Demo.main(List.of());


        assertEquals(consoleOutput, out.toString());

    }

    //Is Triangle Positive
    @Test
    public void test_main_Is_Triangle_16(){
        ByteArrayOutputStream out = callMain(6, 8, 10);
        String consoleOutput = "Enter side 1: \r\n";
        consoleOutput += "Enter side 2: \r\n";
        consoleOutput += "Enter side 3: \r\n";
        consoleOutput += "This is a triangle.\r\n";

        //String[] args = {"6","8","10"};
        //Demo.main(args);

        assertEquals(consoleOutput, out.toString());

    }

    private static ByteArrayOutputStream callMain(int a, int b, int c) {
        ByteArrayInputStream in = new ByteArrayInputStream((a + "\r\n" + b + "\r\n" + c + "\r\n").getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Demo.main(new String[]{});
        return out;
    }
}
