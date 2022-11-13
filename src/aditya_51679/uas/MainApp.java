//NAMA : Aditya Fadhil Herindro
//NIM  : 00000051679

package aditya_51679.uas;

import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {
	static Admin dataAdmin = new Admin("admin", "admin@admin.com", "admin");
	static ArrayList<Kandidat> dataKandidat = new ArrayList<Kandidat>();
	static ArrayList<Pekerjaan> dataKerja = new ArrayList<Pekerjaan>();
	
	public static void checkException(int n) throws ExceptionInput {
		if(n <= 0) {
			throw new ExceptionInput();
		}
	}
	
	public static void initData() {
		dataKandidat.add(new Kandidat("afri", "afri@gmail.com", "afri"));
		dataKandidat.add(new Kandidat("chill", "chill@gmail.com", "chill"));
		dataKandidat.add(new Kandidat("loysing", "loysing", "loysing"));
		
		dataKerja.add(new Pekerjaan("UI / UX Designer", "Intership", "Designer", 2400000));
		dataKerja.add(new Pekerjaan("Customer Support", "Full Time", "Customer Service", 4000000));
		dataKerja.add(new Pekerjaan("Business Analyst", "Part Time", "Finance", 5000000));
		dataKerja.add(new Pekerjaan("Content Marketing", "Part Time", "Digital Marketing", 6500000));
	}
	
	public static void adminPage() {
		Scanner scan = new Scanner(System.in);
		Scanner obj = new Scanner(System.in);
		int pilih;
		for(;;) {
			System.out.println("=== Welcome Admin ===");
			System.out.println("1. Submissions");
			System.out.println("2. Send Email");
			System.out.println("3. Logout");
			System.out.println("Pilihan : ");
			
			pilih = scan.nextInt();
			
			try {
				checkException(pilih);
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
			if(pilih == 1) {
				int num = 1;
				System.out.println("Menu Submission");
				for(Kandidat data : dataKandidat) {
					System.out.println(num +". "+data.getNama());
					for(Pekerjaan kerja : data.getKerja()) {
						System.out.println("   "+kerja.getTitle());
					}
					num++;
				}
				num++;
				
				System.out.print("\n");
				
			}else if(pilih == 2) {
				int num = 1;
				Kandidat dataK = null;
				System.out.print("\n");
				System.out.println("Menu Send Email\n");
				System.out.print("To : ");
				String nama = obj.nextLine();
				System.out.println("Daftar pekerjaan yang di apply:");
				for(Kandidat data : dataKandidat) {
					if(data.getNama().equals(nama)) {
						dataK = data;
						break;
					}
				}
				for(Pekerjaan data1 : dataK.getKerja()) {
					System.out.println("Job Id : "+ num +". "+dataK.getNama()+" - "+data1.getTitle()+" ");
					num++;
				}
				if(dataK.getKerja() == null) {
					break;
				}else {
					System.out.print("\n");
					System.out.print("Choose Job Id : ");
					int id = scan.nextInt();
					
					System.out.println("Add Details");
					System.out.println("1. Lolos");
					System.out.println("2. Tidak Lolos");
					System.out.print("\n");
					System.out.print("Pilihan : ");
					int pilihDetail = scan.nextInt();
					
					if(pilihDetail == 1) {
						dataK.getKerja().get(id-1).setStatus("Lolos");
					}else if(pilihDetail == 2) {
						dataK.getKerja().get(id-1).setStatus("Tidak Lolos");
					}
					System.out.println("Email Sent !!");
				}
				
			}else if(pilih == 3) {
				System.out.println("Log out success");
				System.out.println("Return to Main Menu \n");
				dataAdmin.setLoginFalse();
				break;
			}
		}
	}
	
	public static void kandidatPage(Kandidat data) {
		Scanner scan = new Scanner(System.in);
		int pilih, count = 1, posisiKerja;
		for(;;) {
			System.out.println("=== Menu Kandidat === ");
			System.out.println("Welcome " + data.getNama());
			System.out.print("\n");
			System.out.println("1. Search Job");
			System.out.println("2. Apply Now");
			System.out.println("3. Submission");
			System.out.println("4. Log Out");
			System.out.print("Pilih : ");
			
			pilih = scan.nextInt();
			
			try {
				checkException(pilih);
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
			if(pilih == 1) {
				System.out.println("=== Jobs ===");
				for(Pekerjaan dataKe : dataKerja) {
					System.out.println("Id                : "+count);
					System.out.println("Job Title         : "+dataKe.getTitle());
					System.out.println("Job Type          : "+dataKe.getType());
					System.out.println("Job Category      : "+dataKe.getCategory());
					System.out.println("Qualification     : "+dataKe.getSalary());
					System.out.println("----------------------------------------------------");	
					count++;
				}
				
			}else if(pilih == 2) {
				System.out.println("=== Apply Job ===");
				System.out.println("Name      : "+data.getNama());
				System.out.println("Edukasi   : "+data.getEdukasi());
				System.out.println("Position to apply (1-4)");
				posisiKerja = scan.nextInt();
				data.setKerja(dataKerja.get(posisiKerja-1));
				data.getKerja().get(data.getKerja().size()-1).setStatus("Waiting for respond from HRD");
				System.out.println("Submission status : "+data.getKerja().get(data.getKerja().size()-1).getStatus());
			}else if(pilih == 3) {
				int num = 1;
				System.out.println("=== Submission ===");
				if(data.getKerja() == null) {
					System.out.println("There is no submission yet");
				}else {
					for(Pekerjaan i : data.getKerja()) {
						System.out.println(num + ". You applied for "+ i.getTitle());
						if(i.getStatus().equals("Lolos"))
							System.out.println("Details : Congratulation! You being advanced to step 2 : Interview process.");
						else if(i.getStatus().equals("Tidak Lolos"))
							System.out.println("Details : Unfortunately, based on the result we will not be advancing your application to the next step.");
						else
							System.out.println("Details : "+i.getStatus());
						num++;
					}
					System.out.print("\n");
				}
			}else if(pilih == 4) {
				System.out.println("Log out success");
				System.out.println("Return to Main Menu \n");
				data.setLoginFalse();
				break;
			}
		}
		
		
	}
	
	public static void loginPage() {
		Scanner scan = new Scanner(System.in);
		String email, pass;
		Kandidat data = null;
		System.out.println("=== Login ===");
		System.out.print("Email      : ");
		email = scan.nextLine();
		System.out.print("Password   : ");
		pass = scan.nextLine();
		if(email.contains("admin"))
			try {
				dataAdmin.checkLogin(email, pass);
			}catch(ExceptionLoginCheck e) {
				System.out.println(e.getMessage());
			}
			if(dataAdmin.getLogin()) {
				adminPage();
			}
		else
			for(Kandidat dataK : dataKandidat) {
				if(dataK.getEmail().equals(email)) {
					data = dataK;
					break;
				}
			}
			try {
				data.checkLogin(email, pass);
			} catch (ExceptionLoginCheck e) {
				System.out.println(e.getMessage());
			}
			if(data.getLogin()) {
				kandidatPage(data);
			}
			
	}
	
	public static void signupPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n=== SIGN UP ===");
		System.out.print("Name        : ");
		String nama = scan.nextLine();
		System.out.print("Email       : ");
		String email = scan.nextLine();
		System.out.print("Password    : ");
		String pass = scan.nextLine();
		
		dataKandidat.add(new Kandidat(nama, email, pass));
	}

	public static void main(String[] args) {
		initData();
		Scanner scan = new Scanner(System.in);
		int pilih;
		for(;;) {
			System.out.println("Welcome to Linkon");
			System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.println("3. Exit");
			System.out.print("Pilihan : ");
			pilih = scan.nextInt();
			
			if(pilih == 1) {
				try {
					loginPage();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}else if(pilih == 2) {
				signupPage();
			}else if(pilih == 3)
				break;
			
		}

	}

}
