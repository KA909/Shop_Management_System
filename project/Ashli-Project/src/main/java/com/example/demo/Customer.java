package com.example.demo;

public class Customer {

    String firstName;
    String LastName;
    int BurgerCountReq;

    String Stat;

    Customer(String FName, String LName, String Status,int BurCount) {
        firstName = FName;
        LastName = LName;
        Stat = Status;
        BurgerCountReq = BurCount;
    }


    public String getStatus() {
       return Stat;

    }
    public  String getFirstName(){
        return firstName;
    }
    public  String getLastName(){
        return LastName;
    }
    public int getBurgerCountReq(){
        return BurgerCountReq;
    }

    public void setDefaultCustomer(){
        firstName = "";
        LastName = "";
        Stat = "X";
        BurgerCountReq = 0;
    }

    public void addCustomerDetails(String first_name,String Last_name, int BCount){
        firstName = first_name;
        LastName = Last_name;
        BurgerCountReq = BCount;
        Stat = "0";

    }
}