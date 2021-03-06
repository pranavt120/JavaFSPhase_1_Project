package com.lockedMe;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LockedMe {
   private static Scanner scn = new Scanner(System.in);
   private static  File directoryPath = new File("D:\\java\\File");

    public  static void greetingScreen() throws NullPointerException{
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

    public static void displayMenu() throws NullPointerException{
        String choice="";
        while(!choice.equalsIgnoreCase("q")){
            System.out.println("\n\n");
            System.out.println("Please Choose an option ");
            System.out.println("1. List all Files\n" +
                    "2. Add a File\n" +
                    "3. Delete a File\n" +
                    "4. Search File\n" +
                    "5. Go back to the Greetings Menu\n"+
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
                    searchFile();
                    break;
                case "5":
                    greetingScreen();
                    break;
                case "q":
                    break;
                default:
                    System.out.println("\n\n\n\n\nEnter a valid choice");
            }
        }

    }

    public static void listAllFiles() throws NullPointerException{
        String contents[] = directoryPath.list();
        System.out.println("List of all files in "+ directoryPath+" : ");
        Arrays.sort(contents);
        for( var i: contents){
            System.out.println(i);
        }

    }
    public static void addFile(){
        String fileName;
        String character;
        FileWriter fout = null;
        BufferedWriter out = null;
        System.out.println("Enter the name of the file, you want to add: ");
        fileName = scn.nextLine();
        try{
             fout = new FileWriter(new File(directoryPath+"\\"+fileName));
             out = new BufferedWriter(fout);
            System.out.println("Enter the content, you want to add into the file.");
            System.out.println("Press \"$\" key and Press Enter key to Add file to the Directory. ");
            while(true){
                character = scn.nextLine();
                if(character.charAt(character.length() -1) == '$'){
                    out.write(character.substring(0,character.length() -1));
                    out.flush();
                    break;
                }else{
                    out.write(character+"\n");
                }
            }
            System.out.println("File added successfully");

        }catch (IOException ex){
            System.out.println("Could not Add file . Check directory path");
        } catch (NoSuchElementException ne){
            System.out.println("No such element");

        } finally{
            if(fout != null){
                try{
                    fout.close();
                }catch (IOException ex){
                    System.out.println("could not close fout");
                }
            }
            if(out != null){
                try{
                    out.close();
                }catch (IOException ex){
                    System.out.println("could not close Buffered reader");
                }
            }

        }

    }
    public static void deleteFile(){
        String fileName;
        System.out.println("Enter a File name to Delete");
        fileName = scn.nextLine();
        File file = new File(directoryPath+"\\"+fileName);
        if(file.delete()){
            System.out.println("File deleted successfully");
        }else{
            System.out.println("Failed to delete the file (File not Found)");
        }
    }
    public static void addDirctoryPath(){
        System.out.println("in directory path");
        System.out.println("Enter a valid Directory path you want to Look in: (Ex: D:\\java\\File)");
        String directory = scn.nextLine();


        while (true){
            try{
                if(Files.isDirectory(Paths.get(directory))){
                    directoryPath = new File(directory);
                    break;
                }else{
                    System.out.println("Enter a valid Directory path you want to Look in: (Ex: D:\\java\\File)");
                    directory = scn.nextLine();
                }
            }catch (InvalidPathException ex){
                System.out.println("Enter a valid Directory path you want to Look in: (Ex: D:\\java\\File). There should not be any space before the path");
                directory = scn.nextLine();
            }

            System.out.println(directory);
        }

    }

    public static void searchFile(){
        String fileName;
        List<String> files = new ArrayList<>(Arrays.asList(directoryPath.list()));
        System.out.println("Enter File Name");
        fileName = scn.nextLine();
        if(files == null){
            System.out.println("Empty directory");
        }else{
            if(Collections.binarySearch(files,fileName)< 0){
                System.out.println("File not Found");
            }else{
                System.out.println(fileName+" is available");
            }
        }
    }


}
