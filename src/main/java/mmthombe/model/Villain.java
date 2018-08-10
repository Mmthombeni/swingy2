package mmthombe.model;

import mmthombe.enums.Artifacts;
import mmthombe.interfaces.*;

public class Villain extends Character implements ICharacter{
    Villain(String name, int xp, int attack, int defence, int hp, Artifacts artifacts)
    {
        super(name, xp, attack, defence, hp, artifacts);
    }

	public int getArtifacts() {
		return 0;
	}
}