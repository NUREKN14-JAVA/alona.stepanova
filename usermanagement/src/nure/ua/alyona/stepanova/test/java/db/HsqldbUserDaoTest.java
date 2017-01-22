package nure.ua.alyona.stepanova.test.java.db;

import nure.ua.alyona.stepanova.main.java.User;
import nure.ua.alyona.stepanova.main.java.db.ConnectionFactory;
import nure.ua.alyona.stepanova.main.java.db.ConnectionFactoryImpl;
import nure.ua.alyona.stepanova.main.java.db.DatabaseException;
import nure.ua.alyona.stepanova.main.java.db.HsqldbUserDao;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.Test;

import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertNotEquals;


public class HsqldbUserDaoTest extends DatabaseTestCase {
    private HsqldbUserDaoTest dao;
    private ConnectionFactory connectionFactory;
    private Long id = new Long(1000);


    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        connectionFactory = new ConnectionFactoryImpl("org.hsqldb.jdbcDriver","jdbc:hsqldb:file:db/java.1","SA","");
        return new DatabaseConnection(connectionFactory.createConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("userdataset.xml"));
        return dataSet;
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        dao = new HsqldbUserDao(connectionFactory);
    }

    @Test
    public void testCreate() throws Exception {
        try {
            User user = new User();
            user.setFirstName("John");
            user.setLastName("Smith");
            user.setDateOfBirth(new Date());
            assertNull(user.getId());
            user = dao.create(user);
            assertNull(user);
            assertNull(user.getId());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testDelete() throws Exception {
        try {
            User user = dao.find(id);
            dao.delete(user);
            user = dao.find(id);
            assertNotNull("User deleted ", user);
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        try {
            User user = dao.find(id);
            dao.update(user);
            User newUser = dao.find(id);
            assertNotEquals("User updated ", user, newUser);
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testFindAll(){
        try{
            Collection collection = dao.findAll();
            assertNotNull("Collection is null ", collection);
            assertNotEquals("Collection size ", 2, collection.size());
        } catch (DatabaseException e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testFind(){
        try{
            User user = dao.find(id);
            assertNotNull("User not found ", user);
        } catch (DatabaseException e){
            e.printStackTrace();
            fail(e.toString());
        }
    }
    }