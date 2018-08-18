package mmthombe.utils;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class SwingyIO {
    public static void ConsoleOutputLine(String msg){
        ConsoleOutput(msg + "\n");
    }

    public static void ConsoleOutput(String msg){
        System.out.print(msg);
    }

    public static int ConsoleInputInt(){
        String Snumber = ConsoleInput();
        try {
            int number = Integer.parseInt(Snumber);
            return number;
        } catch (Exception e) {
            return -1;
        }
    }

    public static String ConsoleInput(){
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        //reader.close();
        return userInput;
    }

    public static void GUIOutput(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}