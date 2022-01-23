package com.lockedMe;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class LockedMe {
   private static Scanner scn = new Scanner(System.in);
    public  static void greetingScreen(){
        String  choice ;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t Welcome to LockedMe.com \t\t");
        System.out.println("\t\t\tDesigned and Developed by \t\"Pranav Takkar\"");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Press :");
        System.out.println("1. To go to the Main Menu\n" +
                           "2. To Exit the Application");

        choice = scn.nextLine();
        while((!choice.equals("1")) || (!choice.equals("2"))){
            if(choice.equals("1")){
                displayMenu();
                break;
            }else if( choice.equals("2")){
                break;
            }else{
                System.out.println("Enter a valid choice");
                choice = scn.nextLine();
            }
        }
    }

    public static void displayMenu(){
        String choice="";
        while(!choice.equalsIgnoreCase("q")){
            System.out.println("Please Choose an option ");
            System.out.println("1. List all Files\n" +
                    "2. Add a File\n" +
                    "3. Delete a File\n" +
                    "4. Go back to the Greetings Menu\n" +
                    "Q. To Close the Application");
            choice = scn.nextLine().toLowerCase(Locale.ROOT);
            switch (choice){
                case "1":
                    listAllFiles();
                    break;
                case "2":
                    addFile();
                    break;
                case "3":
                    deleteFile();
                    break;
                case "4":
                    greetingScreen();
                    break;
                case "q":
                    break;
                default:
                    System.out.println("\n\n\n\n\nEnter a valid choice");
            }
        }

    }

    public static void listAllFiles(){}
    public static void addFile(){}
    public static void deleteFile(){}


}
