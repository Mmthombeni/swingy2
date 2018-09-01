package mmthombe.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mmthombe.model.Character;
import mmthombe.model.Coordinates;
import mmthombe.model.Villain;
import mmthombe.model.CreateHeroModel;

public class VillainFactory{
    private static int id;
    private static Random random = new Random();

    private static Villain newVillain(Character hero){
        int attack = ((hero.getAttack()/3) + random.nextInt(hero.getAttack()));
        int defense = ((hero.getDefense()/3) + random.nextInt(hero.getDefense()));
        int hp = ((hero.getHP()/3) + random.nextInt(hero.getHP()));

        return new Villain("Kaygo" + (++id), 0, attack, defense, hp, CreateHeroModel.getRandomArtifact());
    }

    public static List<Villain> villainList(Character hero, int map_size){
        List<Villain> villains = new ArrayList<Villain>();
        int numberOfVillians = (((hero.getLevel() + 1) * 5) + 5);
        Coordinates centreCoordinates = new Coordinates(map_size/2, map_size /2);

        for (int i = 0; i < numberOfVillians; i++){
            Villain villain = newVillain(hero);
            Coordinates coords = new Coordinates(random.nextInt(map_size), random.nextInt(map_size));
            villain.setCoordinates(coords); 

            if (!isSamePosition(villains, villain) && !coords.equals(centreCoordinates))
                villains.add(villain);
            else{
                i--;
            }
        }
        return villains;
    }

    private static Boolean isSamePosition(List<Villain> villainList, Villain villain){
        for (Villain e : villainList) {
            if (villain.getCoodrinates().equals(e.getCoodrinates())){
                return (true);
            }
        }
        return (false);
    }
}