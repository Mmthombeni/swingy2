package mmthombe.utils;

public class Formulas{
    public static int GetMapSize(int level){
        return ((level -1) * 5 + 10 -  (level % 2));
    }

    public static int GetLevel(int xp) 
    {
        double level = 0;
        level = (-100 + Math.sqrt(-800000 + 1800 * ((double)xp))) / (900);
        return (int)level;   
    }
}