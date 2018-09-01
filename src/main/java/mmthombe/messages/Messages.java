package mmthombe.messages;

public class Messages{
    public static final String CONTINUE_MESSAGE = "Press Enter to continue...";
    public static final String RUN_MESSAGE = "You lucky thing, will get you next time";
    public static final String FORCE_FIGHT_MSG = "Unfortunaley you are forced to face your enemy and fight";
    public static final String FIGHT_WON = "You won the fight!";
    public static final String FIGHT_LOST = "You lost the fight!";
    public static final String GAME_OVER_WON = "Game Over!! You WIN!!";
    public static final String GAME_OVER_LOST = "Game Over!! You LOST!!";
    public static final String VILLIAN_ENCOUNTER = "You have encounted a villian would you like to run(Yes) or fight(No)? Villian has attack of ";
    public static final String INVALID_INPUT = "Please pick the correct input.";

    public static String ArtifactMsg(String artifact){
        return "villian droped " + artifact + ", would you like to take it or leave it?";
    }
}