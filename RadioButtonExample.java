// A program to show use of RadioButton
import javax.swing.*;
public class RadioButtonExample {
JFrame f;
RadioButtonExample(){
f=new JFrame();
JRadioButton r1=new JRadioButton("A) Male");
JRadioButton r2=new JRadioButton("B) Female");

// Add this below the RadioButton
JButton b = new JButton("Show");
b.setBounds(100, 200, 100, 30);
f.add(b);
// Label to display selection
JLabel label = new JLabel();
label.setBounds(100, 250, 200, 30);
f.add(label);
// Action listener
b.addActionListener(e -> {
 String msg = "Selected: ";
 if (r1.isSelected()) msg += "Male ";
 if (r2.isSelected()) msg += "Female ";
 label.setText(msg);
});
r1.setBounds(75,50,100,30);
r2.setBounds(75,100,100,30);
ButtonGroup bg=new ButtonGroup();
bg.add(r1);bg.add(r2);
f.add(r1);f.add(r2);
f.setSize(300,300);
f.setLayout(null);
f.setVisible(true);
}
public static void main(String[] args) {
 new RadioButtonExample();
}}