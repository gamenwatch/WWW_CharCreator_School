/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Jacob
 * Jan 14-?, 2019
 * Creates a character for a role-playing game w/ little user input
 */

//for reader/writer
import java.io.*;
//for dice rolls
import java.util.Random;

public class wwwCreation extends javax.swing.JFrame {
    
    // Java Initialization
    //Writer
    File exportCharDoc1 = new File("CharDoc1.www"); //external document
    FileWriter out;
    BufferedWriter writeFile; 
    //Reader
    File inputOriginDoc = new File("OriginDoc.www");
    FileReader in;
    BufferedReader readFile;
    //Random
    Random diceRoll = new Random();
    
    // Global Variable/Constant Initialization
    String charName; //character name
    int charHealth = 0; //their max health + clear previous
    final int HEALTH_BASE = 70; //minimum health
    final int HEALTH_ROLL = 60; //max that can be rolled to add to the previous
    int charAura = 0; //their max health + clear previous
    final int AURA_BASE = 900; //minimum health
    final int AURA_ROLL = 200; //max that can be rolled to add to the previous
    String charHouse; //the chars house that influences their stats
    int diceResult; //temp placeholder for dice rolls
    
    // Array Initialization
    //All stat names
    final String[] statName = {"Reflex: ","DADA: ","Potions: ","Herbology: ","CI: ","Intelligence: ","Strength: ","Darkness: ","Muggle Understanding: ","Charisma: ","Transfiguration: "};
    //Stat values (filled in later)
    int []statValue = new int [11];
    
    /**
     * Creates new form wwwCreation & enables functionality to the buttons
     */
    public wwwCreation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        characterNameInput = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        subtitleLabel = new javax.swing.JLabel();
        characterNameLabel = new javax.swing.JLabel();
        instructionsScollPane = new javax.swing.JScrollPane();
        instructionsTextArea = new javax.swing.JTextArea();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 204));

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        characterNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                characterNameInputActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Vivaldi", 1, 24)); // NOI18N
        titleLabel.setText("WWW -The Harry Potter Roleplaying Game");

        subtitleLabel.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        subtitleLabel.setText("Quick Character Creator");

        characterNameLabel.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        characterNameLabel.setText("Character Name:");

        instructionsTextArea.setColumns(18);
        instructionsTextArea.setFont(new java.awt.Font("Tekton Pro Ext", 0, 14)); // NOI18N
        instructionsTextArea.setRows(5);
        instructionsTextArea.setTabSize(7);
        instructionsTextArea.setText("Click \"Clear\". Input your character's\nname, then click \"Start\". Your\ncharacter will be displayed in the\nattached file \"CharDoc1\".");
        instructionsScollPane.setViewportView(instructionsTextArea);

        startButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(characterNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(characterNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(subtitleLabel))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(instructionsScollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(subtitleLabel)
                .addGap(18, 18, 18)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(characterNameLabel)
                    .addComponent(characterNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(instructionsScollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // Clear CharDoc1
        clearDocument(out,exportCharDoc1,writeFile);
        System.out.println("Clear Button actions completed"); //for testing
    }//GEN-LAST:event_clearButtonActionPerformed

    private void characterNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_characterNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_characterNameInputActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // CALCULATING / FETCHING CHARACTER INFORMATION
        try {
        //name
        charName = characterNameInput.getText(); //get's information from the GUI
        } catch (Exception e) {
            System.out.println("This is not a valid input.");
            System.err.println("Exception: " + e.getMessage());
        }
        //health
        charHealth = healthRolling(HEALTH_BASE, HEALTH_ROLL, charHealth,diceRoll); // calculates health and outputs
        System.out.println(charHealth);//testing
        //aura
        charAura = auraRolling(AURA_BASE, AURA_ROLL, charAura, diceRoll); // calculates aura and outputs
        System.out.println(charAura);//testing
        //the d10 stats
        statValue = dTenStatRoll(statValue, diceRoll);
        //house
        charHouse = houseRolling(charHouse, diceResult, diceRoll);
        System.out.println("House: "+charHouse);
        //update stats for house
        houseStatUpdate(charHouse, diceRoll, statValue);
        //origin
        
        //export to CharDoc1
        exportToDoc(charName,charHealth,charAura, charHouse, statName, statValue, out, exportCharDoc1, writeFile);
    }//GEN-LAST:event_startButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(wwwCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(wwwCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(wwwCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(wwwCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wwwCreation().setVisible(true);
            }
        });
    }
///////////////////////////////METHODS///////////////////////////////////////////////
    /**
     * Clears the previous information on CharDoc1
     * @param out
     * @param exportCharDoc1 ~ Alters CharDoc1 with the writer
     * @param writeFile
     */
    public void clearDocument(FileWriter out, File exportCharDoc1, BufferedWriter writeFile) {
        try {
            //file writer
            out = new FileWriter(exportCharDoc1); //, true makes it add to the end of the line instead of overwriting it
            writeFile = new BufferedWriter(out);

            //Clear all previous information
            writeFile.write("");
            
            //Close
            writeFile.close();
            out.close();
            System.out.println("Data written to file has been cleared."); //For testing, console mesage

        } catch (IOException e) {
            System.out.println("Problem cleaning file.");
            System.err.println("IOException: " + e.getMessage());
        }

    }
    
    /**
     * Calculates and outputs the characters total health
     * @param HEALTH_BASE ~ Minimum health added to the rolled #
     * @param HEALTH_ROLL ~ Max roll added to the min health
     * @param charHealth ~ the characters total health (calculated from the 2 above)
     * @param diceRoll ~ rolls a dice
     * @return charHealth ~ returned and saved so it can be written to another file later
     */
    public int healthRolling(final int HEALTH_BASE, final int HEALTH_ROLL, int charHealth, Random diceRoll) {
        charHealth = HEALTH_BASE; // =70
        charHealth = (diceRoll.nextInt(HEALTH_ROLL)+1) + charHealth; //70+(1-60)
        
        return charHealth;
    }
    
    /**
     * Calculates and outputs the characters total aura
     * @param AURA_BASE ~ Minimum aura added to the rolled #
     * @param AURA_ROLL ~ Max roll added to the min aura
     * @param charAura ~ the characters total aura (calculated from the 2 above)
     * @param diceRoll ~ rolls a dice
     * @return charAura ~ returned and saved so it can be written to another file later
     */
    public int auraRolling(final int AURA_BASE, final int AURA_ROLL, int charAura, Random diceRoll) {
        charAura = AURA_BASE; // =900
        charAura = (diceRoll.nextInt(AURA_ROLL)+1) + charAura; //70+(10-200)
        
        return charAura;
    }
    
     /**
     * Rolls a d10 for each of the 11 stats
     * @param statValue ~ An array that contains the 11 d10 stats
     * @param diceRoll ~ Rolls a dice
     * @return statValue ~ Return to be exported later
     */
    public int[] dTenStatRoll(int []statValue, Random diceRoll) {

        for (int i = 0; i < 11; i = i+1) // ROLL THE DICE
        {
           statValue[i] = 0; //clear the previous
           statValue[i] = 1 + diceRoll.nextInt(10);
           System.out.println("Roll:"+statValue[i]); //displayed for tetsing
        }

        return statValue;
                
    }
    
    /**
     * Rolls a d4 to generate a house for the character
     * @param charHouse ~ What HP house the char is part of
     * @param diceRoll ~ rolls a dice
     * @param diceResult ~ placeholder for a dice roll
     * @return charHouse ~ Return to be exported later
     */
    public String houseRolling(String charHouse, int diceResult, Random diceRoll) {
        diceResult = (diceRoll.nextInt(4)+1); //4 houses
        switch (diceResult) {
            
            case 1:
                charHouse = "Griffindor"; 
                break;
            case 2:
                charHouse = "Slytherin"; 
                break; 
            case 3:
                charHouse = "Ravenclaw"; 
                break;
            case 4:
                charHouse = "Hufflepuff"; 
                break;    
        }
               
        return charHouse;
    }
    
    /**
     * Adjusts the stats array depending on the characters house
     * @param charHouse ~ What HP house the char is part of
     * @param diceRoll ~ rolls a dice
     * @param statValue ~ An array that contains the 11 d10 stats
     * @return statValue ~ Return to be exported later
     */
    public int[] houseStatUpdate(String charHouse, Random diceRoll, int []statValue) {
        diceResult = (diceRoll.nextInt(4)+1); //4 houses
        switch (charHouse) {
            
            case "Griffindor": //gives +1 DADA & Reflex
                statValue[1] = statValue[1] + 1; //DADA
                statValue[0] = statValue[0] + 1; //Reflex
                break;
            case "Slytherin": //gives +1 Potions & Darkness
                statValue[2] = statValue[2] + 1; //Potions
                statValue[7] = statValue[7] + 1; //Darkness
                break; 
            case "Ravenclaw": //gives +1 Intelligence & Transfiguration
                statValue[5] = statValue[5] + 1; //Intelligence
                statValue[10] = statValue[10] + 1; //Transfiguration
                break;
            case "Hufflepuff": //gives +1 Charisma & Herbology
                statValue[9] = statValue[9] + 1; //Charisma
                statValue[3] = statValue[3] + 1; //Herbology
                break;    
        }
               
        return statValue;
    }
    
    /**
     * Write all generated information to the external document
     * @param charName ~ Export their name
     * @param charHealth ~ Export their health stat
     * @param charAura ~ Export their aura stat
     * @param charHouse ~ Export their Harry Potter house
     * @param statName ~ Export the stats names followed by...
     * @param statValue ~ their respective values
     * @param out
     * @param exportCharDoc1 ~ Alters CharDoc1 with the writer
     * @param writeFile
     */
    public void exportToDoc(String charName,int charHealth,int charAura,String charHouse,String []statName,int []statValue,FileWriter out, File exportCharDoc1, BufferedWriter writeFile) {
        try {
            //file writer
            out = new FileWriter(exportCharDoc1,true);
            writeFile = new BufferedWriter(out);

            //Write all information to file
            writeFile.write("Character Name: "+charName);
            writeFile.newLine();
            writeFile.write("Health: "+charHealth);
            writeFile.newLine();
            writeFile.write("Aura: "+charAura);
            writeFile.newLine();
            
            
            //Close
            writeFile.close();
            out.close();
            System.out.println("Data written to file has been cleared."); //For testing, console mesage

        } catch (IOException e) {
            System.out.println("Problem cleaning file.");
            System.err.println("IOException: " + e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JTextField characterNameInput;
    private javax.swing.JLabel characterNameLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JScrollPane instructionsScollPane;
    private javax.swing.JTextArea instructionsTextArea;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
