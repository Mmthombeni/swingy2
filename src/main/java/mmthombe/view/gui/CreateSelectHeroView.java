package mmthombe.view.gui;

import javax.swing.*;

public class CreateSelectHeroView extends JFrame{
	private JButton createButton = new JButton("Create new hero"); 
    private JButton selectButton = new JButton("Select hero");
    
    public CreateSelectHeroView(){   
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);

        JPanel selectioPanel = new JPanel();
        selectioPanel.add(createButton);
        selectioPanel.add(selectButton);
        this.add(selectioPanel);
    }
}