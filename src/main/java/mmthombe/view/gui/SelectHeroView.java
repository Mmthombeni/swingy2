package mmthombe.view.gui;

import java.awt.event.ActionListener;

import javax.swing.*;

public class SelectHeroView extends JFrame{
    private JButton createBtn = new JButton("Create a Hero");
    private JButton playBtn = new JButton("Play");
    private JList<String> heroList;

    public SelectHeroView(String[] heroSelection){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setTitle("Select a hero");

        heroList = new JList<String>(heroSelection);
        JPanel selectPanel = new JPanel();
        selectPanel.add(this.heroList);
        selectPanel.add(this.playBtn);
        selectPanel.add(this.createBtn);
        this.add(selectPanel);
    }
    
    public void setPlayBtnListner(ActionListener playBtn){
        this.playBtn.addActionListener(playBtn);
    }

    public void setCreateBtnListner(ActionListener createBtn){
        this.createBtn.addActionListener(createBtn);
    }

    public int getSelectedHero(){
        return this.heroList.getSelectedIndex();
    }
}