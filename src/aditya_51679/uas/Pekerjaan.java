//NAMA : Aditya Fadhil Herindro
//NIM  : 00000051679

package aditya_51679.uas;

public class Pekerjaan {

	Kandidat kandidat;
	private String title, type, category;
	private int salary;
	private String status;
	
	public Pekerjaan() {}
	
	public Pekerjaan(String title, String type, String category, int salary) {
		this.title = title;
		this.type = type;
		this.category = category;
		this.salary = salary;
	}
	
	public void setKandidat(Kandidat kandidat) {
		this.kandidat = kandidat;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Kandidat getKandidat() {
		return kandidat;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getType() {
		return type;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getSalary() {
		return salary;
	}
	
	
	
}
