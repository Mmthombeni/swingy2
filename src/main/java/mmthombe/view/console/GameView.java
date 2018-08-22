package mmthombe.view.console;

import mmthombe.model.Character;
import mmthombe.utils.Formulas;
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
}