package com.cg.mra.UI;



import java.util.Scanner;
import com.cg.mra.beans.product;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

class UserException extends Exception{
	
	
	public UserException() throws UserException {
		//MainClass mc=new MainClass();
		
		System.err.println("invalid mobile number");
		MainClass mc=new MainClass();
		mc.switchCall();
		}
}

public class MainClass {
		
	
		Scanner scan=new Scanner(System.in);	
	public static void main(String[] args) throws UserException  {
		// TODO Auto-generated method stub
		MainClass mc=new MainClass();
		Scanner scan=new Scanner(System.in);
		System.out.println(" +++++ mobile recharge application ++++++++");
		
		mc.switchCall();	
		}
	void switchCall() throws UserException {
		// TODO Auto-generated method stub
		System.out.println("enter 1 to balance enquiry, 2 for recharge and 3 to exit from window");
		switch(scan.nextInt()) {
		case 1 : case1();	
		case 2 : case2();
		case 3 : exit();
		}
	}
	AccountService accservice=new AccountServiceImpl();
	public void case1() throws UserException {
		
		System.out.println("enter mobile number");
		String mobileNo=scan.next();
		
		product account=accservice.getAccountDetails(mobileNo);
		if(mobileNo.length()==10) {
			
			if(account!=null) 
				System.out.println("account balance is: "+account.getAccountBalance());
			else 
				throw  new  UserException() ;
		}
		else {
			System.out.println("number must be 10 digits");
			case1();
		}
		switchCall();	
	}
	
		public void case2() throws UserException {
			
			
			System.out.println("enter mobile number");
			String mobileNo=scan.next();
			if(mobileNo.length()==10) {
			product account2=accservice.getAccountDetails(mobileNo);
			
			System.out.println("enter recharge ammount");
			double rechargeAmount=scan.nextDouble();
			int balance=accservice.rechargeAccount(mobileNo, rechargeAmount);
			System.out.println("recharge succussfull");
			System.out.println("dear   "+ account2.getCustomerName()+"  avail bal is  "+balance);
		}
		
			else {
				System.out.println("number should be 10 digits");
				case2();
			}
			switchCall();
		}
		private void exit() {
			System.exit(3);
			
			}
		
		}

	