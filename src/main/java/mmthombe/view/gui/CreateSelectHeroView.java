package mmthombe.view.gui;

import java.awt.event.ActionListener;

import javax.swing.*;

public class CreateSelectHeroView extends JFrame{
	private JButton createButton = new JButton("Create new hero"); 
    private JButton selectButton = new JButton("Select hero");
    
    public CreateSelectHeroView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 90);
        this.setTitle("Choose or create a player:");

        JPanel selectioPanel = new JPanel();
        selectioPanel.add(this.createButton);
        selectioPanel.add(this.selectButton);
        this.add(selectioPanel);
    }

    public void createButtonListner(ActionListener buttonCreate){
        this.createButton.addActionListener(buttonCreate);
    }

    public void selectButtonListner(ActionListener buttonSelect){
        this.selectButton.addActionListener(buttonSelect);
    }
}