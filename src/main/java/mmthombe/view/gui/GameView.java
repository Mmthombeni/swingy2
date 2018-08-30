package mmthombe.view.gui;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameView extends JFrame{
    private JTextArea _gameText = new JTextArea();

    public GameView(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Game: The yard battle");
        this.setSize(600,600);

        this._gameText.setEnabled(false);
        this.add(_gameText);
    }
    
    public void setGameText(String text){
        this._gameText.setText(text);
    }

    public void setGameTitle(String title){
        this.setTitle(title);
    }

    public void setKeyListener(KeyListener listener){
        this.addKeyListener(listener);
    }
}