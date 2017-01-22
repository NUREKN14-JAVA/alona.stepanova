package nure.ua.alyona.stepanova.main.java.web;


import nure.ua.alyona.stepanova.main.java.User;
import nure.ua.alyona.stepanova.main.java.db.DaoFactory;
import nure.ua.alyona.stepanova.main.java.db.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet  extends EditServlet {

    protected void processUser(User user) throws DatabaseException {
        DaoFactory.getInstance().getUserDao().create(user);
    }

    protected void showPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }
}