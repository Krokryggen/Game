package adventure;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
//import javafx.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Adventure {
    
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, imagePanel, healthBarPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, imageLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    JButton startButton, choice1, choice2, choice3, choice4, musicButton;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing, shovel, torch;
    String weapon, position, tavernMusic, musicOnOff;
    ImageIcon image;
    Random rand = new Random();
    ButtonHandler bHandler = new ButtonHandler();
    Music mu = new Music();
    
    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    
    public class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
       
        String clickedButton = event.getActionCommand();
        
        switch(clickedButton){
            case "musicB":
                if(musicOnOff.equals("off")){
                    mu.setFile(tavernMusic);
                    mu.play();
                    mu.loop();
                    musicOnOff = "on";
                }
                else if(musicOnOff.equals("on")){
                    mu.stop();
                }
                
        }
    
    }
    }
    
    
    
    public static void main(String[] args) {
        new Adventure();
        
    }
    
    public Adventure(){
        
        window = new JFrame();
        window.setSize(800, 600 );
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        
        healthBarPanel = new JPanel();
        healthBarPanel.setBounds(playerHP, playerHP, playerHP, playerHP);
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150 );
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.addActionListener(bHandler);
        startButton.setActionCommand("musicB");
        startButton.setFocusPainted(false);
        
        musicButton = new JButton("");
        musicButton.setFocusPainted(false);
        musicButton.addActionListener(bHandler);
        
       
        
        tavernMusic = ".//res//Eight_Bit_Village_Loop.wav";
        
        musicOnOff = "off";
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        
    }
    
    public void createGameScreen(){
        
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(50, 350, 430, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        
        mainTextArea = new JTextArea("Hello");
        mainTextArea.setBounds(50, 350, 430, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);
        
       choiceButtonPanel = new JPanel();
       choiceButtonPanel.setBounds(500, 350, 250, 150);
       choiceButtonPanel.setBackground(Color.black);
       choiceButtonPanel.setLayout(new GridLayout(4,1));
       con.add(choiceButtonPanel);
       
       choice1 = new JButton("Choice 1");
       choice1.setBackground(Color.black);
       choice1.setForeground(Color.white);
       choice1.setFont(normalFont);
       choice1.setFocusPainted(false);
       choice1.addActionListener(choiceHandler);
       choice1.setActionCommand("c1");
       choiceButtonPanel.add(choice1);
       
       choice2 = new JButton("Choice 2");
       choice2.setBackground(Color.black);
       choice2.setForeground(Color.white);
       choice2.setFont(normalFont);
       choice2.setFocusPainted(false);
       choice2.addActionListener(choiceHandler);
       choice2.setActionCommand("c2");
       choiceButtonPanel.add(choice2);
       
       choice3 = new JButton("Choice 3");
       choice3.setBackground(Color.black);
       choice3.setForeground(Color.white);
       choice3.setFont(normalFont);
       choice3.setFocusPainted(false);
       choice3.addActionListener(choiceHandler);
       choice3.setActionCommand("c3");
       choiceButtonPanel.add(choice3);
       
       choice4 = new JButton("Choice 4");
       choice4.setBackground(Color.black);
       choice4.setForeground(Color.white);
       choice4.setFont(normalFont);
       choice4.setFocusPainted(false);
       choice4.addActionListener(choiceHandler);
       choice4.setActionCommand("c4");
       choiceButtonPanel.add(choice4);
       
       playerPanel = new JPanel();
       playerPanel.setBounds(500, 100, 270, 50);
       playerPanel.setBackground(Color.black);
       playerPanel.setLayout(new GridLayout(2,2));
       con.add(playerPanel);
       
       hpLabel = new JLabel("HP: ");
       hpLabel.setFont(normalFont);
       hpLabel.setForeground(Color.white);
       playerPanel.add(hpLabel);
       hpLabelNumber = new JLabel();
       hpLabelNumber.setFont(normalFont);
       hpLabelNumber.setForeground(Color.white);
       playerPanel.add(hpLabelNumber);
       weaponLabel = new JLabel("Weapon:");
       weaponLabel.setFont(normalFont);
       weaponLabel.setForeground(Color.white);
       playerPanel.add(weaponLabel);
       weaponLabelName = new JLabel();
       weaponLabelName.setFont(normalFont);
       weaponLabelName.setForeground(Color.white);
       playerPanel.add(weaponLabelName);
       
       imagePanel = new JPanel();
       imagePanel.setBounds(50, 50, 400, 260);
       imagePanel.setBackground(Color.black);
       
       imageLabel = new JLabel();
       
       image = new ImageIcon(".//res//Gate.png");
       
       imageLabel.setIcon(image);
       imagePanel.add(imageLabel);
       
       con.add(imagePanel);
       playerSetup();
       
       
    }
    
    public void playerSetup(){
        
        playerHP = 15;
        monsterHP = 20;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText(""+playerHP);
        
        townGate();
    }
    
    public void townGate(){
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//Guard.png");
        imageLabel.setIcon(image);
        
        position = "townGate";
        mainTextArea.setText("You are at the Town Gate. \nA guard is standing in front of you! \n\nWhat do you want to do?");
        
        choice1.setText("Talk to the Guard");
        choice2.setText("Attack the Guard");
        choice3.setText("Leave");
        choice4.setText("");
        
        imagePanel.setVisible(true);
        
        
    }
    
    public void talkGuard(){
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//Guard.png");
        imageLabel.setIcon(image);
        
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello there stranger. \nI'm Sorry, but you can't enter our town");
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
        
    }
    
    public void attackGuard(){
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//AngryGuard.png");
        imageLabel.setIcon(image);
        
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey! What the hell!? \n The guard knocks you out. \n(you take 2 damage)");
        playerHP = playerHP -2;
        hpLabelNumber.setText(""+playerHP);
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
        
    }
    
    public void crossRoad(){
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//CrossRoad2.png");
        imageLabel.setIcon(image);
        
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad \nFrom here you can go East, West or \nNorth \nSouth is back to the Town Gate");
        
        choice1.setText("Go East");
        choice2.setText("Go West");
        choice3.setText("Go North");
        choice4.setText("Go South");
    }
    
    public void east(){
        
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//LongSword.png");
        imageLabel.setIcon(image);
        
        position = "east";
        mainTextArea.setText("You walked into a forest and\n found a Long Sword! \n\n(You obtained Long Sword)");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);
        
        choice1.setText("Go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void east2(){
        
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//NoLongSword.png");
        imageLabel.setIcon(image);
        
        position = "east2";
        mainTextArea.setText("You walked into the forest");
        
        
        choice1.setText("Go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void west(){
        
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//Goblin.png");
        imageLabel.setIcon(image);
        
        position = "west";
        //Kan legge inn monster sin HP her, om jeg vil ha ny per monsterr
        mainTextArea.setText("You encounter a Goblin!");
        
        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void west2(){
        
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//NoGoblin.png");
        imageLabel.setIcon(image);
        
        position = "west2";
        //Kan legge inn monster sin HP her, om jeg vil ha ny per monsterr
        mainTextArea.setText("The forest continues");
        
        choice1.setText("Go Forward");
        choice2.setText("Go Back");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void north(){
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//HealingWell.png");
        imageLabel.setIcon(image);
        
        position = "north";
        mainTextArea.setText("There is a healing well! \nYou drink and restore 2 HP!\n\n (You restore 2 points of health)");
        playerHP = playerHP +2;
        hpLabelNumber.setText(""+playerHP);
        
        choice1.setText("Go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void deepForest(){
        
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//DeepForest.png");
        imageLabel.setIcon(image);
        
        position = "deepForest";
        mainTextArea.setText("You walked into a deep forest. \nTo your Right is a big cave\nTo your Left is a small cabin");
        
        
        choice1.setText("Go Right");
        choice2.setText("Go Left");
        choice3.setText("Go Back");
        choice4.setText("");
    }
    
    public void cabinOutside(){
        
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//Cabin.png");
        imageLabel.setIcon(image);
        
        position = "cabinOutside";
        mainTextArea.setText("You see an old and run-down cabin. \n It looks abandoned. \nThere is a shovel leaning against the \nwall\n(You obtained a shovel)");
        
        shovel = 1;
        
        choice1.setText("Go Inside");
        choice2.setText("Go Back");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void cabin(){
        
        imagePanel.setBounds(50, 50, 400, 280);
        //image = new ImageIcon(".//res//LongSword.png");
        //imageLabel.setIcon(image);
        
        position = "cabin";
        mainTextArea.setText("The floor creaks as you enter. \nNo one could possibly still live here");
        
        
        choice1.setText("");
        choice2.setText("Go Back");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void caveOutside(){
        
        imagePanel.setBounds(50, 50, 400, 280);
        image = new ImageIcon(".//res//CaveOutside.png");
        imageLabel.setIcon(image);
        
        position = "caveOutside";
        mainTextArea.setText("You come across a big cave opening \n Going in would be dangerous without a \ntorch");
        
        
        choice1.setText("Go Inside");
        choice2.setText("Go Back");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void cave(){
        
        //imagePanel.setBounds(50, 50, 400, 280);
        //image = new ImageIcon(".//res//LongSword.png");
        //imageLabel.setIcon(image);
        
        position = "cave";
        mainTextArea.setText("The cave is dark, \nbut the torch gives some light \n It smells bad");
        
        
        choice1.setText("Go Further");
        choice2.setText("Go Back");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void fight(){
       position = "fight";
       mainTextArea.setText("MonsterHP: " + monsterHP + "\n\nWhat do you want to do?");
       choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }
    public void playerAttack(){
       position = "playerAttack";
       
       int playerDamage = 0;
       if(weapon.equals("Knife")){
       playerDamage = rand.nextInt(3+1);
       }
       else if(weapon.equals("Long Sword")){
           playerDamage = rand.nextInt(7 +1);
       }
       
       mainTextArea.setText("You attacked the monster and gave \n" + playerDamage + " damage!");
       
       monsterHP = monsterHP - playerDamage;
       
       choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void monsterattack(){
        
        
        position = "monsterAttack";
        
        int monsterDamage = 0;
        
        monsterDamage = rand.nextInt(4+1);
        
        mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
        
        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText(""+playerHP);
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void loose(){
    position = "loose";
    
    mainTextArea.setText("You are dead!\n\n<GAME OVER>");
    
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    
    public void win(){
        position = "win";
        
        mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
        
        silverRing = 1;
        choice1.setText("Go Forward");
        choice2.setText("Go Back");
        choice3.setText("");
        choice4.setText("");
    
    }
    
    public void happyGuard(){
    position = "happyGuard";
    
    mainTextArea.setText("Guard: Oh, you killed the Goblin!?\n Thank you so much! \n Here is a torch, as a reward for your \nbravery! \n\n(You obtained a torch)");
    
        torch = 1;
    
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }
    
    
    
    public class TitleScreenHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            
            createGameScreen();
        }

        
    }
    public class ChoiceHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            
            String yourChoice = event.getActionCommand();
            
            switch(position){
                case "townGate":
                    switch(yourChoice){
                        case "c1": 
                            if(silverRing ==1){
                                happyGuard();
                            }
                            else{
                                talkGuard(); 
                            }
                            break;
                        case "c2": attackGuard(); break;
                        case "c3": crossRoad(); break;
                        case "c4": break;
                        
                    }
                    break;
                case "talkGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "attackGuard":
                    switch(yourChoice){
                        case "c1": 
                        if(playerHP>0){
                                townGate();
                            }
                            else {
                                loose(); 
                            }
                    }
                    break;
                case "crossRoad":
                    switch(yourChoice){
                        case "c1": 
                            if(weapon == "Long Sword"){
                                east2();
                            }
                    else {
                                east();
                            }
                            break;
                        case "c2": west();
                        if(silverRing == 1){
                                west2();
                            }
                    else {
                                west();
                            }
                        break;
                        case "c3": north(); break;
                        case "c4":townGate(); break;
                    }
                    break;
                case "north":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "east":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "west":
                    switch(yourChoice){
                        case "c1": fight();break; 
                        case "c2": crossRoad(); break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                    case "west2":
                    switch(yourChoice){
                        case "c1": deepForest();break; 
                        case "c2": crossRoad(); break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                    
                    case "deepForest":
                    switch(yourChoice){
                        case "c1": caveOutside();break; 
                        case "c2": cabinOutside(); break;
                        case "c3": west2();
                        case "c4": break;
                    }
                    break;
                case "fight":
                    switch(yourChoice){
                        case "c1": playerAttack(); break;
                        case "c2": crossRoad(); break;
                    }
                    break;
                case "playerAttack":
                    switch(yourChoice){
                        case "c1": 
                            if(monsterHP<1){
                               win(); 
                            }
                            else{
                            monsterattack(); 
                            }
                            break;
                            
                    }
                    break;
                case "monsterAttack":
                    switch(yourChoice){
                        case "c1": 
                            if(playerHP<1){
                                loose();
                            }
                            else {
                                fight(); 
                            }
                            break;
                    }
                    break;
                case "win":
                    switch(yourChoice){
                        case "c1": deepForest(); break; 
                        case "c2": crossRoad(); break;
                    }
                    break;
                    case "east2":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                    case "cabinOutside":
                    switch(yourChoice){
                        case "c1": cabin(); break;
                        case "c2": deepForest();break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                    
                    case "cabin":
                    switch(yourChoice){
                        case "c1": break;
                        case "c2": cabinOutside();break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                    
                    case "caveOutside":
                    switch(yourChoice){
                        case "c1": 
                            if(torch ==1){
                                cave();
                            }
                            else{
                                caveOutside();
                            }
                            break;
                        case "c2": deepForest();break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                    case "cave":
                    switch(yourChoice){
                        case "c1": break;
                        case "c2": caveOutside(); break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                   case "happyGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    } 
                    
                }
            }
        }
    }

        
    

