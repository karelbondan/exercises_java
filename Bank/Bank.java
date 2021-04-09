package com.assignment.bank;

public class Bank {
    private java.util.ArrayList<Customer> customers = new java.util.ArrayList<>();
    private int numberOfCustomer = 0;
    private final String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addCustomer(String firstName, String lastName){
        customers.add(new Customer(firstName, lastName));
        numberOfCustomer++;
    }

    public int getNumberOfCustomer(){
        return numberOfCustomer;
    }

    public Customer getCustomer(int index){
        return customers.get(index);
    }

    public String getBankName(){
        return bankName;
    }

    public boolean customerExist(String firstName, String lastName){
        for (int i = 0; i<=customers.size()-1; i++){
            if (getCustomer(i).getFirstName().equals(firstName) && getCustomer(i).getLastName().equals(lastName)) return true;
        }
        return false;
    }

    public int customerIndex(String firstName, String lastName){
        int index = 0;
        for (int i = 0; index<=customers.size()-1; i++){
            if (getCustomer(i).getFirstName().equals(firstName) && getCustomer(i).getLastName().equals(lastName)) break;
            index++;
        }
        return index;
    }
}
