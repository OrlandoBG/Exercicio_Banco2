package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) throws BusinessException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number,holder,balance,withdrawLimit);
		
		System.out.println();
		
		System.out.print("Enter balance for withdraw: ");
		account.withdraw(sc.nextDouble());
		
		System.out.println("New balance: " + account.getBalance());
		
		sc.close();
		}
		catch(InputMismatchException e) {
			System.out.println("Error: You must enter numbers" );
		}
		catch(BusinessException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		

	}

}
