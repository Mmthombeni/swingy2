package mmthombe.view.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CreateHeroView extends JFrame{
    private String[] type = {"Doll", "Godd", "Knight", "Princess", "Warrior"};
    private JLabel heroNameLabel = new JLabel();
    private JTextField heroText = new JTextField(10);
    private JLabel typeLabel = new JLabel();
    private JButton submitButton = new JButton("Submit");
    private JButton backButton = new JButton("Back");
    private JComboBox<String> heroTypeComBox = new JComboBox<String>(type);

    public CreateHeroView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setTitle("Create a hero");

        heroNameLabel.setText("Enter Hero Name: ");
        typeLabel.setText("Select the Type: ");
        heroTypeComBox.setSelectedIndex(4);
        heroTypeComBox.addActionListener(heroTypeComBox);

        JPanel createPanel = new JPanel();
        createPanel.setLayout(new FlowLayout());
        createPanel.add(this.heroNameLabel);
        createPanel.add(this.heroText);
        createPanel.add(this.typeLabel);
        createPanel.add(this.heroTypeComBox);
        createPanel.add(this.submitButton);
        createPanel.add(this.backButton);
        this.add(createPanel);
    }

    public String getHeroName(){
        return this.heroText.getText();
    }

    public String getHeroType(){
        return this.heroTypeComBox.getItemAt(this.heroTypeComBox.getSelectedIndex());
    }

    public void setSubmitButtonListner(ActionListener submitButton){
        this.submitButton.addActionListener(submitButton);
    }

    public void setBackButtonListner(ActionListener backButton){
        this.backButton.addActionListener(backButton);
    }
}