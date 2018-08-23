package mmthombe.model;

import java.util.ArrayList;
import java.util.List;

import mmthombe.factories.VillainFactory;
import mmthombe.utils.FileHandler;
import mmthombe.utils.Formulas;
import mmthombe.utils.SwingyIO;

public class GameModel{
    private Character _hero;
    private int _map_size = 0;
    private int _HP = 0;

    public GameModel(Character hero){
        this._hero = hero;
        this._HP = this._hero.getHP();
        this._map_size = Formulas.GetMapSize(this._hero.getLevel());
        this._hero.setCoordinates(new Coordinates(this._map_size / 2, this._map_size / 2));
    }

    public String getMap(){
        String map = "";
        Coordinates loopCoords = new Coordinates();
        List<Villain> villains = VillainFactory.villainList(this._hero);

        for (int y = 0; y < this._map_size; y++){
            for (int x = 0; x < this._map_size; x++){
                loopCoords.setY(y);
                loopCoords.setX(x);
                boolean villainPostion = false;
                
                if (loopCoords.equals(this._hero.getCoodrinates())){
                    map += "H ";
                }else{
                    for (Villain villain : villains) {
                        if (loopCoords.equals(villain.getCoodrinates())){
                            map += "V ";
                            villainPostion = true;
                        }
                    }
                    if (villainPostion == false)
                        map += "* ";
                }
            }
            map += "\n";
        }
        return map;
    }

    public boolean isHeroWithinMap(){
        Coordinates heroCoords = this._hero.getCoodrinates();

        return (
            (heroCoords.getX() > 0 && heroCoords.getX() < this._map_size) &&
            (heroCoords.getY() > 0 && heroCoords.getY() < this._map_size)
        );
    }

    public void heroWonFight(){
        this._hero.setXP(this._hero.getXP() + 50);
    }

    public void heroWonGame(){
        this._hero.setXP(this._hero.getXP() + 95);
        this._hero.setHP(this._HP);
        String data = this.heroToUpdate();
        FileHandler.updateHero(data);
    }

    public boolean isHeroAlive(){
        return (this._hero.getHP() > 0);
    }

    public void moveNorth(){
        this._hero.getCoodrinates().setY((this._hero.getCoodrinates().getY() - 1));
    }

    public void moveSouth(){
        this._hero.getCoodrinates().setY((this._hero.getCoodrinates().getY() + 1));
    }

    public void moveEast(){
        this._hero.getCoodrinates().setX((this._hero.getCoodrinates().getX() + 1));
    }

    public void moveWest(){
        this._hero.getCoodrinates().setX((this._hero.getCoodrinates().getX() - 1));
    }

    public Character getHero(){
        return this._hero;
    }

    public String heroToUpdate(){
        String str = FileHandler.ReadFile();
        String data = "";
        String[] lines = str.split("\\r?\\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            if (this._hero.getName().equalsIgnoreCase(parts[0]))
                line = this._hero.getName() + "," + this._hero.getClass().getSimpleName().substring(4) + "," + this._hero.getXP() + "," + this._hero.getAttack() + "," + this._hero.getDefense() + "," + this._hero.getHP() + "," + this._hero.getArtifact();
            data += line + "\n"; 
        }
        return data;
    }
}