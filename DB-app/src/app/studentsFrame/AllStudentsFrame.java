package app.studentsFrame;

import app.logic.ManagementSystem;
import app.logic.Student;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by dyachkov1997 on 23.04.17.
 */
public class AllStudentsFrame extends JFrame{

    private static final int D_HEIGHT = 700;   // высота окна
    private final static int D_WIDTH = 600;   // ширина окна
    private ManagementSystem ms = null;

    private JTable stdList;



    public AllStudentsFrame() throws Exception {
        // Устанавливаем layout для всей клиентской части формы
        getContentPane().setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        top.add(new JLabel("Все студенты"), BorderLayout.CENTER);

        getContentPane().add(top, BorderLayout.NORTH);

        ms = ManagementSystem.getInstance();



        JPanel table = new JPanel();
        table.setLayout(new BorderLayout());
        table.setBorder(new BevelBorder(BevelBorder.LOWERED));



        stdList = new JTable(1, 5);
        table.add(new JScrollPane(stdList), BorderLayout.CENTER);


        getContentPane().add(table, BorderLayout.CENTER);
        Collection<Student> s = ms.getAllStudents();
        stdList.setModel(new StudentTableModel(new Vector<Student>(s)));

        setBounds(400, 100, 500, 500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
