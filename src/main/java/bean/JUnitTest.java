package bean;

import org.junit.Test;

public class JUnitTest {
    int num = 10;

    @Test
    public void testEquals() {
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));
        show();
    }

    public void show() {
        num = 20;
        System.out.println("show()...");
    }

    @Test
    public void testToString() {
        String s2 = "MM";
        System.out.println(s2.toString());
    }
}
