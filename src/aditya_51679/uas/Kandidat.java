//NAMA : Aditya Fadhil Herindro
//NIM  : 00000051679

package aditya_51679.uas;
import java.util.ArrayList;

public class Kandidat extends User{
	
	private String nama;
	private String email;
	private String pass;
	private String edukasi;
	public boolean loginStatus = false;
	private ArrayList<Pekerjaan> dataKerja = new ArrayList<Pekerjaan>();
	//private ArrayList<String> status = new ArrayList<String>();
	
	public Kandidat() {}
	
	public Kandidat(String nama, String email, String pass) {
		this.nama = nama;
		this.email = email;
		this.pass = pass;
	}
	
	public void setLoginFalse() {
		loginStatus = false;
	}
	
	public String getEdukasi() {
		return edukasi;
	}
	
	public String getNama() {
		return nama;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPass() {
		return pass;	
	}
	
	public boolean getLogin() {
		return loginStatus;
	}
	
	public void setKerja(Pekerjaan kerja) {
		dataKerja.add(kerja);
	}
	
	public ArrayList<Pekerjaan> getKerja(){
		return dataKerja;
	}

	@Override
	public void checkLogin(String email, String pass) throws ExceptionLoginCheck {
		if(!this.email.equals(email) || !this.pass.equals(pass))
			throw new ExceptionLoginCheck();
		else
			loginStatus = true;	
	}

}
