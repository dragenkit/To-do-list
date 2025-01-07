import javax.swing.*;
import java.awt.*;


public class ToDoList {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
    }
    public ToDoList() {
        JFrame todoView = new JFrame();
        todoView.setTitle("To Do List");
        todoView.setResizable(false);
        todoView.setPreferredSize(new Dimension(400,600));
        todoView.setLayout(new GridLayout(1, 1));


        JTextField textFieldTodo = new JTextField();
        textFieldTodo.setPreferredSize(new Dimension(400,40));
        todoView.add(textFieldTodo);

        todoView.pack();
        todoView.setVisible(true);

    }
}