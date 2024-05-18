package dam.mp06.uf04.p01.dao.model.domain;

public class Ticket {
	
	private long id;
	private String title;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + "]";
	}
	
	

}
