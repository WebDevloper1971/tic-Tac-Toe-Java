import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main extends JFrame implements ActionListener{

    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JButton [] buttonsArray = new JButton[9];
    private JLabel title;
    private Random random = new Random();

    private boolean playerX;

    Main(){

        titlePanel = new JPanel();
        buttonPanel = new JPanel();

        title = new JLabel("Tic-Tac-Toe",SwingConstants.CENTER);
        title.setFont(new Font("Ink Free", Font.BOLD, 30));
        

        titlePanel.setBackground(Color.ORANGE);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(this.getWidth(), 50));

        titlePanel.add(title,BorderLayout.CENTER);

        buttonPanel.setBackground(Color.yellow);
        buttonPanel.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            buttonsArray[i] = new JButton();
            buttonsArray[i].setBackground(Color.black);
            buttonsArray[i].setBorder(BorderFactory.createLineBorder(Color.white));
            buttonsArray[i].setFocusable(false);
            buttonsArray[i].addActionListener(this);
            buttonPanel.add(buttonsArray[i]);
        }


       
       


        add(titlePanel,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.CENTER);

        
        setSize(600,600);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


         firstTurn();

        
    }

    
    
       

    @Override
    public void actionPerformed(ActionEvent e) {
        
       
            for (int i = 0; i < buttonsArray.length; i++) {
                if (e.getSource() == buttonsArray[i]) {
                    if (playerX) {
                        if (buttonsArray[i].getText() == "") {
                            buttonsArray[i].setText("X");
                            buttonsArray[i].setForeground(Color.red);
                            buttonsArray[i].setFont(new Font ("Ink Free",Font.BOLD,30));
                            playerX = false;
                            title.setText("Players O's Turn");
                            checkWinner();
                        }

                    }else{

                         if (buttonsArray[i].getText() == "") {
                            buttonsArray[i].setText("O");
                            buttonsArray[i].setForeground(Color.blue);
                            buttonsArray[i].setFont(new Font ("Ink Free",Font.BOLD,30));
                            playerX = true;
                            title.setText("Players X's Turn");
                            checkWinner();
                        }

                    }
                }
            }
        
       
        
        
       

    }

    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Sleeping error");
        }

        if(random.nextInt(2) == 0){
            playerX = true;
            title.setText("Player X's Turn");
        }else{
            playerX = false;
            title.setText("Player O's Turn");
        }
    }

    public void checkWinner(){

        //X wins conditions

        if(
            (buttonsArray[0].getText() == "X") &&
            (buttonsArray[3].getText() == "X") &&
            (buttonsArray[6].getText() == "X") 
            ) {
            Xwins(0, 3, 6); // vertical first row
        }
        
        if(
            (buttonsArray[1].getText() == "X") &&
            (buttonsArray[4].getText() == "X") &&
            (buttonsArray[7].getText() == "X") 
            ) {
            Xwins(1, 4, 7); // vertical second row
        }
        
        if(
            (buttonsArray[2].getText() == "X") &&
            (buttonsArray[5].getText() == "X") &&
            (buttonsArray[8].getText() == "X") 
            ) {
            Xwins(2, 5, 8); // vertical third row
        }
        
        if(
            (buttonsArray[0].getText() == "X") &&
            (buttonsArray[1].getText() == "X") &&
            (buttonsArray[2].getText() == "X") 
            ) {
            Xwins(0, 1, 2); // horizontal first row
        }
        
        if(
            (buttonsArray[3].getText() == "X") &&
            (buttonsArray[4].getText() == "X") &&
            (buttonsArray[5].getText() == "X") 
            ) {
            Xwins(3, 4, 5); // horizontal second row
        }
        
        if(
            (buttonsArray[6].getText() == "X") &&
            (buttonsArray[7].getText() == "X") &&
            (buttonsArray[8].getText() == "X") 
            ) {
            Xwins(6, 7, 8); // horizontal third row
        }
        
        if(
            (buttonsArray[0].getText() == "X") &&
            (buttonsArray[4].getText() == "X") &&
            (buttonsArray[8].getText() == "X") 
            ) {
            Xwins(0, 4, 8); // diagonal left
        }
        
        if(
            (buttonsArray[2].getText() == "X") &&
            (buttonsArray[4].getText() == "X") &&
            (buttonsArray[6].getText() == "X") 
            ) {
            Xwins(2, 4, 6); // diagonal right
        }
        


        // O wins condition

        
        if(
            (buttonsArray[0].getText() == "O") &&
            (buttonsArray[3].getText() == "O") &&
            (buttonsArray[6].getText() == "O") 
            ) {
            Owins(0, 3, 6); // vertical first row
        }
        
        if(
            (buttonsArray[1].getText() == "O") &&
            (buttonsArray[4].getText() == "O") &&
            (buttonsArray[7].getText() == "O") 
            ) {
            Owins(1, 4, 7); // vertical second row
        }
        
        if(
            (buttonsArray[2].getText() == "O") &&
            (buttonsArray[5].getText() == "O") &&
            (buttonsArray[8].getText() == "O") 
            ) {
            Owins(2, 5, 8); // vertical third row
        }
        
        if(
            (buttonsArray[0].getText() == "O") &&
            (buttonsArray[1].getText() == "O") &&
            (buttonsArray[2].getText() == "O") 
            ) {
            Owins(0, 1, 2); // horizontal first row
        }
        
        if(
            (buttonsArray[3].getText() == "O") &&
            (buttonsArray[4].getText() == "O") &&
            (buttonsArray[5].getText() == "O") 
            ) {
            Owins(3, 4, 5); // horizontal second row
        }
        
        if(
            (buttonsArray[6].getText() == "O") &&
            (buttonsArray[7].getText() == "O") &&
            (buttonsArray[8].getText() == "O") 
            ) {
            Owins(6, 7, 8); // horizontal third row
        }
        
        if(
            (buttonsArray[0].getText() == "O") &&
            (buttonsArray[4].getText() == "O") &&
            (buttonsArray[8].getText() == "O") 
            ) {
            Owins(0, 4, 8); // diagonal left
        }
        
        if(
            (buttonsArray[2].getText() == "O") &&
            (buttonsArray[4].getText() == "O") &&
            (buttonsArray[6].getText() == "O") 
            ) {
            Owins(2, 4, 6); // diagonal right
        }
        

      
    }

    public void Xwins(int a,int b,int c){
        buttonsArray[a].setBackground(Color.green);
        buttonsArray[b].setBackground(Color.green);
        buttonsArray[c].setBackground(Color.green);

        for (int i = 0; i < buttonsArray.length; i++) {
            buttonsArray[i].setEnabled(false);
        }

        title.setText("Player X Wins");
    }

    public void Owins(int a,int b,int c){
        buttonsArray[a].setBackground(Color.green);
        buttonsArray[b].setBackground(Color.green);
        buttonsArray[c].setBackground(Color.green);

        for (int i = 0; i < buttonsArray.length; i++) {
            buttonsArray[i].setEnabled(false);
        }

        title.setText("Player O Wins");
    }

    public void draw(){
        title.setText("Draw");
        for (int i = 0; i < 9; i++) {
            buttonsArray[i].setEnabled(false);
        }
    }

    


    public static void main(String[] args) {
        new Main();    
    }
    
}