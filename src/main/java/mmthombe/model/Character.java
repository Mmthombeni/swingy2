package mmthombe.model;

import mmthombe.enums.Artifacts;

public class Character {
    protected String _name;
    protected int _xp;
    protected int _attack;
    protected int _defence;
	protected Artifacts _artifact;
	protected int _hp;

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
		return 0;
	}

	public int getXP() {
		return this._xp;
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
}