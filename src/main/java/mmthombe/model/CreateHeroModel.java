package mmthombe.model;

import java.util.Random;

import mmthombe.enums.Artifacts;
import mmthombe.factories.HeroFactory;

public class CreateHeroModel{
    private String _heroName;
    private String _heroType;

    public void setHeroName(String heroName){
        this._heroName = heroName;
    }

    public void setHeroType(String heroType){
        this._heroType = heroType;
    }

    public Character getHero(){
       return HeroFactory.newHero(this._heroName, this._heroType, "0", "402", "160", "5000", getRandomArtifact().toString());
    }

    public static Artifacts getRandomArtifact(){
        String[] artifacts = {"WEAPON", "ARMOR", "HELM"};
        Random random = new Random();
        String artifact = artifacts[random.nextInt(artifacts.length)];
        
        return Artifacts.valueOf(artifact.toUpperCase());
    }
}