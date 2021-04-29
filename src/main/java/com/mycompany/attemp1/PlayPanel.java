package com.mycompany.attemp1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tris1702
 */
public class PlayPanel extends javax.swing.JPanel implements ActionListener{
    int numBlock = 0;
    private int paint[][] = new int [532][532];
    Vector<JPanel> ListJpanel = new Vector<JPanel> ();
    Vector<Integer> vectorBlock = new Vector<Integer> ();
    Vector<Integer> vectorIntegers = new Vector<Integer> ();
    int score;
    private int signal1 = 1, signal2 = 2, cur_signal = signal1;
//    Player player = new Player();
    static int count = 0;
    int x2Countdown = 5;
    int slowCountdown = 5;
    static int delay = 1000;
    int speedup = 0;
    boolean x2 = false, slow = false;
    boolean gameOver = false;
    int dd[] = new int[20];
    Vector<Integer> indexBlock = new Vector<Integer> ();
    Vector<JPanel> queueVector = new Vector<JPanel> ();
    Timer timer = new Timer(delay, this);
//    Timer timer = new Timer(delay, this);
    /**
     * Creates new form MyFrame
     */
    public void renew()
    {
        speedup = 0;
        count = 0;
        delay = 3000;
        timer = new Timer(delay, this);
        score = 0;
        setVisible(true);
        timer.start();
        numBlock = 0;
        
        while (indexBlock.size() > 0) indexBlock.remove(0);
        while (vectorBlock.size() > 0) vectorBlock.remove(0);
        while (vectorIntegers.size() > 0) vectorIntegers.remove(0);
        System.out.println(ListJpanel.size());
        for(int i = 0; i < ListJpanel.size(); i++)
        {
            ListJpanel.elementAt(i).setBackground(new Color(189, 195, 199));
            if (i < 20) dd[i] = 0;
            indexBlock.add(i);
            queueVector.elementAt(i).setBackground(new Color(189, 195, 199));
        }
        Display();
        scoreDisplay.setEditable(false);
        tutor0.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill_adobespark.jpeg"));
        tutor1.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill1_adobespark.png"));
        tutor2.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill2_adobespark.png"));
        tutor3.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill3_adobespark.png"));
        tutor4.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill4_adobespark.png"));

    }
    void Display(){
        for(JPanel block: ListJpanel) block.setVisible(true);
        for(JPanel block: queueVector) block.setVisible(true);
        clearButton.setVisible(true);
        doubleButton.setVisible(true);
    }
    void AddBlock()
    {
        ListJpanel.add(block11);
        ListJpanel.add(block12);
        ListJpanel.add(block13);
        ListJpanel.add(block14);
        ListJpanel.add(block21);
        ListJpanel.add(block22);
        ListJpanel.add(block23);
        ListJpanel.add(block24);
        ListJpanel.add(block31);
        ListJpanel.add(block32);
        ListJpanel.add(block33);
        ListJpanel.add(block34);
        ListJpanel.add(block41);
        ListJpanel.add(block42);
        ListJpanel.add(block43);
        ListJpanel.add(block44);
        ListJpanel.add(block51);
        ListJpanel.add(block52);
        ListJpanel.add(block53);
        ListJpanel.add(block54);
        for(JPanel block: ListJpanel)
            block.setBackground(new Color(189, 195, 199));
    }
    void AddQueue()
    {
        queueVector.add(queue1);
        queueVector.add(queue2);
        queueVector.add(queue3);
        queueVector.add(queue4);
        queueVector.add(queue5);
        queueVector.add(queue6);
        queueVector.add(queue7);
        queueVector.add(queue8);
        queueVector.add(queue9);
        queueVector.add(queue10);
        queueVector.add(queue11);
        queueVector.add(queue12);
        queueVector.add(queue13);
        queueVector.add(queue14);
        queueVector.add(queue15);
        queueVector.add(queue16);
        queueVector.add(queue17);
        queueVector.add(queue18);
        queueVector.add(queue19);
        queueVector.add(queue20);
    }
    /**
     * Creates new form PlayPanel
     */
    public PlayPanel() {
        initComponents();
        score = 0;
        setVisible(true);
        AddBlock();
        AddQueue();
//        timer.start();
        for(int i = 0; i < ListJpanel.size(); i++)
        {
            dd[i] = 0;
            indexBlock.add(i);
        }
        Display();
        scoreDisplay.setEditable(false);
        tutor0.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill_adobespark.jpeg"));
        tutor1.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill1_adobespark.png"));
        tutor2.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill2_adobespark.png"));
        tutor3.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill3_adobespark.png"));
        tutor4.setIcon(new ImageIcon("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/Fill4_adobespark.png"));

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paintArea = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        block11 = new javax.swing.JPanel();
        block12 = new javax.swing.JPanel();
        block13 = new javax.swing.JPanel();
        block14 = new javax.swing.JPanel();
        block21 = new javax.swing.JPanel();
        block22 = new javax.swing.JPanel();
        block23 = new javax.swing.JPanel();
        block24 = new javax.swing.JPanel();
        block31 = new javax.swing.JPanel();
        block32 = new javax.swing.JPanel();
        block33 = new javax.swing.JPanel();
        block34 = new javax.swing.JPanel();
        block41 = new javax.swing.JPanel();
        block42 = new javax.swing.JPanel();
        block43 = new javax.swing.JPanel();
        block44 = new javax.swing.JPanel();
        block51 = new javax.swing.JPanel();
        block52 = new javax.swing.JPanel();
        block53 = new javax.swing.JPanel();
        block54 = new javax.swing.JPanel();
        queue1 = new javax.swing.JPanel();
        queue2 = new javax.swing.JPanel();
        queue3 = new javax.swing.JPanel();
        queue4 = new javax.swing.JPanel();
        queue5 = new javax.swing.JPanel();
        queue6 = new javax.swing.JPanel();
        queue7 = new javax.swing.JPanel();
        queue8 = new javax.swing.JPanel();
        queue9 = new javax.swing.JPanel();
        queue10 = new javax.swing.JPanel();
        queue11 = new javax.swing.JPanel();
        queue12 = new javax.swing.JPanel();
        queue13 = new javax.swing.JPanel();
        queue14 = new javax.swing.JPanel();
        queue15 = new javax.swing.JPanel();
        queue16 = new javax.swing.JPanel();
        queue17 = new javax.swing.JPanel();
        queue18 = new javax.swing.JPanel();
        queue19 = new javax.swing.JPanel();
        queue20 = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        doubleButton = new javax.swing.JButton();
        scoreText = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scoreDisplay = new javax.swing.JTextArea();
        tutor0 = new javax.swing.JButton();
        tutor1 = new javax.swing.JButton();
        tutor2 = new javax.swing.JButton();
        tutor3 = new javax.swing.JButton();
        tutor4 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1215, 937));

        paintArea.setBackground(new java.awt.Color(106, 143, 181));
        paintArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                paintAreaMouseDragged(evt);
            }
        });
        paintArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paintAreaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paintAreaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout paintAreaLayout = new javax.swing.GroupLayout(paintArea);
        paintArea.setLayout(paintAreaLayout);
        paintAreaLayout.setHorizontalGroup(
            paintAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );
        paintAreaLayout.setVerticalGroup(
            paintAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(175, 203, 231));

        javax.swing.GroupLayout block11Layout = new javax.swing.GroupLayout(block11);
        block11.setLayout(block11Layout);
        block11Layout.setHorizontalGroup(
            block11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block11Layout.setVerticalGroup(
            block11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block12Layout = new javax.swing.GroupLayout(block12);
        block12.setLayout(block12Layout);
        block12Layout.setHorizontalGroup(
            block12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block12Layout.setVerticalGroup(
            block12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block13Layout = new javax.swing.GroupLayout(block13);
        block13.setLayout(block13Layout);
        block13Layout.setHorizontalGroup(
            block13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block13Layout.setVerticalGroup(
            block13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block14Layout = new javax.swing.GroupLayout(block14);
        block14.setLayout(block14Layout);
        block14Layout.setHorizontalGroup(
            block14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block14Layout.setVerticalGroup(
            block14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block21Layout = new javax.swing.GroupLayout(block21);
        block21.setLayout(block21Layout);
        block21Layout.setHorizontalGroup(
            block21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block21Layout.setVerticalGroup(
            block21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block22Layout = new javax.swing.GroupLayout(block22);
        block22.setLayout(block22Layout);
        block22Layout.setHorizontalGroup(
            block22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block22Layout.setVerticalGroup(
            block22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block23Layout = new javax.swing.GroupLayout(block23);
        block23.setLayout(block23Layout);
        block23Layout.setHorizontalGroup(
            block23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block23Layout.setVerticalGroup(
            block23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block24Layout = new javax.swing.GroupLayout(block24);
        block24.setLayout(block24Layout);
        block24Layout.setHorizontalGroup(
            block24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block24Layout.setVerticalGroup(
            block24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block31Layout = new javax.swing.GroupLayout(block31);
        block31.setLayout(block31Layout);
        block31Layout.setHorizontalGroup(
            block31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block31Layout.setVerticalGroup(
            block31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block32Layout = new javax.swing.GroupLayout(block32);
        block32.setLayout(block32Layout);
        block32Layout.setHorizontalGroup(
            block32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block32Layout.setVerticalGroup(
            block32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block33Layout = new javax.swing.GroupLayout(block33);
        block33.setLayout(block33Layout);
        block33Layout.setHorizontalGroup(
            block33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block33Layout.setVerticalGroup(
            block33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block34Layout = new javax.swing.GroupLayout(block34);
        block34.setLayout(block34Layout);
        block34Layout.setHorizontalGroup(
            block34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block34Layout.setVerticalGroup(
            block34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block41Layout = new javax.swing.GroupLayout(block41);
        block41.setLayout(block41Layout);
        block41Layout.setHorizontalGroup(
            block41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block41Layout.setVerticalGroup(
            block41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block42Layout = new javax.swing.GroupLayout(block42);
        block42.setLayout(block42Layout);
        block42Layout.setHorizontalGroup(
            block42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block42Layout.setVerticalGroup(
            block42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block43Layout = new javax.swing.GroupLayout(block43);
        block43.setLayout(block43Layout);
        block43Layout.setHorizontalGroup(
            block43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block43Layout.setVerticalGroup(
            block43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block44Layout = new javax.swing.GroupLayout(block44);
        block44.setLayout(block44Layout);
        block44Layout.setHorizontalGroup(
            block44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block44Layout.setVerticalGroup(
            block44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block51Layout = new javax.swing.GroupLayout(block51);
        block51.setLayout(block51Layout);
        block51Layout.setHorizontalGroup(
            block51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block51Layout.setVerticalGroup(
            block51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block52Layout = new javax.swing.GroupLayout(block52);
        block52.setLayout(block52Layout);
        block52Layout.setHorizontalGroup(
            block52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block52Layout.setVerticalGroup(
            block52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block53Layout = new javax.swing.GroupLayout(block53);
        block53.setLayout(block53Layout);
        block53Layout.setHorizontalGroup(
            block53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block53Layout.setVerticalGroup(
            block53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout block54Layout = new javax.swing.GroupLayout(block54);
        block54.setLayout(block54Layout);
        block54Layout.setHorizontalGroup(
            block54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        block54Layout.setVerticalGroup(
            block54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(block11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(block21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(block31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(block41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(block51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(block54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(block14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(block21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(block31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(block41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(block51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(block54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        queue1.setBackground(new java.awt.Color(189, 195, 199));
        queue1.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue1Layout = new javax.swing.GroupLayout(queue1);
        queue1.setLayout(queue1Layout);
        queue1Layout.setHorizontalGroup(
            queue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue1Layout.setVerticalGroup(
            queue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue2.setBackground(new java.awt.Color(189, 195, 199));
        queue2.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue2Layout = new javax.swing.GroupLayout(queue2);
        queue2.setLayout(queue2Layout);
        queue2Layout.setHorizontalGroup(
            queue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue2Layout.setVerticalGroup(
            queue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue3.setBackground(new java.awt.Color(189, 195, 199));
        queue3.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue3Layout = new javax.swing.GroupLayout(queue3);
        queue3.setLayout(queue3Layout);
        queue3Layout.setHorizontalGroup(
            queue3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue3Layout.setVerticalGroup(
            queue3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue4.setBackground(new java.awt.Color(189, 195, 199));
        queue4.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue4Layout = new javax.swing.GroupLayout(queue4);
        queue4.setLayout(queue4Layout);
        queue4Layout.setHorizontalGroup(
            queue4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue4Layout.setVerticalGroup(
            queue4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue5.setBackground(new java.awt.Color(189, 195, 199));
        queue5.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue5Layout = new javax.swing.GroupLayout(queue5);
        queue5.setLayout(queue5Layout);
        queue5Layout.setHorizontalGroup(
            queue5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue5Layout.setVerticalGroup(
            queue5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue6.setBackground(new java.awt.Color(189, 195, 199));
        queue6.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue6Layout = new javax.swing.GroupLayout(queue6);
        queue6.setLayout(queue6Layout);
        queue6Layout.setHorizontalGroup(
            queue6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue6Layout.setVerticalGroup(
            queue6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue7.setBackground(new java.awt.Color(189, 195, 199));
        queue7.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue7Layout = new javax.swing.GroupLayout(queue7);
        queue7.setLayout(queue7Layout);
        queue7Layout.setHorizontalGroup(
            queue7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue7Layout.setVerticalGroup(
            queue7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue8.setBackground(new java.awt.Color(189, 195, 199));
        queue8.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue8Layout = new javax.swing.GroupLayout(queue8);
        queue8.setLayout(queue8Layout);
        queue8Layout.setHorizontalGroup(
            queue8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue8Layout.setVerticalGroup(
            queue8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue9.setBackground(new java.awt.Color(189, 195, 199));
        queue9.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue9Layout = new javax.swing.GroupLayout(queue9);
        queue9.setLayout(queue9Layout);
        queue9Layout.setHorizontalGroup(
            queue9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue9Layout.setVerticalGroup(
            queue9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue10.setBackground(new java.awt.Color(189, 195, 199));
        queue10.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue10Layout = new javax.swing.GroupLayout(queue10);
        queue10.setLayout(queue10Layout);
        queue10Layout.setHorizontalGroup(
            queue10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue10Layout.setVerticalGroup(
            queue10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue11.setBackground(new java.awt.Color(189, 195, 199));
        queue11.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue11Layout = new javax.swing.GroupLayout(queue11);
        queue11.setLayout(queue11Layout);
        queue11Layout.setHorizontalGroup(
            queue11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue11Layout.setVerticalGroup(
            queue11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue12.setBackground(new java.awt.Color(189, 195, 199));
        queue12.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue12Layout = new javax.swing.GroupLayout(queue12);
        queue12.setLayout(queue12Layout);
        queue12Layout.setHorizontalGroup(
            queue12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue12Layout.setVerticalGroup(
            queue12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue13.setBackground(new java.awt.Color(189, 195, 199));
        queue13.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue13Layout = new javax.swing.GroupLayout(queue13);
        queue13.setLayout(queue13Layout);
        queue13Layout.setHorizontalGroup(
            queue13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue13Layout.setVerticalGroup(
            queue13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue14.setBackground(new java.awt.Color(189, 195, 199));
        queue14.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue14Layout = new javax.swing.GroupLayout(queue14);
        queue14.setLayout(queue14Layout);
        queue14Layout.setHorizontalGroup(
            queue14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue14Layout.setVerticalGroup(
            queue14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue15.setBackground(new java.awt.Color(189, 195, 199));
        queue15.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue15Layout = new javax.swing.GroupLayout(queue15);
        queue15.setLayout(queue15Layout);
        queue15Layout.setHorizontalGroup(
            queue15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue15Layout.setVerticalGroup(
            queue15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue16.setBackground(new java.awt.Color(189, 195, 199));
        queue16.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue16Layout = new javax.swing.GroupLayout(queue16);
        queue16.setLayout(queue16Layout);
        queue16Layout.setHorizontalGroup(
            queue16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue16Layout.setVerticalGroup(
            queue16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue17.setBackground(new java.awt.Color(189, 195, 199));
        queue17.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue17Layout = new javax.swing.GroupLayout(queue17);
        queue17.setLayout(queue17Layout);
        queue17Layout.setHorizontalGroup(
            queue17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue17Layout.setVerticalGroup(
            queue17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue18.setBackground(new java.awt.Color(189, 195, 199));
        queue18.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue18Layout = new javax.swing.GroupLayout(queue18);
        queue18.setLayout(queue18Layout);
        queue18Layout.setHorizontalGroup(
            queue18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue18Layout.setVerticalGroup(
            queue18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue19.setBackground(new java.awt.Color(189, 195, 199));
        queue19.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue19Layout = new javax.swing.GroupLayout(queue19);
        queue19.setLayout(queue19Layout);
        queue19Layout.setHorizontalGroup(
            queue19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue19Layout.setVerticalGroup(
            queue19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        queue20.setBackground(new java.awt.Color(189, 195, 199));
        queue20.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout queue20Layout = new javax.swing.GroupLayout(queue20);
        queue20.setLayout(queue20Layout);
        queue20Layout.setHorizontalGroup(
            queue20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        queue20Layout.setVerticalGroup(
            queue20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        clearButton.setBackground(new java.awt.Color(189, 195, 199));
        clearButton.setFont(new java.awt.Font("Ubuntu Light", 1, 24)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        doubleButton.setBackground(new java.awt.Color(45, 63, 80));
        doubleButton.setFont(new java.awt.Font("Ubuntu Light", 1, 24)); // NOI18N
        doubleButton.setForeground(new java.awt.Color(255, 255, 255));
        doubleButton.setText("DOUBLE");
        doubleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleButtonActionPerformed(evt);
            }
        });

        scoreText.setBackground(new java.awt.Color(132, 161, 190));

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 1, 24)); // NOI18N
        jLabel1.setText("SCORE");

        javax.swing.GroupLayout scoreTextLayout = new javax.swing.GroupLayout(scoreText);
        scoreText.setLayout(scoreTextLayout);
        scoreTextLayout.setHorizontalGroup(
            scoreTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
            .addGroup(scoreTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(scoreTextLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        scoreTextLayout.setVerticalGroup(
            scoreTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(scoreTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(scoreTextLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        scoreDisplay.setColumns(20);
        scoreDisplay.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        scoreDisplay.setRows(5);
        scoreDisplay.setText("0\n");
        jScrollPane1.setViewportView(scoreDisplay);

        tutor0.setBackground(new java.awt.Color(182, 187, 192));

        tutor1.setBackground(new java.awt.Color(182, 187, 192));

        tutor2.setBackground(new java.awt.Color(182, 187, 192));

        tutor3.setBackground(new java.awt.Color(182, 187, 192));

        tutor4.setBackground(new java.awt.Color(182, 187, 192));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(queue1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(queue15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(queue13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(queue14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(queue16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(queue17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(queue19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(tutor3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tutor0, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tutor1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tutor2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tutor4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paintArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(doubleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(scoreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(scoreText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 69, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tutor4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tutor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tutor1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tutor0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tutor3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(queue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queue20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(doubleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(paintArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
        );
    }// </editor-fold>//GEN-END:initComponents
    public boolean getGameOver()
    {
        return gameOver;
    }
    private void paintAreaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintAreaMouseDragged
        Graphics g = paintArea.getGraphics();
        g.setColor(Color.BLACK);
//        g.setColor(new Color(0f, 0f, 0f, 12f));
        g.fillOval(evt.getX()-25, evt.getY()-25, 50, 50);
        int x = evt.getX(), y = evt.getY();
        if (x >=0 && x <532 && y >=0 && y <532)
        {
            for(int i = x; i <= x + 50; i++)
                for(int j = y; j <= y + 50; j++)
                    if (i >= 0 && i < 532 && j >= 0 && j < 532)
                        this.paint[i][j] = 255;
        }
    }//GEN-LAST:event_paintAreaMouseDragged

    private void paintAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintAreaMouseReleased
        if (cur_signal == signal1) cur_signal = signal2;
        else cur_signal = signal1;
        try (FileWriter fw = new FileWriter("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/output.txt")) {
            fw.write(Integer.toString(cur_signal));
            fw.write(' ');
            for(int i = 18; i <532; i+=19) {
                for (int j = 18; j < 532; j += 19) {
                    fw.write(Integer.toString(paint[i][j]));
                    fw.write(' ');
                }
            }
            System.out.println("writed");
        } catch (IOException ex) {
        Logger.getLogger(PlayPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
        for(int i = 0; i < 532; i++)
            for(int j = 0; j < 532; j++) paint[i][j] = 0;
        try {
            FileReader fr = new FileReader("/home/tris1702/NetBeansProjects/Attemp1/src/main/java/com/mycompany/attemp1/predict.txt");
            int result = 0, i;
            while ((i = fr.read()) != -1) {
                if (i!= -1) result = i;
            }
            result = result - 48;
            System.out.println(result);
            if (numBlock > 0 && vectorIntegers.lastElement() == result)
            {
                System.out.println(numBlock);
                ListJpanel.elementAt(vectorBlock.lastElement()).setBackground(new Color(189, 195, 199));
                indexBlock.add(vectorBlock.lastElement());
                if (x2) 
                {
                    score += 20;
                    x2Countdown--;
                    if (x2Countdown == 0) 
                    {
                        x2 = false;
                        x2Countdown = 5;
                    }
                }
                else score += 10;
                scoreDisplay.setText(Integer.toString(score));
                dd[vectorBlock.elementAt(vectorBlock.size()-1)] = 0;
                vectorIntegers.remove(vectorIntegers.size()-1);
                vectorBlock.remove(vectorBlock.size()-1);
                queueVector.elementAt(numBlock-1).setBackground(new Color(189, 195, 199));
                numBlock--;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlayPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }//GEN-LAST:event_paintAreaMouseReleased

    private void paintAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintAreaMousePressed
        Graphics g = paintArea.getGraphics();
        g.setColor(Color.BLACK);

//        g.setColor(new Color(0f, 0f, 0f, 12f));
        g.fillOval(evt.getX()-25, evt.getY()-25, 50, 50);
    }//GEN-LAST:event_paintAreaMousePressed
    void GameOverAlert()
    {
        Main.manage.playPanel.setVisible(false);
        Main.manage.confirm.setVisible(true);
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        if (score >= 100) 
        {
            score -= 100;
            scoreDisplay.setText(Integer.toString(score));
            for(int i = 0; i < ListJpanel.size(); i++)
            {
                ListJpanel.elementAt(i).setBackground(new Color(189, 195, 199));
                queueVector.elementAt(i).setBackground(new Color(189, 195, 199));
            }
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    private void doubleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleButtonActionPerformed
        if (score >= 50)
        {
            score -= 50;
            scoreDisplay.setText(Integer.toString(score));
            x2 = true;
        }
    }//GEN-LAST:event_doubleButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel block11;
    private javax.swing.JPanel block12;
    private javax.swing.JPanel block13;
    private javax.swing.JPanel block14;
    private javax.swing.JPanel block21;
    private javax.swing.JPanel block22;
    private javax.swing.JPanel block23;
    private javax.swing.JPanel block24;
    private javax.swing.JPanel block31;
    private javax.swing.JPanel block32;
    private javax.swing.JPanel block33;
    private javax.swing.JPanel block34;
    private javax.swing.JPanel block41;
    private javax.swing.JPanel block42;
    private javax.swing.JPanel block43;
    private javax.swing.JPanel block44;
    private javax.swing.JPanel block51;
    private javax.swing.JPanel block52;
    private javax.swing.JPanel block53;
    private javax.swing.JPanel block54;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton doubleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel paintArea;
    private javax.swing.JPanel queue1;
    private javax.swing.JPanel queue10;
    private javax.swing.JPanel queue11;
    private javax.swing.JPanel queue12;
    private javax.swing.JPanel queue13;
    private javax.swing.JPanel queue14;
    private javax.swing.JPanel queue15;
    private javax.swing.JPanel queue16;
    private javax.swing.JPanel queue17;
    private javax.swing.JPanel queue18;
    private javax.swing.JPanel queue19;
    private javax.swing.JPanel queue2;
    private javax.swing.JPanel queue20;
    private javax.swing.JPanel queue3;
    private javax.swing.JPanel queue4;
    private javax.swing.JPanel queue5;
    private javax.swing.JPanel queue6;
    private javax.swing.JPanel queue7;
    private javax.swing.JPanel queue8;
    private javax.swing.JPanel queue9;
    private javax.swing.JTextArea scoreDisplay;
    private javax.swing.JPanel scoreText;
    private javax.swing.JButton tutor0;
    private javax.swing.JButton tutor1;
    private javax.swing.JButton tutor2;
    private javax.swing.JButton tutor3;
    private javax.swing.JButton tutor4;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Random gen = new Random();
        if (indexBlock.isEmpty())
        {
            gameOver = true;
            GameOverAlert();
//            return;
        }
        else
        {
            int index = gen.nextInt(indexBlock.size());
            int block = indexBlock.elementAt(index);
            while (dd[block] == 1)
            {
                index = gen.nextInt(indexBlock.size());
                block = indexBlock.elementAt(index); 
            }
            indexBlock.remove(index);
            int ansBlock = gen.nextInt(5);
            if (ansBlock == 0) 
            {
                ListJpanel.elementAt(block).setBackground(new Color(238, 238, 0));
                queueVector.elementAt(this.numBlock).setBackground(new Color(238, 238, 0));
            }
            else 
                if (ansBlock == 1) 
                {
                    ListJpanel.elementAt(block).setBackground(new Color(191, 85, 236));
                    queueVector.elementAt(this.numBlock).setBackground(new Color(191, 85, 236));
                }
                else 
                    if (ansBlock == 2) 
                    {
                        ListJpanel.elementAt(block).setBackground(new Color(41, 241, 195));
                        queueVector.elementAt(this.numBlock).setBackground(new Color(41, 241, 195));
                    }
                    else 
                        if (ansBlock == 3) 
                        {
                            ListJpanel.elementAt(block).setBackground(new Color(242, 38, 19));
                            queueVector.elementAt(this.numBlock).setBackground(new Color(242, 38, 19));
                        }
                        else 
                        {
                            ListJpanel.elementAt(block).setBackground(new Color(34, 167, 240));
                            queueVector.elementAt(this.numBlock).setBackground(new Color(34, 167, 240));
                        }
            numBlock++;
            vectorBlock.add(block);
            count++;
            if (count == 2)
            {
                count = 0;
                speedup -= 100;
                if (delay + speedup >= 200)
                    timer.setDelay(delay + speedup);
            }
            vectorIntegers.add(ansBlock);
        }
    }
}
