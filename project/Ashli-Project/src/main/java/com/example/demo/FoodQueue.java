package com.example.demo;

//import java.awt.image.VolatileImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class FoodQueue {

    static Customer[] Q1 = new Customer[2];
    //= new Customer[2];
    static Customer[] Q2 = new Customer[3]; ;
    //= new Customer[3];
    static Customer[] Q3 = new Customer[5] ;
    static Customer[] Waiting_Que = new Customer[10];
    //= new Customer[5];
    static int Burgercount = 50;
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    public static void line() {
        System.out.print(" --------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void Init() {
        for (int i=0; i <2; i++) {
            Q1[i] = new Customer("", "", "X", 0);
        }
        for (int i=0; i <3; i++){
            Q2[i] = new Customer ("", "", "X", 0) ;
        }
        for (int i=0; i <5; i++){
            Q3[i] = new Customer ("", "", "X", 0) ;
        }
        for (int i=0; i <10; i++){
            Waiting_Que[i] = new Customer ("", "", "X", 0) ;
        }
    }

    public static void viewCol(String[] temp1, String[] temp2, String[] temp3 ){
        System.out.println("*****************");
        System.out.println("  * Cashiers *");
        System.out.println("*****************");

        for (int i = 0; i < 5; i++) {
            if (i < 2) {
                System.out.print("   " + temp1[i]+ "  " + temp2[i] + "  " + temp3[i]);
                System.out.println();
            } else if (i == 2) {
                System.out.print("      " + temp2[i] + "  " + temp3[i]);
                System.out.println();
            } else {
                System.out.print("         " + temp3[i]);
                System.out.println();
            }
        }
    }
    public static Customer [] returnQ1(){
        return Q1;
    }
    public static Customer[] returnQ2() {
        return Q2;
    }

    public static Customer[] returnQ3() {
        return Q3;
    }


    public static void viewAllQueues(){
        String[] temp1 = {Q1[0].Stat, Q1[1].Stat};
        String[] temp2 = {Q2[0].Stat, Q2[1].Stat, Q2[2].Stat};
        String[] temp3 = {Q3[0].Stat, Q3[1].Stat, Q3[2].Stat, Q3[3].Stat, Q3[4].Stat};

        viewCol(temp1, temp2, temp3);
    }
    public static void viewAllEmptyQueues(){
        String[] E_temp1 = {Q1[0].Stat, Q1[1].Stat};
        String[] E_temp2 = {Q2[0].Stat, Q2[1].Stat, Q2[2].Stat};
        String[] E_temp3 = {Q3[0].Stat, Q3[1].Stat, Q3[2].Stat, Q3[3].Stat, Q3[4].Stat};

        for(String m: E_temp1){
            if(m == "0"){
                Arrays.fill(E_temp1, " ");
            }
        }
        for(String m: E_temp2){
            if(m == "0"){
                Arrays.fill(E_temp2, " ");
            }
        }
        for(String m: E_temp3){
            if(m == "0"){
                Arrays.fill(E_temp3, " ");
            }
        }
        viewCol(E_temp1, E_temp2, E_temp3);
    }

    public static int removeCustomerLogic(int que, int pos) {
        int r = pos-1;
        if(que == 1){
            if (Q1[r].Stat == "0"){
                for(; r<1; r++){
                    Q1[r].Stat =  Q1[r+1].Stat;
                    Q1[r].firstName =  Q1[r+1].firstName;
                    Q1[r].LastName =  Q1[r+1].LastName;
                    Q1[r].BurgerCountReq = Q1[r+1].BurgerCountReq;
                }
                if(r==1){
                    Q1[1].setDefaultCustomer();
                }
                System.out.println("Customer removed successfully..");
                return 1;
            }
            else {
                System.out.println("There's no customer in that position to remove.");
            }
        }
        if(que == 2){
            if (Q2[r].Stat == "0"){
                for(; r<2; r++){
                    Q2[r].Stat =  Q2[r+1].Stat;
                    Q2[r].firstName =  Q2[r+1].firstName;
                    Q2[r].LastName =  Q2[r+1].LastName;
                    Q2[r].BurgerCountReq = Q2[r+1].BurgerCountReq;
                }
                if(r==2){
                    Q2[2].setDefaultCustomer();
                }
                System.out.println("Customer removed successfully..");
                return 1;
            }
            else {
                System.out.println("There's no customer in that position to remove.");
            }
        }
        if(que == 3){
            if (Q3[r].Stat == "0"){
                for(; r<4; r++){
                    Q3[r].Stat =  Q3[r+1].Stat;
                    Q3[r].firstName =  Q3[r+1].firstName;
                    Q3[r].LastName =  Q3[r+1].LastName;
                    Q3[r].BurgerCountReq = Q3[r+1].BurgerCountReq;
                }
                if(r==4){
                    Q3[4].setDefaultCustomer();
                }
                System.out.println("Customer removed successfully..");
                return 1;
            }
            else {
                System.out.println("There's no customer in that position to remove.");
            }
        }
    return 5;
    }

    public static void removeCustomer(){
        Scanner input =new Scanner(System.in);

         while(true){
            line();
            System.out.println("\t\t\t\t\t\t  REMOVE A CUSTOMER \t\t\t\t\t       ");
            line();
            System.out.println();

            System.out.println("Enter the que and the position you want to remove>> ");
            System.out.print("\t\tQue: ");
            int que = input.nextInt();
            System.out.print("\t\tPosition: ");
            int position = input.nextInt();

            if(que == 1) {
                if (position > 0 & position <= 2) {
                   int a =removeCustomerLogic(que, position);
                   if(a==1)return;
                } else {
                    System.out.println("Enter correct position");
                }
            }
            else if (que == 2) {
                if (position > 0 & position <= 3) {
                    int a = removeCustomerLogic(que, position);
                    if(a==1)return;
                } else {
                    System.out.println("Enter correct position");
                }
            }
            else if (que == 3){
                if (position > 0 & position <= 5) {
                    int a = removeCustomerLogic(que, position);
                    if(a==1)return;
                } else {
                    System.out.println("Enter correct position");
                }
            }
            else {
                System.out.println("Enter correct que number first.");
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static void addtothewaitingList(String firstname,String lastname,int BugerCountReq){
        for(int i=0; i<10; i++){
            if(Waiting_Que[i].Stat == "X"){
                Waiting_Que[i].addCustomerDetails(firstname, lastname, BugerCountReq);
                break;
            }
        }
        for (int i=0; i<10; i++){
            System.out.println(Waiting_Que[i].firstName + " " + Waiting_Que[i].LastName + " " + Waiting_Que[i].Stat+ " " + Waiting_Que[i].BurgerCountReq );
        }
    }

    public static void addNewCustomer(){
        Scanner input = new Scanner(System.in);

        outer: while(true){
            line();
            System.out.println("\t\t\t\t\t\t  ADD NEW CUSTOMER  \t\t\t\t\t       ");
            line();
            System.out.println();

            System.out.print("Input First name : ");
            String firstname=input.next();

            System.out.print("Input Last name : ");
            String lastname=input.next();

            while (true){
                System.out.print("Number of Burgers required: ");
                String BurgerCountReq=input.next();
                if(isNumeric(BurgerCountReq)){
                    int BugerCountReq = Integer.parseInt(BurgerCountReq);
                    boolean result = selectQueueWithMinLength1(firstname,lastname,BugerCountReq);
                    if(!result){
                        System.out.println("All queues are full..");
                        addtothewaitingList(firstname,lastname,BugerCountReq);
                        break outer;
                    }
                    else {
                        System.out.println("Customer added successfully..");
                        while (true) {
                            System.out.print("Do you want to add another Customer (Y/N) : ");
                            char ch = input.next().charAt(0);
                            if (ch == 'Y' || ch == 'y') {
                                clearConsole();
                                continue outer;
                            } else if (ch == 'N' || ch == 'n') {
                                clearConsole();
                                return;
                            } else {
                                System.out.println("\tInvalid Input...  \n");
                            }
                        }
                    }
                }
                else{
                    System.out.println("Invalid input..");
                }
            }
        }
    }

    public static void removeServedcustomerLogic(int QueNumber){
        if (QueNumber == 1){
            if(Q1[0].Stat == "0"){
                Burgercount= Burgercount-Q1[0].BurgerCountReq;
                for (int i=0; i<1; i++){
                    Q1[i].Stat = Q1[i+1].Stat;
                    Q1[i].firstName = Q1[i+1].firstName;
                    Q1[i].LastName = Q1[i+1].LastName;
                    Q1[i].BurgerCountReq = Q1[i+1].BurgerCountReq;

                    Q1[i+1].setDefaultCustomer();
                }
                System.out.println("Customer has been served..KK");
                System.out.println("BurgerC: " + Burgercount);
            }
            else
                System.out.println("There is no customer in that que to serve");
            }

        else if(QueNumber == 2){
            if(Q2[0].Stat == "0"){
                Burgercount= Burgercount-Q2[0].BurgerCountReq;
                for (int i=0; i<2; i++){
                    Q2[i].Stat = Q2[i+1].Stat;
                    Q2[i].firstName = Q2[i+1].firstName;
                    Q2[i].LastName = Q2[i+1].LastName;
                    Q2[i].BurgerCountReq = Q2[i+1].BurgerCountReq;

                    if(i==1){
                        Q2[i+1].setDefaultCustomer();
                    }
                }
                System.out.println("Customer has been served..");
                System.out.println("BurgerC: " + Burgercount);
            }
            else
                System.out.println("There is no customer in that que to serve.");
        }
        else if(QueNumber == 3){
            if(Q3[0].Stat == "0"){
                Burgercount= Burgercount-Q3[0].BurgerCountReq;
                for (int i=0; i<4; i++){
                    Q3[i].Stat = Q3[i+1].Stat;
                    Q3[i].firstName = Q3[i+1].firstName;
                    Q3[i].LastName = Q3[i+1].LastName;
                    Q3[i].BurgerCountReq = Q3[i+1].BurgerCountReq;

                    if(i==3){
                        Q3[i+1].setDefaultCustomer();
                    }
                }
                System.out.println("Customer has been served..");
            }
            else
                System.out.println("There is no customer in that que to serve.");
        }
    }

    public static void removeServedcustomer(){
        Scanner input = new Scanner(System.in);

        outer:while (true) {
            line();
            System.out.println("\t\t\t\t\t\t  REMOVE SERVED CUSTOMER \t\t\t\t\t       ");
            line();
            System.out.println();

            System.out.print("Enter Que number you want serve first>>");
            int servedCustomerque = input.nextInt();

            if (servedCustomerque == 1)
                removeServedcustomerLogic(1);
            else if (servedCustomerque == 2)
                removeServedcustomerLogic(2);
            else if (servedCustomerque == 3)
                removeServedcustomerLogic(3);
            else {
                System.out.println("Invalid input.");
                continue;
            } //warning message will appear when the burger count less than or 10.
            if(Burgercount <= 10){
                System.out.println("WARNING: Stock is reaching out of the limit.Remaining burger count: " + Burgercount);
            }

            while (true) {
                System.out.print("Do you want to add Serve another Customer (Y/N) : ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    continue outer;
                } else if (ch == 'N' || ch == 'n') {
                    clearConsole();
                    return;
                } else {
                    System.out.println("\tInvalid Input...  \n");
                }
            }
        }
    }
    public static boolean selectQueueWithMinLength1( String first_name,String Last_name,int BurgerCountReq){
        for (int i=0; i <5; i++){
            if(i<2){
                if(Q1[i].Stat =="X"){
                    Q1[i].addCustomerDetails(first_name, Last_name, BurgerCountReq);
                    return true;
                }
                else if (Q2[i].Stat == "X"){
                    Q2[i].addCustomerDetails(first_name, Last_name, BurgerCountReq);
                    return true;
                }
                else if (Q3[i].Stat == "X"){
                    Q3[i].addCustomerDetails(first_name, Last_name, BurgerCountReq);
                    return true;
                }
            }
            else if(i<3){
                if(Q2[i].Stat =="X"){
                    Q2[i].addCustomerDetails(first_name, Last_name, BurgerCountReq);
                    return true;
                }
                if(Q3[i].Stat =="X"){
                    Q3[i].addCustomerDetails(first_name, Last_name, BurgerCountReq);
                    return true;
                }
            }
            else {
                if(Q3[i].Stat =="X"){
                    Q3[i].addCustomerDetails(first_name, Last_name, BurgerCountReq);
                    return true;
                }
            }
        }
    return false;
    }

    public static void sortArray_by_Last_or_First(String arr[]){

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent strings and swap them if necessary
                if (arr[j].compareToIgnoreCase(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i=0; i<arr.length; i++) {
            if (!arr[i].equals(" ")){
                System.out.println(arr[i]);
            }
        }
    }
    public static void sortArray(){
        line();
        System.out.println("\t\t\t\t\t\t  SORT CUSTOMERS  \t\t\t\t\t       ");
        line();
        System.out.println();

        String[] arr_FN = {Q1[0].firstName+ " "+ Q1[0].LastName , Q1[1].firstName+ " "+ Q1[1].LastName, Q2[0].firstName+ " "+ Q2[0].LastName,  Q2[1].firstName+ " "+Q2[1].LastName , Q2[2].firstName+ " "+Q2[2].LastName, Q3[0].firstName+ " "+ Q3[0].LastName, Q3[1].firstName+ " "+ Q3[1].LastName, Q3[2].firstName+ " "+ Q3[2].LastName, Q3[3].firstName+ " "+ Q3[3].LastName, Q3[4].firstName+" "+ Q3[4].LastName  };
        String[] arr_LA = {Q1[0].LastName+ " "+ Q1[0].firstName , Q1[1].LastName+ " "+ Q1[1].firstName, Q2[0].LastName+ " "+ Q2[0].firstName,  Q2[1].LastName+ " "+Q2[1].firstName , Q2[2].LastName+ " "+Q2[2].firstName, Q3[0].LastName+ " "+ Q3[0].firstName, Q3[1].LastName+ " "+ Q3[1].firstName, Q3[2].LastName+ " "+ Q3[2].firstName, Q3[3].LastName+ " "+ Q3[3].firstName, Q3[4].LastName+" "+ Q3[4].firstName  };

        System.out.println("-------By first name-------");
        sortArray_by_Last_or_First(arr_FN);
        System.out.println();
        System.out.println("-------By Last name--------");
        sortArray_by_Last_or_First(arr_LA);

    }

    public static void writeDataintoFile(){
        try {
            // Create an object of BufferedWriter
            BufferedWriter f_writer
                    = new BufferedWriter(new FileWriter(
                    "C:\\Users\\KMN IT\\Desktop\\JavaCWE\\saveData.txt"));

            f_writer.write("--------Customer Details ------\n");

            for(int i=0; i<2; i++){
                if (Q1[i].Stat == "0")
                    f_writer.write(Q1[i].firstName + " " + Q1[i].LastName + " ----> Burgers:" + Q1[i].BurgerCountReq + "\n");
            }
            for(int i=0; i<3; i++){
                if (Q2[i].Stat == "0")
                    f_writer.write(Q2[i].firstName + " " + Q2[i].LastName + " ----> Burgers:" + Q2[i].BurgerCountReq+ "\n");
            }
            for(int i=0; i<5; i++){
                if (Q3[i].Stat == "0")
                    f_writer.write(Q3[i].firstName + " " + Q3[i].LastName + " ----> Burgers:" + Q3[i].BurgerCountReq+ "\n");
            }

            System.out.print("File is created successfully with the content.\n");
            f_writer.close();
        }
        // Catch block to handle if exceptions occurs
        catch (IOException e) {
            // Print the exception on console
            // using getMessage() method
            System.out.print(e.getMessage());
        }
    }

    public static void readFile() throws Exception
    {
        // pass the path to the file as a parameter
        File file = new File(
                "C:\\Users\\KMN IT\\Desktop\\JavaCWE\\saveData.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }


    public static void AddBurgertoStock(){
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the burger amount to add: ");
            int refill_burger = input.nextInt();

            if ((Burgercount + refill_burger) > 50) {
                System.out.println("Exceeded max burger count.");
            }
            else{
                Burgercount = Burgercount + refill_burger;
                System.out.println("Stock updated.");
                break;
            }
        }
    }
    public static void printCustomers(){
        for (int i=0; i<2; i++){
            System.out.println("QUE1:");
            System.out.println(Q1[i].firstName+ " "+Q1[i].LastName + " "+ Q1[i].Stat+ " "+ Q1[i].BurgerCountReq);
        }
        for (int i=0; i<3; i++){
            System.out.println("QUE2:");
            System.out.println(Q2[i].firstName+ " "+Q2[i].LastName + " "+ Q2[i].Stat+ " "+ Q2[i].BurgerCountReq);
        }
        for (int i=0; i<5; i++){
            System.out.println("QUE3:");
            System.out.println(Q3[i].firstName+ " "+Q3[i].LastName + " "+ Q3[i].Stat+ " "+ Q3[i].BurgerCountReq);
        }
    }
    public static void ViewRemainingBurgerStock(){
        System.out.println("Remaining Burger Count: " + Burgercount);
    }
    public static void homepage(){
        line();
        System.out.println("                      |\t\t\t\t\t\t  Foodies Fave Food Center \t\t\t\t\t       |             ");
        line();
        System.out.println();
        System.out.println("\t\t\t 1) View All Queues.              -[VFQ/100] \t\t  2) View All Empty Queues.      -[VEQ/101]");
        System.out.println("\t\t\t 3) Add customer to a Queue.      -[ACQ/102] \t\t  4) Remove a Customer from Que. -[RCQ/103]");
        System.out.println("\t\t\t 5) Remove a served customer.     -[PCQ/104] \t\t  6) View Customers Sorted       -[VCS/105}");
        System.out.println("\t\t\t 7) Store Program Data into file. -[SPD/106] \t\t  8) Load Program Data from file -[LPD/107]");
        System.out.println("\t\t\t 9) View Remaining burgers Stock. -[STK/108] \t\t  10) Add burgers to Stock       -[AFS/109]");
        System.out.println(" \n\t\t\t 11) Exit the Program.  -[999/EXT]                                                                            ");
        System.out.println();

    }


}