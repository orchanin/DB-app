package TESTS.layouts_tests;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyachkov1997 on 16.02.17.
 */
public class FlowLayoutTest extends JFrame{
    public FlowLayoutTest()
    {
        getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        for(int k=0; k<20; k++) {
            getContentPane().add(new JButton(""+k));
        }
        setBounds(100,100,400,300);
    }

    public static void main(String[] args)
    {
        FlowLayoutTest flt = new FlowLayoutTest();
        flt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flt.setVisible(true);
    }
}
