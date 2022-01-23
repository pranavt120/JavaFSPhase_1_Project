package com.lockedMe;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try{
            LockedMe.greetingScreen();
        }catch (NullPointerException ex){
            System.out.println("Enter Correct directory path");
        }





    }
}
