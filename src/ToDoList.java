import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToDoList implements ActionListener {

    JFrame todoView;
    JButton button;
    JTextField textFieldTodo;
    JPanel inputPanel, todoListPanel, completedTodos;
    Color brown, lightBrown, black;

    public ToDoList() {
        // Window
        todoView = new JFrame();
        todoView.setTitle("To Do List");
        todoView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        todoView.setLayout(new BorderLayout());
        // Icon
        ImageIcon image = new ImageIcon("Assets/appIcon.png");
        todoView.setIconImage(image.getImage());

        // Color
        black = new Color(38, 38, 38);
        brown = new Color(128, 64, 0);
        lightBrown = new Color(191, 128, 64);

        // Panel where the Todo item is written
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBackground(Color.black);

        // Panel where the to do list is shown
        todoListPanel = new JPanel();
        todoListPanel.setLayout(new BoxLayout(todoListPanel, BoxLayout.Y_AXIS));
        todoListPanel.setBackground(black);

        // Panel where the completed task are shown
        completedTodos = new JPanel();
        completedTodos.setLayout(new BoxLayout(completedTodos, BoxLayout.Y_AXIS));
        completedTodos.setBackground(black);


        button = new JButton("Add");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(90,40));
        button.setBorderPainted(false);
        inputPanel.add(button);

        textFieldTodo = new JTextField();
        textFieldTodo.setPreferredSize(new Dimension(380,40));
        textFieldTodo.setBorder(BorderFactory.createEmptyBorder());
        textFieldTodo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTodoElement(textFieldTodo.getText());
                    textFieldTodo.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        inputPanel.add(textFieldTodo);

        todoView.add(inputPanel, BorderLayout.NORTH);
        todoView.add(todoListPanel, BorderLayout.CENTER);
        todoView.add(completedTodos, BorderLayout.SOUTH);
        todoView.pack();
        todoView.setSize(500,700);
        todoView.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            addTodoElement(textFieldTodo.getText());
            textFieldTodo.setText("");
        }

    }

    public void addTodoElement(String text) {
        if(text == null || text.trim().isEmpty()){
            JOptionPane.showMessageDialog(todoView, "Text field cannot be Empty");
            return;
        }
        JLabel todoElement = new JLabel("• " + text.trim());
        todoElement.setFont(todoElement.getFont().deriveFont((float) 20));
        todoElement.setForeground(Color.white);
        todoElement.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        todoElement.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                todoElement.setText(("<html><strike>" + todoElement.getText() + "</strike></html>"));
                completedTodos.add(todoElement);
                todoListPanel.remove(todoElement);
                todoView.revalidate();
                todoView.repaint();
            }
        });
        todoListPanel.add(todoElement);
        todoView.revalidate();
        todoView.repaint();
    }

}