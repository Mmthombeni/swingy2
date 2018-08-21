package mmthombe.model;

public class Coordinates{
    private int _y;
    private int _x;

    public Coordinates(){
        this._x = 0;
        this._y = 0;
    }

    public Coordinates(int y, int x){
        this._x = x;
        this._y = y;
    }

    public void setY(int y){
        this._y = y;
    }

    public void setX(int x){
        this._x = x;
    }

    public int getY(){
        return this._y;
    }

    public int getX(){
        return this._x;
    }

    public boolean equals(Coordinates coord){
        return ((this._y == coord.getY()) && (this._x == coord.getX()));
    }
}