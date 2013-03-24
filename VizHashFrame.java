/* Copyright 2011 Edouard Garnier de Labareyre
 *
 * This file is part of ViszHash4j
 * Visual Hash implementation in java
 * This is free software under the zlib/libpng licence
 * http://www.opensource.org/licenses/zlib-license.php
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * This frame includes a VizHashPanel + a text field to test the VizHash4j lib
 */
public class VizHashFrame extends JFrame{
    
    public JTextField message_field = new JTextField();
    private JButton compute_button = new JButton("Go");
    private JLabel message_label = new JLabel();
    private VizHashPanel vizhash_panel;

    public VizHashFrame(){

        vizhash_panel = new VizHashPanel();
        vizhash_panel.setValue("hi");

        message_field.setFont(new Font("Serial", Font.BOLD, 22));
        message_field.setHorizontalAlignment(JTextField.CENTER);
        message_field.setText("hi");
        message_field.setCaretPosition(2);
        message_field.setSelectionStart(0);
        message_field.setSelectionEnd(2);
        message_field.setToolTipText("Type the message to VizHash here");
        message_field.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar()=='\n'){
                    String message=message_field.getText().trim();
                    if(vizhash_panel.setValue(message)){
                        message_label.setText("VizHash for \""+message+"\"");
                    }
                }
            }
        });

        message_label.setText("VizHash for \"hi\"");
        compute_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vizhash_panel.setValue(message_field.getText());
            }
        });

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setPreferredSize(new Dimension(400,35));
        bottom.add(message_field,BorderLayout.CENTER);
        bottom.add(compute_button,BorderLayout.EAST);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(message_label,BorderLayout.NORTH);
        c.add(vizhash_panel,BorderLayout.CENTER);
        c.add(bottom,BorderLayout.SOUTH);


        this.setSize(400,440);
        this.setTitle("VizHash demo");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Main function for demo only
     */
    public static void main(String[] args) {
        new VizHashFrame().setVisible(true);
    }
}
