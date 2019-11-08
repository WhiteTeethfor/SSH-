package com.wang.ssh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;


public class ConnectionTest {
      private ApplicationContext applicationContext;
    {
        applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    }

   @Test
    public void testConnnection() throws SQLException {
       DataSource dataSource=(DataSource) applicationContext.getBean("dataSource");
       System.out.println(dataSource.getConnection());
   }
}
