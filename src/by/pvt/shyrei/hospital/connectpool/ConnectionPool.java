package by.pvt.shyrei.hospital.connectpool;

import javax.naming.InitialContext;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Shyrei Uladzimir
 * Connection pool class (use Tomcat)
 */
public class ConnectionPool {

	private static ConnectionPool instance;
	private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

	public Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			InitialContext initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jndi/hospital");
			connection = ds.getConnection();
		} catch (SQLException e ) {
			logger.log(Level.FATAL, "SQLException - can't access to database: " + e.toString());
			throw e;
		} catch (NamingException e) {
			logger.log(Level.FATAL, "Naming Exception: " + e.toString());
		}

		return connection;
	}

	public static ConnectionPool getInstance() {
		if (instance != null) {
			return instance;
		} else {
			return new ConnectionPool();
		}
	}
	
	public synchronized void freeConnection(Connection connection) {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			logger.log(Level.FATAL, "SQLException - can't freeConnection: " + e.toString());
			return;
		}
	}
}
