package by.pvt.shyrei.hospital.dao;

import by.pvt.shyrei.hospital.connectpool.ConnectionPool;

/**
 * @author Shyrei Uladzimir
 * Abstract DAO class
 */
public abstract class DAO {
	protected static ConnectionPool poolInstance;

	protected DAO() {
		poolInstance = ConnectionPool.getInstance();

	}
}
