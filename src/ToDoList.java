import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToDoList implements ActionListener {

    JFrame todoView;
    JButton button;
    JTextField textFieldTodo;
    JPanel inputPanel, todoListPanel, completedTodos;
    Color black;
    JScrollPane todoScrollPane, completedScrollPane;

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

        // Panel where the Todo item is written
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBackground(Color.black);

        // Panel where the to do list is shown
        todoListPanel = new JPanel();
        todoListPanel.setLayout(new BoxLayout(todoListPanel, BoxLayout.Y_AXIS));
        todoListPanel.setBackground(black);

        // adds todolist panel to scroll pane
        todoScrollPane = new JScrollPane(todoListPanel);
        todoScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        todoScrollPane.setPreferredSize(new Dimension(500, 300));

        // Panel where the completed task are shown
        completedTodos = new JPanel();
        completedTodos.setLayout(new BoxLayout(completedTodos, BoxLayout.Y_AXIS));
        completedTodos.setBackground(black);

        // adds todolist to completedScrollPane
        completedScrollPane = new JScrollPane(completedTodos);
        completedScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        completedScrollPane.setPreferredSize(new Dimension(500, 300));

        // adds Button to inputPanel
        button = new JButton("Add");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(90,40));
        button.setBorderPainted(false);
        inputPanel.add(button);

        textFieldTodo = new JTextField();
        textFieldTodo.setPreferredSize(new Dimension(380,40));
        textFieldTodo.setBorder(BorderFactory.createEmptyBorder());
        // when the enter key gets pressed the texfield sends the text
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
        todoView.add(todoScrollPane, BorderLayout.CENTER);
        todoView.add(completedScrollPane, BorderLayout.SOUTH);
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
        // when the textfield is empty show box and return
        if(text == null || text.trim().isEmpty()){
            JOptionPane.showMessageDialog(todoView, "Text field cannot be Empty");
            return;
        }
        if(text.trim().length() > 41){
            JOptionPane.showMessageDialog(todoView, "Your text is to long please use a shorter one");
            return;
        }
        //
        if(text.trim().length() < 41){
            String[]
        }
        JLabel todoElement = new JLabel("• " + text.trim());
        todoElement.setFont(todoElement.getFont().deriveFont((float) 20));
        todoElement.setForeground(Color.white);
        todoElement.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        // if todo element is clicked it gets send to the bottom
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