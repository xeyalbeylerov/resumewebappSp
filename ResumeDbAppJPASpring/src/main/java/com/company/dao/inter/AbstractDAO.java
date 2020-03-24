/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author xeyal
 */
public abstract class AbstractDAO {

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
//       String url = "jdbc:mysql://localhost:3306/resume?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Baku";
        String url = "jdbc:mysql://localhost:3306/resume?serverTimezone=Asia/Baku";
//        String url = "jdbc:mysql://localhost:3306/resume?zeroDateTimeBehavior=CONVERT_TO_NULL";
//        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    private static EntityManagerFactory emf = null;

    public EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("resumeappPU");
        }
        
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public void emClose(EntityManager em) {
        em.close();
    }

    public void emfClose() {
        emf.close();
    }
}
