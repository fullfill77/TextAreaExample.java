import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StudentGradeCalculator {
 public static void main(String[] args) {
 JFrame frame = new JFrame("Student Grade Calculator");
 frame.setSize(400, 350);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setLayout(new GridLayout(7, 2, 10, 10));
 JLabel nameLabel = new JLabel("Student Name:");
 JTextField nameField = new JTextField();
 JLabel m1Label = new JLabel("Subject 1 Marks:");
 JTextField m1Field = new JTextField();
 JLabel m2Label = new JLabel("Subject 2 Marks:");
 JTextField m2Field = new JTextField();
 JLabel m3Label = new JLabel("Subject 3 Marks:");
 JTextField m3Field = new JTextField();
 JButton calcButton = new JButton("Calculate Grade");
 JLabel resultLabel = new JLabel("Result will appear here");
 frame.add(nameLabel);
 frame.add(nameField);
 frame.add(m1Label);
 frame.add(m1Field);
 frame.add(m2Label);
 frame.add(m2Field);
 frame.add(m3Label);
 frame.add(m3Field);
 frame.add(new JLabel()); // empty cell
 frame.add(calcButton);
 frame.add(new JLabel()); // empty cell
 frame.add(resultLabel);
 calcButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 try {
 String name = nameField.getText();
 int m1 = Integer.parseInt(m1Field.getText());
 int m2 = Integer.parseInt(m2Field.getText());
 int m3 = Integer.parseInt(m3Field.getText());
 int total = m1 + m2 + m3;
 double avg = total / 3.0;
 String grade;
 if (avg >= 90) grade = "A";
 else if (avg >= 75) grade = "B";
 else if (avg >= 50) grade = "C";
 else grade = "Fail";
 resultLabel.setText("<html>" + name + "<br>Total: " + total + "<br>Average: "
+ avg + "<br>Grade: " + grade + "</html>");
 } catch (NumberFormatException ex) {
 resultLabel.setText("Please enter valid marks.");
 }
 }
 });
 frame.setVisible(true);
 }
}