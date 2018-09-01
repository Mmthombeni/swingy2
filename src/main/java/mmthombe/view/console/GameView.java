package mmthombe.view.console;

import java.util.Random;

import mmthombe.enums.Artifacts;
import mmthombe.messages.Messages;
import mmthombe.model.Villain;
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

    public int heroColliedVillian(Villain villain){
        SwingyIO.ConsoleOutputLine("You have encounted a villain named " + villain.getName() + " with the following: " + villain.getAttack() + " attack, would you like to fight or run?");
        SwingyIO.ConsoleOutputLine("1. Run");
        SwingyIO.ConsoleOutputLine("2. Fight");

        int input = SwingyIO.ConsoleInputInt();
        if (input == 1 || input == 2){
            return input;
        }
        else{
            SwingyIO.ConsoleOutputLine("Invalid input please select 1 or 2");
            return heroColliedVillian(villain);
        }
    }

    public boolean artifactDrop(){
        return (new Random().nextBoolean());  
    }

    public int takeArtifact(Artifacts artifact){
        SwingyIO.ConsoleOutputLine(Messages.ArtifactMsg(artifact.toString()));
        SwingyIO.ConsoleOutputLine("1. Take artifact");
        SwingyIO.ConsoleOutputLine("2. Leave artifact");

        int input = SwingyIO.ConsoleInputInt();
        if (input == 1 || input == 2){
            return input;
        }
        else{
            SwingyIO.ConsoleOutputLine("Invalid input please select 1 or 2");
            return takeArtifact(artifact);
        }
    }
}