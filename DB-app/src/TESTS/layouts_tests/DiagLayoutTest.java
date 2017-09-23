package TESTS.layouts_tests;

import javax.swing.*;

/**
 * Created by dyachkov1997 on 16.02.17.
 */
public class DiagLayoutTest extends JFrame{
    public DiagLayoutTest()
    {
        getContentPane().setLayout(new DiagLayout());
        for(int k=0; k<5; k++) {
            getContentPane().add(new JButton(""+k));
        }
        for(int k=0; k<5; k++) {
            getContentPane().add(new JLabel(""+k, JLabel.CENTER));
        }

        setBounds(100,100,600,400);
    }

    public static void main(String[] args)
    {
        DiagLayoutTest flt = new DiagLayoutTest();
        flt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flt.setVisible(true);
    }
}
