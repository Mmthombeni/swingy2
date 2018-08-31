package mmthombe.view.gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HeroMeetsVillianView extends JFrame{
    private JButton runButton = new JButton("Run");
    private JButton fightButton = new JButton("Fight");

    public HeroMeetsVillianView(){
        this.setSize(20, 40);
        this.setTitle("You have encounted a villian");

        this.add(runButton);
        this.add(fightButton);
    }

    public void setRunButton(ActionListener runButton){
        this.runButton.addActionListener(runButton);
    }

    public void setFightButton(ActionListener fightButton){
        this.fightButton.addActionListener(fightButton);
    }
}