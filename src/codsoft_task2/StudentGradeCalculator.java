
package Codsoft_task2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class StudentGradeCalculator {

    private JFrame frame;
    private JTextField[] subjectFields;
    private JTextField totalField, avgField, gradeField;
    
    public StudentGradeCalculator() {
        frame = new JFrame("Student Grade Calculator");
        frame.setSize(1400, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

      JLabel heading = new JLabel("STUDENT GRADE CALCULATOR", SwingConstants.CENTER);
        heading.setBounds(0, 5, 1500, 80); // Positioning the heading at the top
        heading.setFont(new Font("Verdana", Font.BOLD, 56)); // Large font size
        heading.setForeground(new Color(0, 102, 204));
        frame.add(heading);
        
        JLabel heading3 = new JLabel("RESULT", SwingConstants.CENTER);
        heading3.setBounds(0, 100, 1500, 80); // Positioning the heading at the top
        heading3.setFont(new Font("Serif", Font.BOLD, 46)); // Large font size
        heading3.setForeground(Color.RED);
        frame.add(heading3);
        
         JLabel heading2 = new JLabel("(Enter Marks out of 100)");
        heading2.setBounds(40, 90, 1500, 80); // Positioning the heading at the top
        heading2.setFont(new Font("Verdana", Font.BOLD, 26)); // Large font size
        heading2.setForeground(Color.GREEN);
        frame.add(heading2);
        
        subjectFields = new JTextField[5];
        String[] subjects = {"Subject 1", "Subject 2", "Subject 3", "Subject 4", "Subject 5"};

        for (int i = 0; i < subjects.length; i++) {
            JLabel label = new JLabel(subjects[i] + ":");
            label.setBounds(50, 180 + (i * 90), 400, 30);
            label.setFont(new Font("serif", Font.BOLD, 25));
            frame.add(label);

            subjectFields[i] = new JTextField();
            subjectFields[i].setBounds(230, 180 + (i * 90), 150, 30);
            subjectFields[i].setFont(new Font("Serif", Font.BOLD, 20));
            subjectFields[i].setForeground(Color.BLUE);
            frame.add(subjectFields[i]);
        }

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(750, 580, 240, 50);
        calculateButton.setBackground(Color.BLUE);
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        frame.add(calculateButton);

        JLabel totalLabel = new JLabel("Total Marks:");
        totalLabel.setBounds(600, 230, 300, 30);
         totalLabel.setFont(new Font("serif", Font.BOLD, 30));
        frame.add(totalLabel);

        totalField = new JTextField();
        totalField.setBounds(800, 230, 100, 30);
        totalField.setFont(new Font("Serif", Font.BOLD, 25));
        totalField.setForeground(Color.BLUE);
       totalField.setEditable(false);
        frame.add(totalField);

        JLabel avgLabel = new JLabel("Average %:");
        avgLabel.setBounds(600, 330, 300, 40);
         avgLabel.setFont(new Font("serif", Font.BOLD, 30));
        frame.add(avgLabel);

        avgField = new JTextField();
        avgField.setBounds(800, 340, 100, 30);
        avgField.setFont(new Font("Serif", Font.BOLD, 25));
        avgField.setForeground(Color.BLUE);
        avgField.setEditable(false);
        frame.add(avgField);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(600, 430, 200, 30);
         gradeLabel.setFont(new Font("serif", Font.BOLD, 30));
        frame.add(gradeLabel);

        gradeField = new JTextField();
        gradeField.setBounds(800, 440, 100, 34);
        gradeField.setFont(new Font("Serif", Font.BOLD, 35));
        gradeField.setForeground(Color.RED);
        gradeField.setEditable(false);
        frame.add(gradeField);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int totalMarks = 0;
                    for (int i = 0; i < subjectFields.length; i++) {
                        totalMarks += Integer.parseInt(subjectFields[i].getText());
                    }

                    double averagePercentage = totalMarks / 5.0;
                    String grade;
                    if (averagePercentage >= 90) grade = "A+";
                    else if (averagePercentage >= 80) grade = "A";
                    else if (averagePercentage >= 70) grade = "B";
                    else if (averagePercentage >= 60) grade = "C";
                    else grade = "D";

                    totalField.setText(String.valueOf(totalMarks));
                    avgField.setText(String.valueOf(averagePercentage));
                    gradeField.setText(grade);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

         File imgFile1 = new File("C:\\Users\\Administrator\\Downloads\\icons\\test-grade-calculator.png");
        if (!imgFile1.exists()) {
            System.err.println("File not found: " + imgFile1.getAbsolutePath());
        } else {
            ImageIcon i1 = new ImageIcon(imgFile1.getAbsolutePath());
            Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT); // Scale to desired size
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(350, 80, 1500, 500); // Set bounds
            frame.add(image);
        }
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentGradeCalculator();
    }
}
