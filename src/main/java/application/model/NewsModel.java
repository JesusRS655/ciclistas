package application.model;

public class NewsModel {

	private int id;
	private String headline;

	public NewsModel() {
		super();
	}

	public NewsModel(int id, String headline) {
		super();
		this.id = id;
		this.headline = headline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

}
