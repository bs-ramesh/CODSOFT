import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TASK2 extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public TASK2() {
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Total words: ");

        countButton.addActionListener(this);

        add(textArea, BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = textArea.getText();
            int totalWords = countWords(text);
            resultLabel.setText("Total words: " + totalWords);
        }
    }

    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        int count = 0;

        for (String word : words) {
            if (!word.trim().isEmpty()) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TASK2 frame = new TASK2();
        frame.setTitle("Word Counter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
