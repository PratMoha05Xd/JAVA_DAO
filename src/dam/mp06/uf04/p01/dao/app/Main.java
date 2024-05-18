package dam.mp06.uf04.p01.dao.app;

import java.sql.SQLException;

import dam.mp06.uf04.p01.dao.controller.TicketLogController;

public class Main {

	public static void main(String[] args) throws SQLException {

		ticketLogManager();
	}
	
	private static void ticketLogManager() {
		TicketLogController ticketLogController = new TicketLogController();
		ticketLogController.add();
		ticketLogController.add();
		ticketLogController.upd();
		ticketLogController.getOne();
		ticketLogController.getAll();
		ticketLogController.delete();
	}

}
