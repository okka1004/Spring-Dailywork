package dailyWork1;

import java.util.ArrayList;

public class BookEntity {

	private String bisbn;
	private String btitle;
	private String bauthor;
	private String bprice;
	private ArrayList ctext;
	
	
	public BookEntity() {
		super();
	}



	public ArrayList getCtext() {
		return ctext;
	}



	public void setCtext(ArrayList ctext) {
		this.ctext = ctext;
	}



	public BookEntity(String bisbn, String btitle, String bauthor, String bprice, ArrayList ctext) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
		this.ctext = ctext;
	}



	public String getBisbn() {
		return bisbn;
	}
	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBprice() {
		return bprice;
	}
	public void setBprice(String bprice) {
		this.bprice = bprice;
	}
	
}
