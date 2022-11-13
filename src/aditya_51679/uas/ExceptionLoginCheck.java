//NAMA : Aditya Fadhil Herindro
//NIM  : 00000051679

package aditya_51679.uas;

public class ExceptionLoginCheck extends Exception{

	public ExceptionLoginCheck() {
		super("Email atau password salah!");
	}
	
	public ExceptionLoginCheck(String msg) {
		super(msg);
	}
}
