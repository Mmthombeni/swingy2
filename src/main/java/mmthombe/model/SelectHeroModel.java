package mmthombe.model;

import java.util.List;

import mmthombe.factories.HeroFactory;

public class SelectHeroModel{
    List<Character> _heroList = null;

    public SelectHeroModel(){
        this._heroList = HeroFactory.HeroList();
    }

    public String[] getHeros(){
        String[] heros = new String[this._heroList.size()];
        int i = 0;

        for (Character hero : this._heroList) {
            String infor = hero.getName() + " " + hero.getClass().getSimpleName().substring(4) + " " + hero.getLevel() + " " + hero.getArtifact();
            heros[i] = infor;
            i++;
        }
        return heros;
    }

    public List<Character> getHeroList(){
            return this._heroList;
    }

    public Character getSelectedHero(int index){
        try {
            return this._heroList.get(index);
        } catch (Exception e) {
            return null;
        }
    }
}