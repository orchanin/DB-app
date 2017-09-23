package app.studentsFrame;

import app.logic.Group;
import app.logic.ManagementSystem;
import app.logic.Student;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Vector;

/**
 * Created by dyachkov1997 on 20.02.17.
 */
public class StudentTableModel extends AbstractTableModel {
    // Сделаем хранилище для нашего списка студентов

    private Vector students;

    ManagementSystem ms = ManagementSystem.getInstance();

    Vector<Group> gr = new Vector<Group>(ms.getGroups());


    // Модель при создании получает список студентов
    public StudentTableModel(Vector students) throws Exception {
        this.students = students;
    }

    // Количество строк равно числу записей
    public int getRowCount() {
        if (students != null) {
            return students.size();
        }
        return 0;
    }

    // Количество столбцов - 4. Фамилия, Имя, Отчество, Дата рождения
    public int getColumnCount() {
        return 5;
    }
    //TODO изменить айди группы на имя группы (Добавить в мэнэджмнт систем метод получения группы по айди)

    // Вернем наименование колонки
    public String getColumnName(int column) {
        String[] colNames = {"Фамилия", "Имя", "Отчество", "Дата", "Группа"};
        return colNames[column];
    }

    // Возвращаем данные для определенной строки и столбца
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (students != null) {
            // Получаем из вектора студента
            Student st = (Student) students.get(rowIndex);
            // В зависимости от колонки возвращаем имя, фамилия и т.д.
            switch (columnIndex) {
                case 0:
                    return st.getSurName();
                case 1:
                    return st.getFirstName();
                case 2:
                    return st.getPatronymic();
                case 3:
                    return DateFormat.getDateInstance(DateFormat.SHORT).format(
                            st.getDateOfBirth());
                case 4:
                    try {
                        return ms.getGroupNameFromId(st.getGroupId());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        }
        return null;
    }

    //метод, который возвращает студента по номеру строки

    public Student getStudent(int rowIndex) {
        if (students != null) {
            if (rowIndex < students.size() && rowIndex >= 0) {
                return (Student) students.get(rowIndex);
            }
        }
        return null;
    }
}