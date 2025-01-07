import javax.swing.*;


public class ToDoList {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
    }
    public ToDoList() {
        JFrame todoView = new JFrame();
        todoView.setTitle("To Do List");
        todoView.setResizable(false);
        todoView.setSize(600,700);
        todoView.setVisible(true);
    }
}