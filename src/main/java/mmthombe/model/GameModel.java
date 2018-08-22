package mmthombe.model;

import mmthombe.utils.Formulas;

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

        for (int y = 0; y < this._map_size; y++){
            for (int x = 0; x < this._map_size; x++){
                loopCoords.setY(y);
                loopCoords.setX(x);

                if (loopCoords.equals(this._hero.getCoodrinates())){
                    map += "H ";
                }else{
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
            (heroCoords.getX() >= 0 && heroCoords.getX() <= this._map_size) &&
            (heroCoords.getY() >= 0 && heroCoords.getY() <= this._map_size)
        );
    }

    public void heroWonFight(){
        this._hero.setXP(this._hero.getXP() + 50);
    }

    public void heroWonGame(){
        this._hero.setXP(this._hero.getXP() + 95);
        this._hero.setHP(this._HP);
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
}