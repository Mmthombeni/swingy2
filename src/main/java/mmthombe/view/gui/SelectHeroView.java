package mmthombe.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mmthombe.utils.SwingyIO;

public class SelectHeroView extends JFrame{
    private JButton createBtn = new JButton("Create a Hero");
    private JButton submitBtn = new JButton("Play");
    private String[] heroSelection = {"potato", "mpho", "sam my fav", "tom as well", "Kuzi ka vakwashe" };
    private JList<String> heroList = new JList<String>(heroSelection);

    public SelectHeroView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setTitle("Select a hero");

        JPanel selectPanel = new JPanel();
        selectPanel.add(this.heroList);
        selectPanel.add(this.submitBtn);
        selectPanel.add(this.createBtn);
        this.add(selectPanel);
    }
    
    public void setSubmitBtnListner(ActionListener submitBtn){
        this.submitBtn.addActionListener(submitBtn);
    }

    public void setCreateBtnListner(ActionListener createBtn){
        this.createBtn.addActionListener(createBtn);
    }
}