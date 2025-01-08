import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToDoList implements ActionListener {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
    }

    JFrame todoView;
    JButton button;
    JTextField textFieldTodo;
    JPanel inputPanel;


    public ToDoList() {
        todoView = new JFrame();
        todoView.setTitle("To Do List");
        todoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //todoView.setResizable(false);
        todoView.setSize(400,700);
        todoView.setLayout(new BoxLayout(todoView.getContentPane(), BoxLayout.Y_AXIS));

        inputPanel = new JPanel();

        ImageIcon image = new ImageIcon("Assets/appIcon.png");
        todoView.setIconImage(image.getImage());

        button = new JButton("Add");
        button.addActionListener(this);
        inputPanel.add(button);

        textFieldTodo = new JTextField();
        textFieldTodo.setPreferredSize(new Dimension(400,40));
        inputPanel.add(textFieldTodo);

        todoView.add(inputPanel);
        todoView.pack();
        todoView.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            getTodoElement(textFieldTodo.getText());
            textFieldTodo.setText("");
        }

    }

    public void getTodoElement(String text) {
        JLabel todoElement = new JLabel(text);

        todoView.add(todoElement);
        todoView.revalidate();
        todoView.repaint();
    }

}