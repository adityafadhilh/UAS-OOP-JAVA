//NAMA : Aditya Fadhil Herindro
//NIM  : 00000051679

package aditya_51679.uas;

public abstract class User {

	public abstract String getEmail();
	
	public abstract String getPass();
	
	public abstract void checkLogin(String email, String pass) throws ExceptionLoginCheck;
}
