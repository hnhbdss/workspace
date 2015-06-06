package dss.demo;

import javax.swing.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;

public class MainFrame extends JFrame {
    
    static Log log = LogFactory.getLog(MainFrame.class);
    public static void main(String[] args) {

	log.info("here");
      
	MainFrame frame = new MainFrame();
	frame.setSize(200, 200);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.loadDriver();
    }

    public void loadDriver() {
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    DataSource dataSource =  getDataSource();

	    Connection conn = dataSource.getConnection();

	    Statement state = conn.createStatement();

	    ResultSet resultSet = state.executeQuery("select * from ranne");

	    int numCol = resultSet.getMetaData().getColumnCount();
	    while (resultSet.next()) {
		for (int i = 1; i <= numCol; ++i) {
		    System.out.println("col " + i + " is:" + resultSet.getString(i));
		}
	    }
	    resultSet.close();
	    state.close();
	    conn.close();
	}
	catch(ClassNotFoundException e) {
	    log.error("catch exception", e);
	}
	catch(SQLException e) {
	    log.error("catch exception", e);
	}
    }
    DataSource getDataSource() {

	ConnectionFactory connectionFactory =
	    new DriverManagerConnectionFactory("jdbc:mysql://127.0.0.1:3306/dss", "root", "lili");
	PoolableConnectionFactory poolableConnectionFactory =
	    new PoolableConnectionFactory(connectionFactory, null);
	ObjectPool<PoolableConnection> connectionPool =
	    new GenericObjectPool<>(poolableConnectionFactory);
	poolableConnectionFactory.setPool(connectionPool);

	PoolingDataSource<PoolableConnection> dataSource =
	    new PoolingDataSource<>(connectionPool);
	return dataSource;
    }
}
