package mmthombe.model;

import mmthombe.enums.Artifacts;
import mmthombe.interfaces.ICharacter;

public class HeroPrincess extends Character implements ICharacter{
    public HeroPrincess(String name, int xp, int attack, int defence, int hp, Artifacts artifacts)
    {
        super(name, xp, attack, defence, hp, artifacts);
    }

    @Override
    public int getAttack() {
        int boost = 0;

        if (this.getArtifact() == Artifacts.WEAPON){
            boost = 123;
        }
        return super.getAttack() + boost;
    }

    @Override
    public int getDefense(){
        int boost = 0;

        if (this.getArtifact() == Artifacts.ARMOR){
            boost = 93;
        }
        return super.getDefense() + boost;
    }

    @Override
    public int getHP() {
        int boost = 0;

        if (this.getArtifact() == Artifacts.HELM){
            boost = 97;
        }
        return super.getHP() + boost;
    }

    public int getArtifacts(){
      return 0;  
    }
}