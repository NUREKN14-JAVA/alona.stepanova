package nure.ua.alyona.stepanova.test.java.db;
import junit.framework.TestCase;
import nure.ua.alyona.stepanova.main.java.db.DaoFactory;
import nure.ua.alyona.stepanova.main.java.db.UserDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class DaoFactoryTest extends TestCase {
    @Test
    public void testGetUserDao() throws Exception {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            assertNotEquals("DaoFactory instance is null", daoFactory);
            UserDao userDao = daoFactory.getUserDao();
            assertNotEquals("UserDao instance is null", userDao);
        } catch (Exception e) {
            fail(e.toString());
        }
    }

}
