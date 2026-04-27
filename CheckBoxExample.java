// A program to show use of CheckBox
import javax.swing.*;
public class CheckBoxExample
{
 CheckBoxExample(){
 JFrame f= new JFrame("CheckBox Example");
 JCheckBox checkBox1 = new JCheckBox("C++");
 checkBox1.setBounds(100,100, 50,50);
 JCheckBox checkBox2 = new JCheckBox("Java", true);
 checkBox2.setBounds(100,150, 50,50);
// Add this below the checkboxes
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
 if (checkBox1.isSelected()) msg += "C++ ";
 if (checkBox2.isSelected()) msg += "Java ";
 label.setText(msg);
});
 f.add(checkBox1);
 f.add(checkBox2);
 f.setSize(400,400);
 f.setLayout(null);
 f.setVisible(true);
 }
 public static void main(String args[]){
 new CheckBoxExample();
 }
}