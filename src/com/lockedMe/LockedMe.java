package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class LockedMe {
   private static Scanner scn = new Scanner(System.in);
   private static  File directoryPath = new File("D:\\java\\File");

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
                addDirctoryPath();
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
            System.out.println("\n\n");
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

    public static void listAllFiles(){
        String contents[] = directoryPath.list();
        System.out.println("List of all files in "+ directoryPath+" : ");
        for( var i: contents){
            System.out.println(i);
        }

    }
    public static void addFile(){}
    public static void deleteFile(){}
    public static void addDirctoryPath(){
        String directory;
        System.out.println("Enter a valid Directory path you want to Look in:");
        directory = scn.nextLine();
        directoryPath = new File(directory);
    }


}
