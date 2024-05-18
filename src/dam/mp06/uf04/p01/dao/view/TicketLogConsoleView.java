package dam.mp06.uf04.p01.dao.view;

import dam.mp06.uf04.p01.dao.model.domain.TicketLog;

public class TicketLogConsoleView {

    CommonConsoleView commonConsoleView;

    public TicketLogConsoleView() {
        commonConsoleView = new CommonConsoleView();
    }

    public TicketLog getTicketLog() {
        TicketLog t = new TicketLog();
        t.setId(this.getId());
        t.setTitle(commonConsoleView.getPhrase("Title: "));
        t.setApplicationName(commonConsoleView.getWord("Application: "));

        return t;
    }

    public int getId() {
        return commonConsoleView.getInt("Id: ");
    }
}
