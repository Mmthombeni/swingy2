package mmthombe.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mmthombe.enums.Artifacts;
import mmthombe.model.Character;
import mmthombe.model.Coordinates;
import mmthombe.model.Villain;
import mmthombe.utils.Formulas;

public class VillainFactory{
    private static Villain newVillain(Character hero){
        Random random = new Random();
        int attack = ((hero.getAttack()/2) + random.nextInt(hero.getAttack()));
        int defense = ((hero.getDefense()/2) + random.nextInt(hero.getDefense()));
        int hp = ((hero.getHP()/2) + random.nextInt(hero.getHP()));
        int map_size = Formulas.GetMapSize(hero.getLevel());
        Coordinates coords = new Coordinates(random.nextInt(map_size), random.nextInt(map_size));
        Villain villain = new Villain("Kaygo", 0, attack, defense, hp, Artifacts.ARMOR);
        villain.setCoordinates(coords);
        
        return villain;
    }

    public static List<Villain> villainList(Character hero){
        List<Villain> villains = new ArrayList<Villain>();
        int numberOfVillians = ((hero.getLevel() * 2) + 5);

        for (int i = 0; i < numberOfVillians; i++){
            villains.add(newVillain(hero));
        }
        return villains;
    }
}