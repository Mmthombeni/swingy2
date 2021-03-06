package mmthombe.model;

import mmthombe.enums.Artifacts;
import mmthombe.interfaces.ICharacter;

public class HeroWarrior extends Character implements ICharacter{
    public HeroWarrior(String name, int xp, int attack, int defence, int hp, Artifacts artifacts)
    {
        super(name, xp, attack, defence, hp, artifacts);
    }

    @Override
    public int getAttack() {
        int boost = 0;

        if (this.getArtifact() == Artifacts.WEAPON){
            boost = 82;
        }
        return super.getAttack() + boost;
    }

    @Override
    public int getDefense(){
        int boost = 0;

        if (this.getArtifact() == Artifacts.ARMOR){
            boost = 22;
        }
        return super.getDefense() + boost;
    }

    @Override
    public int getHP() {
        int boost = 0;

        if (this.getArtifact() == Artifacts.HELM){
            boost = 79;
        }
        return super.getHP() + boost;
    }

    public int getArtifacts(){
      return 0;  
    }
}