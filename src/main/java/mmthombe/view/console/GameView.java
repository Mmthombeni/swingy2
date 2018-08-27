package mmthombe.view.console;

import java.util.Random;

import mmthombe.utils.*;

public class GameView{
    public String gameInstructions(){
        SwingyIO.ConsoleOutputLine("To move:");
        SwingyIO.ConsoleOutputLine("1. North (N)");
        SwingyIO.ConsoleOutputLine("2. West (W)");
        SwingyIO.ConsoleOutputLine("3. East (E)");
        SwingyIO.ConsoleOutputLine("4. South (S)");
        return SwingyIO.ConsoleInput().trim();
    }

    public int heroColliedVillian(){
        SwingyIO.ConsoleOutputLine("You have encounted a villain, would you like to fight or run?");
        SwingyIO.ConsoleOutputLine("1. Run");
        SwingyIO.ConsoleOutputLine("2. Fight");

        int input = SwingyIO.ConsoleInputInt();
        if (input == 1 || input == 2){
            return input;
        }
        else{
            SwingyIO.ConsoleOutputLine("Invalid input please select 1 or 2");
            return heroColliedVillian();
        }
    }

    public static boolean artifactDrop(){
        return (new Random().nextBoolean());  
    }

    public static int takeArtifact(){
        if (artifactDrop() == true){
            SwingyIO.ConsoleOutputLine("villian droped the following artifact, would you like to take it");
            SwingyIO.ConsoleOutputLine("1. Take artifact");
            SwingyIO.ConsoleOutputLine("2. Leave artifact");

            int input = SwingyIO.ConsoleInputInt();
            if (input == 1 || input == 2){
                return input;
            }
            else{
                SwingyIO.ConsoleOutputLine("Invalid input please select 1 or 2");
                return takeArtifact();
            }
        }
    }
}