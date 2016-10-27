import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by arredon on 10/27/2016.
 */
public class Screen extends JFrame {
    private static int xMax = 1200;     //x dimension of frame
    private static int yMax = 700;      //y dimension of frame
    private int screenPos;              //0-3 for list selection
    private Point labelPos;             //Position of screen label (i.e. "main menu", "account menu", etc.)
    private Dimension buttonSize;       //size of buttons
    private Color background;           //color of background

    private JTextArea textArea;         //Task description area
    private JButton exit;               //exit button
    private Container c;
    private JList list;                 //stores task or user list
    private JLabel listLabel;
    private DefaultListModel listModel;
    private JTextField username, taskTitle;     //username and task title fields

    public Screen(String title) {
        super(title);
        buttonSize = new Dimension(200,30);
        labelPos = new Point((xMax/2) - 50, 20);
        background = new Color(170,170,120);

        listModel = new DefaultListModel();
        textArea = new JTextArea();


        textArea = null;
        exit = null;
        c = null;

        setLayout(null);

    }

    /*
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Serif", Font.PLAIN, 12));
        //g2.drawString("Hello, World!", 50, 50);

        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        printHouse(g);
    }
    */

    public void printHouse(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        HouseNode temp;
        HouseList list = new HouseList();
        for (int i = 0; i < 10; ++i) {
            temp = new HouseNode();
            temp.generateRandHouse();
            list.insert(temp);
        }

        //g2.drawString(list.printList(), 30, 30);
        drawString(g2, list.printList(), 30, 30);
        /*
        g2.drawString(list.printCurrent(), 30, 30);
        list.moveNext();
        g2.drawString(list.printCurrent(), 30, 50);
        list.moveNext();
        g2.drawString(list.printCurrent(), 30, 70);
        list.moveNext();
        */
    }

    //print text blocks on multiple lines
    public void drawString(Graphics g, String text, int x, int y) {
        for (String line: text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
}
