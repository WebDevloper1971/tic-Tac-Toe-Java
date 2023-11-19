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

    private boolean playerX = false;

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

        for (JButton btn : buttonsArray) {
            btn = new JButton();
            btn.addActionListener(this);
            btn.setBackground(Color.black);
            btn.setBorder(BorderFactory.createLineBorder(Color.white));
            btn.setFocusable(false);
            buttonPanel.add(btn);
        }


        try {
            
            if (random.nextInt(2) == 1) {
                playerX = true;
                Thread.sleep(1000);

                title.setText("Player X's Turn");
                playerX = false;
            }else{

                Thread.sleep(1000);
                title.setText("Player O's Turn");
            }

        }catch (Exception ex) {
            // e.printStackTrace();
            System.out.println("Sleeping Error");
        }


        add(titlePanel,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.CENTER);

        
        setSize(600,600);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    

       

    

    public void checkWinner(){

        if (
            buttonsArray[1].getText() == "X"
            ) {
            
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


    @Override
    public void actionPerformed(ActionEvent e) {
        
        

    }


    public static void main(String[] args) {
        new Main();    
    }
    
}