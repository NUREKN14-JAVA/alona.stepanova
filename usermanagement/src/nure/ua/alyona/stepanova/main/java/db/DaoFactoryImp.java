package nure.ua.alyona.stepanova.main.java.db;

public class DaoFactoryImp extends DaoFactory {
    public UserDao getUserDao(){
        UserDao result = null;
        try {
            Class clasz = Class.forName(properties.getProperty(USER_DAO));
            result = (UserDao) clasz.newInstance();
            result.setConnectionFactory(getConnectionFactory());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
