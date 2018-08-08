package mmthombe.model;

import mmthombe.interfaces.ICharacter;

public class Character implements ICharacter {
    protected String _name;
    protected int _level;
    protected int _xp;
    protected int _attack;
    protected int _defence;
    protected int _artifacts;

    public Character(String name, int attack, int defence, int hp, String artifacts)
    {

    }
    
	public String getName() {
		return null;
	}

	public int getLevel() {
		return 0;
	}

	public int getXP() {
		return 0;
	}

	public int getAttack() {
		return 0;
	}

	public int getDefense() {
		return 0;
	}

	public int getHP() {
		return 0;
	}

	public int getArtifacts() {
		return 0;
	}
    
}