//NAMA : Aditya Fadhil Herindro
//NIM  : 00000051679

package aditya_51679.uas;

public class Admin extends User{

	private String nama;
	private String email;
	private String pass;
	private Boolean loginStatus = false;
	
	public Admin() {}
	
	public Admin(String nama, String email, String pass) {
		this.nama = nama;
		this.email = email;
		this.pass = pass;
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
	
	public void setLoginFalse() {
		loginStatus = false;
	}
	
	@Override
	public void checkLogin(String email, String pass) throws ExceptionLoginCheck {
		if(!this.email.equals(email) || !this.pass.equals(pass))
			throw new ExceptionLoginCheck();
		else
			loginStatus = true;
	}
}
