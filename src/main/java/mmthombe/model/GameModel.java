package mmthombe.model;

import mmthombe.utils.Formulas;
import mmthombe.utils.SwingyIO;

public class GameModel{
    private Character _hero;
    private int _map_size = 0;

    public GameModel(Character hero){
        this._hero = hero;
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

    public Character getHero(){
        return this._hero;
    }
}