package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/26/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class FifteenPuzzle2 extends JPanel {
    public static JMenuItem newItem;
    public static javax.swing.Timer t;
    JButton[][] jb = new JButton[4][4];
    static int minute, second;
    static JFrame jf;

    public FifteenPuzzle2() {
        setLayout(new GridLayout(4, 4));

        int i, j, k;
        init(true);
        for (i = 0; i < jb.length; i++)
            for (j = 0; j < jb[i].length; j++)
                jb[i][j].addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String command = e.getActionCommand();
                                String[] indices = command.split(" ");
                                int i = Integer.parseInt(indices[0]);
                                int j = Integer.parseInt(indices[1]);
                                int[] r = {i - 1, i, i + 1, i};
                                int[] c = {j, j + 1, j, j - 1};
                                for (int k = 0; k < 4; k++) {
                                    if (r[k] >= 0 && r[k] < 4 && c[k] >= 0 && c[k] < 4){
                                        JButton button = jb[r[k]][c[k]];
                                        if (button.getText().equals("")) {
                                            button.setText(jb[i][j].getText());
                                            jb[i][j].setText("");
                                        }
                                    }
                                }
                            }
                        });

        newItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        init(false);
                    }
                }
        );
    }
    public void init(boolean firstTime) {
        ArrayList a = new ArrayList();
        int i, j, k;
        for (i = 1; i <= 15; i++)
            a.add(new Integer(i));
        Collections.shuffle(a);
        a.add(new Integer(0));

        k = 0;
        for (i = 0; i < jb.length; i++)
            for (j = 0; j < jb[i].length; j++) {
                Integer val = (Integer)a.get(k++);
                if (firstTime) {
                    jb[i][j] = new JButton(val.intValue() + "");
                    jb[i][j].setActionCommand(i + " " + j);
                    add(jb[i][j]);
                }
                else
                    jb[i][j].setText(val.intValue() + "");
            }
        jb[3][3].setText("");
        minute = 0;
        second = 0;
    }

    public static void main(String[] args) {
        jf = new JFrame();
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        JMenuBar jmb = new JMenuBar();
        jf.setJMenuBar(jmb);

        JMenu gameMenu = new JMenu("Game");
        jmb.add(gameMenu);

        newItem = new JMenuItem("New");
        gameMenu.add(newItem);

        gameMenu.addSeparator();


        FifteenPuzzle2 fp = new FifteenPuzzle2();
        jf.setContentPane(fp);

        final DecimalFormat dc = new DecimalFormat("00");

        t = new javax.swing.Timer(
                1000,
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jf.setTitle(dc.format(minute) + ":" + dc.format(second));
                        second++;
                        if (second >= 60) {
                            second %= 60;
                            minute++;
                        }
                    }
                }
        );
        jf.pack();
        jf.setVisible(true);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        int w=(int)d.getWidth();
        int h=(int)d.getHeight();
        jf.setLocation((int)(w/2-jf.getWidth()/2),(int)(h/2-jf.getHeight()/2));
        t.start();
    }
}
