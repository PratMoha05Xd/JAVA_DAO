package dam.mp06.uf04.p01.dao.model.service;

import java.sql.SQLException;
import java.util.List;

import dam.mp06.uf04.p01.dao.model.domain.TicketLog;
import dam.mp06.uf04.p01.dao.model.repository.TicketLogRepositoryDAO;

public class TicketLogService {

	private TicketLogRepositoryDAO rep;
	
	public TicketLogService() {
		rep = new TicketLogRepositoryDAO();
	}


    public int insert(TicketLog t) throws SQLException {
        checkData(t);
        return rep.insert(t);
    }

    public int update(TicketLog t) throws SQLException {
        checkData(t);
        return rep.update(t);
    }

    public int delete(long id) throws SQLException {
        return rep.delete(id);
    }

    public TicketLog getOne(long id) throws SQLException {
        return rep.getOne(id);
    }

    public List<TicketLog> getAll() throws SQLException {
        return rep.getAll();
    }

    private void checkData(TicketLog t) {
        if (t == null) {
            throw new RuntimeException("UserLog Empty!");
        }
        if (t.getTitle() == null || t.getTitle().equals("")) {
            throw new RuntimeException("Title Empty!");
        }
        if (t.getApplicationName() == null || t.getApplicationName().equals("")) {
            throw new RuntimeException("Application Empty!");
        }
    }
}
