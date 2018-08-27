package mmthombe.model;

import java.util.Random;

public class FightSimulationModel{
    private Character _hero;
    private Villain _villain;
    private String _simulationText;
    private int _simulations = 0;

    public FightSimulationModel(Character hero, Villain villain){
        this._hero = hero;
        this._villain = villain;
    }

    public boolean nextFight() throws InterruptedException{
        Character attacker;
        Character defender;
        int attack;

        if (this._hero.getHP() > 0 && this._villain.getHP() > 0){
            if (randomBoolean() == true){
                attacker = this._hero;
                defender = this._villain;
            }
            else{
                attacker = this._villain;
                defender = this._hero;
            }
            
            attack = (attacker.getAttack() - defender.getDefense());
            defender.setHP(defender.getHP() - attack);
            this._simulations++;
            Thread.sleep(500);
            this._simulationText = attacker.getName() + " is attacking " + defender.getName() + " with an attack of " + attack;
            return true;
        }
        return false;
    }

    public boolean randomBoolean(){
        return ((1 + new Random().nextInt(2)) == 1);
    }

    public String getSimulationText(){
        return this._simulationText;
    }

    public int getSimulations(){
        return this._simulations;
    }
}