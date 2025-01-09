import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToDoList implements ActionListener {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
    }

    JFrame todoView;
    JButton button;
    JTextField textFieldTodo;
    JPanel inputPanel;
    JPanel todoListPanel;

    public ToDoList() {
        // Window
        todoView = new JFrame();
        todoView.setTitle("To Do List");
        todoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        todoView.setLayout(new BorderLayout());
        // Icon
        ImageIcon image = new ImageIcon("Assets/appIcon.png");
        todoView.setIconImage(image.getImage());

        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        todoListPanel = new JPanel();
        todoListPanel.setLayout(new BoxLayout(todoListPanel, BoxLayout.Y_AXIS));



        button = new JButton("Add");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(90,40));
        inputPanel.add(button);

        textFieldTodo = new JTextField();
        textFieldTodo.setPreferredSize(new Dimension(380,40));
        inputPanel.add(textFieldTodo);

        todoView.add(inputPanel, BorderLayout.NORTH);
        todoView.add(todoListPanel, BorderLayout.CENTER);
        todoView.pack();
        todoView.setSize(500,700);
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
        JLabel todoElement = new JLabel("•" + text);
        todoElement.setFont(todoElement.getFont().deriveFont((float) 20));
        todoListPanel.add(todoElement, BorderLayout.NORTH);
        todoView.revalidate();
        todoView.repaint();
    }

}