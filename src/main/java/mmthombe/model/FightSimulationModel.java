package mmthombe.model;

import java.util.Random;

public class FightSimulationModel{
    private Character _hero;
    private Villain _villain;
    private String _simulationText;
    private int _simulations = 0;
    private boolean _isSleep;

    public FightSimulationModel(Character hero, Villain villain, boolean isSleep){
        this._hero = hero;
        this._villain = villain;
        this._isSleep = isSleep;
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
            
            attack = isAttackPositive(attacker.getAttack() - defender.getDefense());
            this._simulations++;
            this._simulationText = attacker.getName() + " " + attacker.getHP() + "HP is attacking " + defender.getName() + " " + defender.getHP() + "HP with an attack of " + attack;
            defender.setHP(defender.getHP() - attack);
            if (this._isSleep == true)
                Thread.sleep(500);
            return true;
        }
        return false;
    }

    private int isAttackPositive(int attack){
       return (attack < 0 ? 0 : attack); 
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