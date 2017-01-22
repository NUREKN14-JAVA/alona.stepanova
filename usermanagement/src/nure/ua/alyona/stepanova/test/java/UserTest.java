package nure.ua.alyona.stepanova.test.java;

import nure.ua.alyona.stepanova.main.java.User;
import org.junit.Test;

import java.security.PrivateKey;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class UserTest extends junit.framework.TestCase {

    private User user;
    private Date dateOfBirth;

    @org.junit.Before
    @Test
    public void setUp() throws Exception {
        super.setUp();
        user = new User();
        dateOfBirth=new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, Calendar.JULY, 12);
        dateOfBirth= calendar.getTime();

    }
    @Test
    public void testGetFullName(){
        user.setFirstName("Name1");
        user.setLastName("LastName1");
        assertEquals("LastName1,Name1",user.getFullName());
    }
    @Test
    public void testGetAge(){
        user.setDateOfBirth(dateOfBirth);
        assertEquals(2016-1997,user.getAge());
    }

}