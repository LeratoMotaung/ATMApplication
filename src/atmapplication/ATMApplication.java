/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapplication;

import java.util.Scanner;

/**
 *
 * @author A228471
 */
public class ATMApplication {
    

    
//User name, password, account balance
	 private String username="LERATO";
	private String password="12345";
	private double money=45960;
	
	public ATMApplication() {
		
	}
	
	public ATMApplication(String username,String password,double money) {
		this.username=username;
		this.password=password;
		this.money=money;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public double withdraw() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money=money;
	}
	
	@Override
	public String toString() {
		return "[username=" + username + ",password=" + password + ",money=" + money + "]";
	
        }
       

public static class ATMTest {
	 ATMApplication atm=new ATMApplication();//Instantiate a class object
	 Scanner input=new Scanner(System.in);//Console input
	 private int num=0;//Record the number of times the password is entered
	
	public void Select() {
		
		 System.out.println("Please enter the user name:");
		 String username=input.next();//User name and password do not contain spaces, so use next() instead of nextLine()
		 System.out.println("Please enter the password:");
		String password=input.next();
		 if(username.equals(atm.getUsername())&&password.equals(atm.getPassword())) {//User name and password are entered correctly
			 System.out.println("Login successful!!!");
			while(true) {
				
				 System.out.println("Please select items: 1. Withdraw money 2. Deposit money 3. Check balance 4. Transfer funds 5. Change password 6. Re-login 7. Logout");
				switch(input.nextInt()) {
					case 1: 
						 withdraw();//Withdraw money
						break;
					case 2:
						 deposit();//Save money
						break;
					case 3:
						 balance();//Check balance
						break;
					case 4:
						 transferMoney();//transfer
						break;
					case 5:
						 updatePassword();//Modify password
						break;
					case 6:
						 Select();//Login again
						break;
					case 7:
						 System.out.println("Thank you !");
						 System.exit(0);//Exit
						break;
					default :
						 System.out.println("Opps a mistake! Please re-enter!!!");
						break;
				}
			}
		 }else {//The username or password is incorrect
			 System.out.println("Username or password is wrong, please re-enter!!!");
			 Select();//Re-enter
		}
	}
	
	 public void withdraw() {//Withdraw money
		 System.out.println("Please enter the withdrawal amount R");
		 double rmb=input.nextDouble();//The console gets the amount of money withdrawn
		 if(rmb<=atm.withdraw()) {//The withdrawal amount is less than or equal to the current account balance
			 rmb=atm.withdraw()-rmb;//Subtract the taken away
			 atm.setMoney(rmb);//Call the set method to update the account balance
			 System.out.println("Withdrawal is successful!!!");
		 }else {//The withdrawal amount is greater than the current account balance
			 System.out.println("Sorry, account balance is insufficient!!!");
		}
	}
	
	 public void deposit() {//Save money
		 System.out.println("Please enter the deposit amount R");
		 double rmb=input.nextDouble();//The console gets the deposit amount
		 rmb+=atm.withdraw();//Plus the deposited
		 atm.setMoney(rmb);//Call the set method to update the account balance
		 System.out.println("Deposit is successful!!!");
	}
	
	 public void balance() {//Check balance
		 System.out.println("Your account balance is R" + atm.withdraw() );//Call the get method to get the account balance
	}
	
	 public void transferMoney() {//transfer
		 System.out.println("Please enter the user name of the transfer person:");
		String username=input.next();
		 System.out.println("Please enter the transfer amount:");
		double rmb=input.nextDouble();
		 if(rmb<=atm.withdraw()) {//The transfer amount is less than or equal to the current account balance
			 rmb=atm.withdraw()-rmb;//Subtract the transferred
			 atm.setMoney(rmb);//Call the set method to update the current account balance
			 System.out.println("Transfer is successful!!!");
		 }else {//The transfer amount is greater than the current account balance
			System.out.println("The transfer amount is insufficient!!");
		}
	}
	
	 public void updatePassword() {//Modify password
		 System.out.println("Please enter the original password:");
		 String password=input.next();//The console gets the original password
		 if(password.equals(atm.getPassword())) {//The original password is correct before you can continue to modify the password
			 System.out.println("Please enter a new password:");
			 String newpassword1=input.next();//New password
			 System.out.println("Please enter the new password again:");
			 String newpassword2=input.next();//The new password generally needs to be entered twice (you must be clear if you have changed the password)
			 if(newpassword1.equals(newpassword2)) {//Two new passwords match successfully
				 System.out.println("The password has been changed");
				 atm.setPassword(newpassword1);//Call the set method to update the original password to the new password
				 Select();//Log in again
			 }else {//The two new passwords are not the same
				 System.out.println("Error!Password entered does not match");
				updatePassword();
			}
		 }else {//The original password was entered incorrectly
			 num++;//Number of records
			 if(num>=3) {//More than or equal to three times, the system automatically exits
				
				 System.out.println("Exceeded number of tries");
				System.exit(0);
			}
			 System.out.println("password mismatched, please re-enter:");
			 updatePassword();//Continue to enter the original password
                 }
         }
}
	public static void main(String[] args) {
		ATMTest atmtest=new ATMTest();
		atmtest.Select();
    }
    
}
