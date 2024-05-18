package dam.mp06.uf04.p01.dao.controller;

import java.sql.SQLException;
import java.util.List;

import dam.mp06.uf04.p01.dao.model.domain.TicketLog;
import dam.mp06.uf04.p01.dao.model.service.TicketLogService;
import dam.mp06.uf04.p01.dao.view.CommonConsoleView;
import dam.mp06.uf04.p01.dao.view.TicketLogConsoleView;

public class TicketLogController {

    CommonConsoleView commonConsoleView;
    TicketLogConsoleView ticketLogConsoleView;
    TicketLogService ticketLogService;

    public TicketLogController() {
        commonConsoleView = new CommonConsoleView();
        ticketLogConsoleView = new TicketLogConsoleView();
        ticketLogService = new TicketLogService();
    }

    public void add() {
        try {
            commonConsoleView.showMessage("ALTA ----------");
            TicketLog t = ticketLogConsoleView.getTicketLog();
            int affectedRows = ticketLogService.insert(t);
            commonConsoleView.showMessage("Filas afectadas: " + affectedRows);
        } catch (SQLException e) {
            commonConsoleView.showMessage(e.getMessage(), true);
        }
    }

    public void upd() {
        try {
            commonConsoleView.showMessage("CAMBIO ----------");
            TicketLog t = ticketLogConsoleView.getTicketLog();
            int affectedRows = ticketLogService.update(t);
            commonConsoleView.showMessage("Filas afectadas: " + affectedRows);
        } catch (SQLException e) {
            commonConsoleView.showMessage(e.getMessage(), true);
        }
    }

    public void delete() {
        try {
            commonConsoleView.showMessage("BAJA ----------");
            int id = ticketLogConsoleView.getId();
            int affectedRows = ticketLogService.delete(id);
            commonConsoleView.showMessage("Filas afectadas: " + affectedRows);
        } catch (SQLException e) {
            commonConsoleView.showMessage(e.getMessage(), true);
        }
    }

    public void getOne() {
        try {
            commonConsoleView.showMessage("GET ONE ----------");
            int id = ticketLogConsoleView.getId();
            TicketLog t = ticketLogService.getOne(id);
            commonConsoleView.showMessage(t.toString());
        } catch (SQLException e) {
            commonConsoleView.showMessage(e.getMessage(), true);
        }
    }

    public void getAll() {
        try {
            commonConsoleView.showMessage("GET ALL ----------");
            List<TicketLog> l = ticketLogService.getAll();
            commonConsoleView.showMessage(l.toString());
        } catch (SQLException e) {
            commonConsoleView.showMessage(e.getMessage(), true);
        }
    }
}
