package mmthombe.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mmthombe.utils.SwingyIO;

public class CreateSelectHeroView extends JFrame{
	private JButton createButton = new JButton("Create new hero"); 
    private JButton selectButton = new JButton("Select hero");
    
    public CreateSelectHeroView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);

        JPanel selectioPanel = new JPanel();
        selectioPanel.add(createButton);
        selectioPanel.add(selectButton);
        this.add(selectioPanel);
    }

    public void createButtonListner(ActionListener buttonCreate){
        createButton.addActionListener(buttonCreate);
    }

    public void selectButtonListner(ActionListener buttonSelect){
        selectButton.addActionListener(buttonSelect);
    }

}