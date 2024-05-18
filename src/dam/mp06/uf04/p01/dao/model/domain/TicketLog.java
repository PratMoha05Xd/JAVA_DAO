package dam.mp06.uf04.p01.dao.model.domain;

public class TicketLog extends Ticket {

	private String applicationName;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Override
	public String toString() {
		return "TicketLogs [applicationName=" + applicationName + ", getId()=" + getId() + ", getTitle()=" + getTitle() + "]";
	}

}
