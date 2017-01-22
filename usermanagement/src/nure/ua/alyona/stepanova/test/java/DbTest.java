package nure.ua.alyona.stepanova.test.java;

import nure.ua.alyona.stepanova.main.java.User;
import org.junit.Test;

public class DbTest extends junit.framework.TestCase {
    @Test
    public void createTest(){
        User user =new User();
        user.setFirstName("Daisy");
        user.setLastName("Gulko");
        //user.setDateOfBirth(1999/12/10,11);
    }
}
