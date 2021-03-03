package org.geektimes.projects.user.web.listener;

import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class DBConnectionInitializerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        InitialContext ic = null;
//        try {
//            ic = new InitialContext();
//            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/UserPlatformDB");
//
//            Connection con = ds.getConnection();
//            DBConnectionManager dbConnectionManager = new DBConnectionManager();
//            dbConnectionManager.setConnection(con);
//            DatabaseUserRepository databaseUserRepository = new DatabaseUserRepository(dbConnectionManager);
//            sce.getServletContext().setAttribute("dbRepo",databaseUserRepository);
//        } catch (NamingException | SQLException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
