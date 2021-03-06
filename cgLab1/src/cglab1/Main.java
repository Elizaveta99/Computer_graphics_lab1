/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cglab1;

import cglab1.Model.HSL;
import cglab1.Model.LAB;
import cglab1.Model.RGB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Hashtable;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        info.setText("");
        Hashtable position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(64, new JLabel("64"));
        position.put(128, new JLabel("128"));
        position.put(192, new JLabel("192"));
        position.put(255, new JLabel("255"));
        jSlider1.setPaintLabels(true);
        jSlider1.setLabelTable(position);
        jSlider2.setPaintLabels(true);
        jSlider2.setLabelTable(position);
        jSlider3.setPaintLabels(true);
        jSlider3.setLabelTable(position);
        position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(90, new JLabel("90"));
        position.put(180, new JLabel("180"));
        position.put(270, new JLabel("270"));
        position.put(360, new JLabel("360"));
        jSlider5.setPaintLabels(true);
        jSlider5.setLabelTable(position);
        position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(25, new JLabel("25"));
        position.put(50, new JLabel("50"));
        position.put(75, new JLabel("75"));
        position.put(100, new JLabel("100"));
        jSlider6.setPaintLabels(true);
        jSlider6.setLabelTable(position);
        jSlider4.setPaintLabels(true);
        jSlider4.setLabelTable(position);
        jSlider7.setPaintLabels(true);
        jSlider7.setLabelTable(position);
        position = new Hashtable();
        position.put(-128, new JLabel("-128"));
        position.put(-64, new JLabel("-64"));
        position.put(0, new JLabel("0"));
        position.put(64, new JLabel("64"));
        position.put(128, new JLabel("128"));
        jSlider8.setPaintLabels(true);
        jSlider8.setLabelTable(position);
        jSlider9.setPaintLabels(true);
        jSlider9.setLabelTable(position);
    }

    private void changeAllModelsFromRGB() {
        try {
            int r = Integer.parseInt(jTextField4.getText());
            int g = Integer.parseInt(jTextField5.getText());
            int b = Integer.parseInt(jTextField6.getText());
            RGB rgb = new RGB(r, g, b);
            rgb.setR(r);
            rgb.setG(g);
            rgb.setB(b);
            // Change HSL
            HSL hsl = rgb.toHSL();          
            jTextField1.setText(((Integer)hsl.getH()).toString());
            jTextField2.setText(((Integer)hsl.getS()).toString());
            jTextField3.setText(((Integer)hsl.getL()).toString());
            
            jSlider5.setValue(((Integer)hsl.getH()));
            jSlider6.setValue(((Integer)hsl.getS()));
            jSlider4.setValue(((Integer)hsl.getL()));
            
            Color color = new Color(Integer.parseInt(jTextField4.getText()), Integer.parseInt(jTextField5.getText()), Integer.parseInt(jTextField6.getText()));
            jTextField11.setBackground(color);
            
            //Change LAB
            LAB lab = rgb.toLAB();          
            jTextField7.setText(((Integer)lab.getL()).toString());
            jTextField8.setText(((Integer)lab.getA()).toString());
            jTextField9.setText(((Integer)lab.getB()).toString());
            
            jSlider7.setValue(((Integer)lab.getL()));
            jSlider8.setValue(((Integer)lab.getA()));
            jSlider9.setValue(((Integer)lab.getB()));
            
            jTextField12.setBackground(color);
            
        }
        catch (NumberFormatException nfe) {
            
        }
    }
    
    private void changeAllModelsFromHSL() {
        try {
            int h = Integer.parseInt(jTextField1.getText());
            double s = Double.parseDouble(jTextField2.getText());
            double l = Double.parseDouble(jTextField3.getText());
            HSL hsl = new HSL(h, s, l);
            
            // Change RGB
            RGB rgb = hsl.toRGB();          
            jTextField4.setText(((Integer)rgb.getRi()).toString());
            jTextField5.setText(((Integer)rgb.getGi()).toString());
            jTextField6.setText(((Integer)rgb.getBi()).toString());
            
            jSlider1.setValue(((Integer)rgb.getRi()));
            jSlider2.setValue(((Integer)rgb.getGi()));
            jSlider3.setValue(((Integer)rgb.getBi()));
            
            Color color = new Color(Integer.parseInt(jTextField4.getText()), Integer.parseInt(jTextField5.getText()), Integer.parseInt(jTextField6.getText()));
            jTextField10.setBackground(color);
            
            //Change LAB
            LAB lab = hsl.toLAB();          
            jTextField7.setText(((Integer)lab.getL()).toString());
            jTextField8.setText(((Integer)lab.getA()).toString());
            jTextField9.setText(((Integer)lab.getB()).toString());
            
            jSlider7.setValue(((Integer)lab.getL()));
            jSlider8.setValue(((Integer)lab.getA()));
            jSlider9.setValue(((Integer)lab.getB()));
            
            jTextField12.setBackground(color);
            
        }
        catch (NumberFormatException nfe) {
            
        }
    }
    
    private void changeAllModelsFromLAB() {
        try {
            double l = Double.parseDouble(jTextField7.getText());
            double a = Double.parseDouble(jTextField8.getText());
            double b = Double.parseDouble(jTextField9.getText());
            LAB lab = new LAB(l, a, b);
            
            // Change RGB
            RGB rgb = lab.toRGB();          
            jTextField4.setText(((Integer)rgb.getRi()).toString());
            jTextField5.setText(((Integer)rgb.getGi()).toString());
            jTextField6.setText(((Integer)rgb.getBi()).toString());
            
            jSlider1.setValue(((Integer)rgb.getRi()));
            jSlider2.setValue(((Integer)rgb.getGi()));
            jSlider3.setValue(((Integer)rgb.getBi()));
            
            Color color = new Color(Integer.parseInt(jTextField4.getText()), Integer.parseInt(jTextField5.getText()), Integer.parseInt(jTextField6.getText()));
            jTextField10.setBackground(color);
            
            //Change HSL
            HSL hsl = lab.toHSL();          
            jTextField1.setText(((Integer)hsl.getH()).toString());
            jTextField2.setText(((Integer)hsl.getS()).toString());
            jTextField3.setText(((Integer)hsl.getL()).toString());
            
            jSlider5.setValue(((Integer)hsl.getH()));
            jSlider6.setValue(((Integer)hsl.getS()));
            jSlider4.setValue(((Integer)hsl.getL()));
            
            jTextField11.setBackground(color);
            
        }
        catch (NumberFormatException nfe) {
            
        }
    }
    
    /**
     * This method is called from within the constructor to  the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jSlider3 = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jSlider4 = new javax.swing.JSlider();
        jSlider5 = new javax.swing.JSlider();
        jSlider6 = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jSlider7 = new javax.swing.JSlider();
        jSlider8 = new javax.swing.JSlider();
        jSlider9 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        info = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jColorChooser1 = new javax.swing.JColorChooser();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Translating between color models application");
        setPreferredSize(new java.awt.Dimension(1135, 740));
        setResizable(false);

        jLabel1.setText("R");

        jLabel2.setText("G");

        jLabel3.setText("B");

        jTextField4.setText("0");

        jTextField5.setText("0");

        jTextField6.setText("0");

        jSlider1.setMajorTickSpacing(100);
        jSlider1.setMaximum(255);
        jSlider1.setMinorTickSpacing(25);
        jSlider1.setValue(128);

        jSlider2.setMaximum(255);
        jSlider2.setValue(128);

        jSlider3.setMaximum(255);
        jSlider3.setValue(128);

        jLabel4.setText("H");

        jLabel5.setText("S");

        jLabel6.setText("L");

        jTextField1.setText("0");

        jTextField2.setText("0");

        jTextField3.setText("0");

        jSlider5.setMaximum(360);
        jSlider5.setValue(180);

        jLabel7.setText("L");

        jLabel8.setText("A");

        jLabel9.setText("B");

        jTextField7.setText("0");

        jTextField8.setText("0");

        jTextField9.setText("0");

        jSlider8.setMaximum(128);
        jSlider8.setMinimum(-128);
        jSlider8.setValue(0);

        jSlider9.setMaximum(128);
        jSlider9.setMinimum(-128);
        jSlider9.setValue(0);

        info.setEditable(false);
        info.setColumns(20);
        info.setRows(5);
        jScrollPane1.setViewportView(info);

        jButton1.setText("Choose color from palette");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Choose color from palette");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Choose color from palette");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("OK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("OK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("OK");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("OK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("OK");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("OK");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel10.setText("Common palette, use only first tab to choose color");

        jTextField10.setBackground(new java.awt.Color(0, 0, 0));

        jTextField11.setBackground(new java.awt.Color(0, 0, 0));

        jTextField12.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField3)
                                .addComponent(jTextField9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(jButton5)
                                    .addComponent(jButton6))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jButton7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jButton8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jButton9)))))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSlider5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton8))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSlider8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSlider9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        info.setText("");
        Color color = jColorChooser1.getColor();
        jTextField10.setBackground(color);
        
        jTextField4.setText(((Integer)color.getRed()).toString());
        jTextField5.setText(((Integer)color.getGreen()).toString());
        jTextField6.setText(((Integer)color.getBlue()).toString());
        
        try {
            jSlider1.setValue(Integer.parseInt(jTextField4.getText()));
            jSlider2.setValue(Integer.parseInt(jTextField5.getText()));
            jSlider3.setValue(Integer.parseInt(jTextField6.getText()));
        }
        catch (NumberFormatException nfe) {
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
        }
        changeAllModelsFromRGB();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        info.setText("");      
        Color color = jColorChooser1.getColor();
        jTextField11.setBackground(color);
        
        jTextField1.setText(((Integer)color.getRed()).toString());
        jTextField2.setText(((Integer)color.getGreen()).toString());
        jTextField3.setText(((Integer)color.getBlue()).toString());
        
        try {
            jSlider5.setValue(Integer.parseInt(jTextField1.getText()));
            jSlider6.setValue(Integer.parseInt(jTextField2.getText()));
            jSlider4.setValue(Integer.parseInt(jTextField3.getText()));
        }
        catch (NumberFormatException nfe) {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        }
        changeAllModelsFromHSL();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        info.setText("");
        Color color = jColorChooser1.getColor();
        jTextField12.setBackground(color);
        
        jTextField7.setText(((Integer)color.getRed()).toString());
        jTextField8.setText(((Integer)color.getGreen()).toString());
        jTextField9.setText(((Integer)color.getBlue()).toString());
        
        try {
            jSlider7.setValue(Integer.parseInt(jTextField7.getText()));
            jSlider8.setValue(Integer.parseInt(jTextField8.getText()));
            jSlider9.setValue(Integer.parseInt(jTextField9.getText()));
        }
        catch (NumberFormatException nfe) {
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField9.setText("");
        }
        changeAllModelsFromLAB();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        info.setText("");
        try {
            jSlider1.setValue(Integer.parseInt(jTextField4.getText()));
            jSlider2.setValue(Integer.parseInt(jTextField5.getText()));
            jSlider3.setValue(Integer.parseInt(jTextField6.getText()));
            Color color = new Color(Integer.parseInt(jTextField4.getText()), Integer.parseInt(jTextField5.getText()), Integer.parseInt(jTextField6.getText()));
            jTextField10.setBackground(color);
        }
        catch (NumberFormatException nfe) {
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
        }
        
        changeAllModelsFromRGB();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        info.setText("");
        try {
            jTextField4.setText(((Integer)jSlider1.getValue()).toString());
            jTextField5.setText(((Integer)jSlider2.getValue()).toString());
            jTextField6.setText(((Integer)jSlider3.getValue()).toString());
            Color color = new Color(Integer.parseInt(jTextField4.getText()), Integer.parseInt(jTextField5.getText()), Integer.parseInt(jTextField6.getText()));
            jTextField10.setBackground(color);
        }
        catch (NumberFormatException nfe) {
            
        }
        changeAllModelsFromRGB();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        info.setText("");
        try {
            jSlider5.setValue(Integer.parseInt(jTextField1.getText()));
            jSlider6.setValue(Integer.parseInt(jTextField2.getText()));
            jSlider4.setValue(Integer.parseInt(jTextField3.getText()));
            Color color = new Color(Integer.parseInt(jTextField1.getText()), Integer.parseInt(jTextField2.getText()), Integer.parseInt(jTextField3.getText()));
            jTextField11.setBackground(color);
        }
        catch (NumberFormatException nfe) {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        }
        changeAllModelsFromHSL();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        info.setText("");
        try {
            jTextField1.setText(((Integer)jSlider5.getValue()).toString());
            jTextField2.setText(((Integer)jSlider6.getValue()).toString());
            jTextField3.setText(((Integer)jSlider4.getValue()).toString());
            Color color = new Color(Integer.parseInt(jTextField1.getText()), Integer.parseInt(jTextField2.getText()), Integer.parseInt(jTextField3.getText()));
            jTextField11.setBackground(color);
        }
        catch (NumberFormatException nfe) {
            
        }
        changeAllModelsFromHSL();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        info.setText("");
        try {
            jSlider7.setValue(Integer.parseInt(jTextField7.getText()));
            jSlider8.setValue(Integer.parseInt(jTextField8.getText()));
            jSlider9.setValue(Integer.parseInt(jTextField9.getText()));
            Color color = new Color(Integer.parseInt(jTextField7.getText()), Integer.parseInt(jTextField8.getText()), Integer.parseInt(jTextField9.getText()));
            jTextField12.setBackground(color);
        }
        catch (NumberFormatException nfe) {
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField9.setText("");
        }
        changeAllModelsFromLAB();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        
        info.setText("");
        try {
            jTextField7.setText(((Integer)jSlider7.getValue()).toString());
            jTextField8.setText(((Integer)jSlider8.getValue()).toString());
            jTextField9.setText(((Integer)jSlider9.getValue()).toString());
            Color color = new Color(Integer.parseInt(jTextField7.getText()), Integer.parseInt(jTextField8.getText()), Integer.parseInt(jTextField9.getText()));
            jTextField12.setBackground(color);
        }
        catch (NumberFormatException nfe) {
            
        }
        changeAllModelsFromLAB();
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea info;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JSlider jSlider4;
    private javax.swing.JSlider jSlider5;
    private javax.swing.JSlider jSlider6;
    private javax.swing.JSlider jSlider7;
    private javax.swing.JSlider jSlider8;
    private javax.swing.JSlider jSlider9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
