import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToDoList implements ActionListener {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
    }

    JButton button;
    JTextField textFieldTodo;

    public ToDoList() {
        JFrame todoView = new JFrame();
        todoView.setTitle("To Do List");
        todoView.setResizable(false);
        todoView.setSize(400,700);
        todoView.setLayout(new FlowLayout());

        button = new JButton("Add");
        button.addActionListener(this);

        todoView.add(button);
        textFieldTodo = new JTextField();
        textFieldTodo.setPreferredSize(new Dimension(400,40));
        todoView.add(textFieldTodo);

        todoView.pack();
        todoView.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println(textFieldTodo.getText());
        }

    }

}