package dam.mp06.uf04.p01.dao.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseRepositoryDAO<Entity> {

	private final String url = "jdbc:postgresql://localhost:5432/mp06uf04";
	private final String user = "postgres";
	private final String password = "12345";

	public Connection getConnection() throws SQLException {
	    Connection connection = DriverManager.getConnection(url, user, password);
	    if (connection != null) {
	        System.out.println("¡Conexión establecida con éxito!");
	    }
	    return connection;
	}


	public int insert(Entity e) throws SQLException {
		return this.applyChangesDatabase(this.getCommandInsert(e));
	}

	public int update(Entity e) throws SQLException {
		return this.applyChangesDatabase(this.getCommandUpdate(e));
	}

	public int delete(long id) throws SQLException {
		return this.applyChangesDatabase(this.getCommandDelete(id));

	}

	public List<Entity> getAll() throws SQLException {
		List<Entity> result = null;
		Connection conn = null;
		String sql = this.getCommandGetAll();
		try {
			conn = this.getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			result = getListFromResultSet(rs);

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}

		return result;

	}

	public Entity getOne(long id) throws SQLException {
		Entity result = null;
		Connection conn = null;
		String sql = this.getCommandGetOne(id);
		try {
			conn = this.getConnection();
System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Entity> lista = getListFromResultSet(rs);
			if (lista != null && !lista.isEmpty()) {
				result = lista.get(0);
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		} finally {
			if (conn != null)
				conn.close();
		}

		return result;

	}

	private int applyChangesDatabase(String sql) throws SQLException {

		int affectedRows = 0;

		Connection conn = this.getConnection();
		try {
			Statement statement = conn.createStatement();
			affectedRows = statement.executeUpdate(sql);

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return affectedRows;
	}

	public abstract String getCommandInsert(Entity e);

	public abstract String getCommandUpdate(Entity e);

	public abstract String getCommandDelete(long id);

	public abstract String getCommandGetAll();

	public abstract String getCommandGetOne(long id);

	public abstract List<Entity> getListFromResultSet(ResultSet rs) throws SQLException;

}
