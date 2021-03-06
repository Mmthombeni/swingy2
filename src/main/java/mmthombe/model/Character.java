package mmthombe.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mmthombe.enums.Artifacts;
import mmthombe.utils.Formulas;


public class Character {
	@NotNull
	private String _name;
	
	@Min(0)
	private int _xp;
	
	@Min(0)
	private int _attack;
	
	@Min(0)
	private int _defence;
	
	@NotNull
	private Artifacts _artifact;
	
	@Min(0)
	private int _hp;
	private Coordinates _coordinates;

    public Character(String name, int xp, int attack, int defence, int hp, Artifacts artifact)
    {
		this._name = name;
		this._xp = xp;
		this._attack = attack;
		this._defence = defence;
		this._hp = hp;
		this._artifact = artifact;
	}
    
	public String getName() {
		return this._name;
	}

	public int getLevel() {
		return Formulas.GetLevel(this._xp);
	}

	public int getXP() {
		return this._xp;
	}

	public void setXP(int xp){
		this._xp = xp;
	}

	public int getAttack() {
		return this._attack;
	}

	public int getDefense() {
		return this._defence;
	}

	public int getHP() {
		return this._hp;
	}

	public void setHP(int HP){
		this._hp = HP;
	}

	public Artifacts getArtifact(){
		return this._artifact;
	}

	public void setCoordinates(Coordinates coordinates){
		this._coordinates = coordinates;
	}

	public Coordinates getCoodrinates(){
		return this._coordinates;
	}

	public void setArtifact(Artifacts artifact){
		this._artifact = artifact;
	}
}