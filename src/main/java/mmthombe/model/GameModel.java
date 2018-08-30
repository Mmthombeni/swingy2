package mmthombe.model;

import java.util.List;
import java.util.Random;

import mmthombe.factories.VillainFactory;
import mmthombe.utils.FileHandler;
import mmthombe.utils.Formulas;

public class GameModel{
    private int _HP;
    private String _map;
    private int _map_size;
    private Character _hero;
    private List<Villain> _villains;
    private boolean _matchPostion = false;
    private Villain _villain;
    private Coordinates _heroPreviousPosition;

    public GameModel(Character hero){
        this._hero = hero;
        this._HP = this._hero.getHP();
        this._map_size = Formulas.GetMapSize(this._hero.getLevel());
        this._hero.setCoordinates(new Coordinates(this._map_size / 2, this._map_size / 2));
        this._villains = VillainFactory.villainList(this._hero, this._map_size);
    }

    public void drawMap(){
        this._map = "";
        boolean heroPostion;
        boolean villainPostion;
        this._matchPostion = false;
        Coordinates loopCoords = new Coordinates();

        for (int y = 0; y < this._map_size; y++){
            for (int x = 0; x < this._map_size; x++){
                loopCoords.setY(y);
                loopCoords.setX(x);
                villainPostion = false;
                heroPostion = false;
                
                if (loopCoords.equals(this._hero.getCoodrinates())){
                    heroPostion = true;
                }
                for (Villain villain : this._villains) {
                    if (loopCoords.equals(villain.getCoodrinates()) && (villain.getHP() > 0)){
                        villainPostion = true;

                        if (villainPostion == true && heroPostion == true){
                            this._villain = villain;
                        }
                        break;
                    }
                }
                if (villainPostion == true && heroPostion == true){
                    this._map += "# ";
                    this._matchPostion = true;
                }
                else if (villainPostion == true){
                    this._map += "V ";
                }
                else if (heroPostion == true){
                    this._map += "H ";
                }
                else {
                    this._map += "* ";
                }
            }
            this._map += "\n";
        }
    }

    public void setHeroPreviousPosition(Coordinates coordinates){
        this._heroPreviousPosition = new Coordinates(coordinates.getY(), coordinates.getX());
    }

    public String getMap(){
        return this._map;
    }

    public boolean getMatchPostion(){
        return this._matchPostion;
    }

    public boolean isHeroWithinMap(){
        Coordinates heroCoords = this._hero.getCoodrinates();

        return (
            (heroCoords.getX() >= 0 && heroCoords.getX() < this._map_size) &&
            (heroCoords.getY() >= 0 && heroCoords.getY() < this._map_size)
        );
    }

    public void heroWonFight(){
        this._hero.setXP(this._hero.getXP() + 1000);
    }

    public void heroWonGame(){
        this._hero.setXP(this._hero.getXP() + 1020);
        String data = this.heroToUpdate();
        FileHandler.updateHero(data);
    }

    public void healHero(){
        this._hero.setHP(this._hero.getHP() + 100);
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

    public Villain getVillain(){
        return this._villain;
    }

    public boolean run(){
        return ((1 + new Random().nextInt(2)) == 1);
    }

    public void doRun(){
        this._hero.setCoordinates(this._heroPreviousPosition);
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