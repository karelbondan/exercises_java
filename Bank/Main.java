package com.assignment.bank;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int option;
        Scanner input = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        Bank bank = new Bank("bank name");

        do {
            String firstName;
            String lastName;
            System.out.println("Welcome to " + bank.getBankName() + "\n=== Menu ===");
            System.out.print("1. New Customer\n2. Existing Customer\n3. Exit\nYour option: ");
            option = input.nextInt();

            if (option == 1) {
                do {
                    System.out.print("\nEnter your first name (type \"q\" to cancel): ");
                    firstName = name.nextLine();
                    System.out.print("Enter your last name (type \"q\" to cancel): ");
                    lastName = name.nextLine();
                } while (bank.customerExist(firstName, lastName));
                if (firstName.equals("q") || lastName.equals("q")){}
                else{
                    System.out.print("Enter amount of money to be deposited: Rp ");
                    double balance = input.nextDouble();
                    bank.addCustomer(firstName.toUpperCase(Locale.ROOT), lastName.toUpperCase(Locale.ROOT));
                    bank.getCustomer(bank.getNumberOfCustomer() - 1).setAccount(new Account(balance));
                }

            } else if (option == 2) {
                System.out.print("\nEnter your first name: ");
                firstName = name.nextLine();
                System.out.print("Enter your last name: ");
                lastName = name.nextLine();
                boolean customer_exist = bank.customerExist(firstName.toUpperCase(Locale.ROOT), lastName.toUpperCase(Locale.ROOT));

                if (!customer_exist) System.out.println("You do not have an account in this bank yet\n");
                else {
                    int choose;
                    int index;
                    double amount;
                    do{
                        System.out.println("What do you want to do?");
                        System.out.print("1. Deposit\n2. Withdraw\n3. Balance\n4. Exit\nYour option: ");
                        choose = input.nextInt();
                        if (choose == 1)
                        {
                            index = bank.customerIndex(firstName, lastName);
                            do{
                                System.out.print("Enter amount (type \"-1\" to cancel): ");
                                amount = input.nextDouble();
                                bank.getCustomer(index).getAccount().deposit(amount);
                            } while(!bank.getCustomer(index).getAccount().deposit(amount));
                            if (amount == -1){}
                            else {
                                System.out.println("Deposit of Rp " + amount + " succeeded\n");
                            }
                        }
                        else if (choose == 2)
                        {
                            index = bank.customerIndex(firstName, lastName);
                            do{
                                System.out.print("Enter amount (type \"-1\" to cancel): ");
                                amount = input.nextDouble();
                                bank.getCustomer(index).getAccount().withdraw(amount);
                                if (amount == -1){
                                    break;
                                }
                            } while(!bank.getCustomer(index).getAccount().withdraw(amount));
                            if (amount == -1){}
                            else {
                                System.out.println("Withdraw of Rp " + amount + " succeeded\n");
                            }
                        }
                        else if (choose == 3)
                        {
                            index = bank.customerIndex(firstName, lastName);
                            System.out.println("You have Rp " + bank.getCustomer(index).getAccount().getBalance() + "\n");
                        }
                    } while (choose != 4);
                }
            } else {
                System.out.println("\ninvalid input\n");
            }
        } while (option != 3);
    }
}
